package sixth;

public class Main {
    /**
     * Пример входной строки.
     */
    public static final String INPUT_STRING = "Невежество есть мать промышленности, как и суеверий." +
            " Сила размышления и воображения подвержена ошибкам; но привычка двигать рукой или ногой" +
            " не зависит ни от того, ни от другого. Поэтому мануфактуры лучше всего процветают там, где" +
            " наиболее подавлена духовная жизнь, так что мастерская может рассматриваться как машина," +
            " части которой составляют люди. ";

    /**
     * Шаблон поиска символов в строке.
     */
    public static final String TEMPLATE = " ";

    /**
     * Оптимизированный многопоточностью поиск пробелов в строке
     *
     * @param args аргументы командной строки.
     * @autor Andrey Ochirov aka o41rov
     */
    public static void main(String[] args) {

        long current = System.currentTimeMillis();

        //преобразуем строку в поток чисел с последующим преобразованием в символы
        int sum = (int) INPUT_STRING.chars()
                //параллельная обработка потока всеми доступными средствами процессора
                .parallel()
                //подсчитываем количество символов, удовлетворяющих условию
                .mapToObj(c -> (char) c).filter(ch -> Matcher.match(ch.toString(), TEMPLATE)).count();

        System.out.println("Count of space: " + sum);

        System.out.println("Time: " + (System.currentTimeMillis() - current) / 1000 + " c.");
    }
}
