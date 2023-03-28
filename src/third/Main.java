package third;

import java.util.Scanner;

/**
 * В этом классе происходит проверка выбрасывания исключений классом Chess
 *
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //переменная для распознавания, верно ли пользователь ввёл данные
        boolean isValid = false;
        //в цикле принимаем значения x, y пока пользователь не введёт валидное значение
        while(!isValid){
            try {
                System.out.println("Введите значения 2 координат: ");
                int x = in.nextInt();
                int y = in.nextInt();
                Chess chess = new Chess();
                //проверка выбрасывания исключения конструктором
                Chess chess1 = new Chess(x, y);
                //проверка выбрасывания исключения setter`ами
                chess.setX(x);
                chess.setY(y);

                System.out.println(chess);
                isValid = true;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage() + ". Введите значения повторно");
            }
        }
    }
}