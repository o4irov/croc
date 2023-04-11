package fivth;

import java.util.*;

/**
 * Нормализация заданного в файле пути(удалить лишние переходы)
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //вызываем метод парсинга данных из файла в строку(метод из пакета "fourth" класса FromFile)
        String wrongPath = in.next();
        //создаём список, состоящий из элементов пути
        List<String> pathElements = new ArrayList(List.of(wrongPath.split("/")));
        //удаляем все символы, обозначающие текущую директорию, т.к. она не существенна на данном этапе
        pathElements.remove(".");
        //подсчёт поднятий на уровень вверх в пути и строка с результатом
        int count = 0;
        //проход по списку и добавление "существенных" элементов пути в очередь
        Queue<String> buffer = new ArrayDeque<String>();
        for (int i = pathElements.size() - 1; i > -1; i--) {
            if (pathElements.get(i).equals("..")) {
                count++;
                continue;
            } else if (count == 0) {
                buffer.add(pathElements.get(i) + "/");
                continue;
            } else {
                count--;
            }
        }
        String rightPath = "";
        //проход по очереди и добавление в строку с ответом
        Iterator<String> dequeIterator = buffer.iterator();
        while (dequeIterator.hasNext()) {
            rightPath += dequeIterator.next();
        }

        //вывод относительно count
        if (count == 0) {
            System.out.println("./" + rightPath.substring(0, rightPath.length() - 1));
        } else {
            System.out.println("../".repeat(count) + rightPath.substring(0, rightPath.length() - 1));
        }
    }
}