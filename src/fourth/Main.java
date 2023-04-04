package fourth;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Чтение из файла и подсчёт слов в нём
 */

public class Main {
    //функция для чтения из файла в строку, путь к файлу задаётся первым аргументом командной строки
    public static String readFileToString(String[] args) {
        //проверка на наличие пути к файлу
        if (args.length == 0) {
            throw new IllegalArgumentException("Путь к файлу не указан в аргументах командной строки.");
        }
        String data = null;
        Path filePath = Paths.get(args[0]);
        try {
            byte[] fileBytes = Files.readAllBytes(filePath);
            data = new String(fileBytes);
        } catch (IOException e) {
            System.err.println("Ошибка открытия файла: " + e.getMessage());
        }
        return data;
    }
    public static void main(String[] args) {
        //обработка ошибки отсутствия пути к файлу в переменной командной строки
        try{
            //вызываем метод парсинга данных из файла в строку и заменяем лишние пробелы, переносы строк на один пробел
            String fileString = readFileToString(args).replaceAll("\\s+", " ");
            //разбиваем полученную строку на слова и находим его длину
            ArrayList<String> words = new ArrayList<>(List.of(fileString.split(" ")));
            System.out.println(words.size());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}