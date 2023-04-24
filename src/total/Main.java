package total;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Итоговая домашняя работа
 *
 * @autor Ochirov Andrey(o41rov)
 * <p>
 * In: JSON
 * Out: JSON
 */

public class Main {

    /**
     * Метод по сериализации JSON файла в Map
     *
     * @param filePath (путь к файлу для чтения)
     * @return (возвращает Map на основе JSON из filePath
     */

    public static Map<String, Map<String, String>> readFromJson(String filePath) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            Map<String, Map<String, String>> map = gson.fromJson(reader, Map.class);
            reader.close();
            return map;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Метод записи объекта obj в файл fileName
     *
     * @param obj      (объект для записи в JSON)
     * @param fileName (путь к файлу для записи, перезаписывается, если существует, если нет, то создаётся)
     */

    public static void writeToJSON(Object obj, String fileName) {
        try {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            //gson.toJson(obj, new FileWriter(fileName));
            FileWriter fileWriter = new FileWriter(new File(fileName));
            gson.toJson(obj, fileWriter);
            fileWriter.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param args
     * @throws FileNotFoundException
     */

    public static void main(String[] args) {
        //Сериализуем данные из файлов товаров и продаж, данные помещаются в ArrayList
        Map<String, Map<String, String>> goodsMap = readFromJson("C:/my/java/croc/src/total/goods.json");
        ArrayList<Good> goods = new ArrayList<>();
        for (Map.Entry<String, Map<String, String>> entry : goodsMap.entrySet()) {
            goods.add(new Good(Integer.parseInt(entry.getKey()), entry.getValue().get("name")));
        }
        Map<String, Map<String, String>> salesMap = readFromJson("C:/my/java/croc/src/total/sales.json");
        ArrayList<Sale> sales = new ArrayList<>();
        for (Map.Entry<String, Map<String, String>> entry : salesMap.entrySet()) {
            sales.add(new Sale(
                    Integer.parseInt(entry.getKey()),
                    Integer.parseInt(entry.getValue().get("idSeller")),
                    Integer.parseInt(entry.getValue().get("idGood")),
                    Integer.parseInt(entry.getValue().get("quantity")),
                    entry.getValue().get("date")));
        }

        //Первое задание

        //Проходим по массиву товаров и ищем продажи в массиве sales с текущим id товара
        ArrayList<First> result = new ArrayList<>();
        for (int i = 0; i < goods.size(); i++) {
            int idGood = goods.get(i).getId();
            int quantity = 0;
            for (Sale elem : sales) {
                if (elem.getIdGood() == idGood) {
                    quantity += elem.getQuantity();
                }
            }
            First first = new First(idGood, quantity);
            result.add(first);
        }
        writeToJSON(result, "C:/my/java/croc/src/total/firstOut.json");

        //Второе задание

        //Создаём Set дат для унифицирования каждой даты, при поиске добавляем количество в соответствующий массив
        //по тому же индексу, который совпадает с индексом даты в Set, представленном в виде List

        ArrayList<Second> result2 = new ArrayList<>();
        Set<String> dates = new HashSet<>();
        sales.forEach(
                elem -> dates.add(elem.getDate())
        );
        int[] quantities = new int[dates.size()];

        for (int i = 0; i < sales.size(); i++) {
            int idx = Arrays.asList(dates.toArray()).indexOf(sales.get(i).getDate());
            quantities[idx] += sales.get(i).getQuantity();
        }

        //Собираем результирующий массив экземпляров класса сериализации для второго задания

        int i = 0;
        for (String date : dates) {
            result2.add(new Second(date, quantities[i]));
            i++;
        }

        writeToJSON(result2, "C:/my/java/croc/src/total/secondOut.json");
    }
}
