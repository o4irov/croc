package third;

/**
 * Определяем класс, который содержит поля x, y(координаты на шахматной доске при отсчёте от левого нижнего угла)
 * во все изменения полей извне добавлен функционал выбрасывания исключения
 * конструктор по умолчанию возвращает 0, 0
 * переопределённый метод toString возвращает "шахматные координаты на реальной доске" (a1)
 */

public class Chess {
    private int x;
    private int y;

    public Chess(){
        this.x = 0;
        this.y = 0;
    }

    public Chess(int x, int y){
        if(x < 0 || x > 7 || y < 0 || y > 7){
            throw new IllegalArgumentException("Недопустимый аргумент, ожидаемое значение должно содержаться в диапазоне [0,7]");
        }
        else{
            this.x = x;
            this.y = y;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x){
        if(x < 0 || x > 7){
            throw new IllegalArgumentException("Недопустимый аргумент, ожидаемое значение должно содержаться в диапазоне [0,7]");
        }
        else{
            this.x = x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if(y < 0 || y > 7){
            throw new IllegalArgumentException("Недопустимый аргумент, ожидаемое значение должно содержаться в диапазоне [0,7]");
        }
        else{
            this.y = y;
        }
    }

    @Override
    public String toString() {
        char c = (char) (this.x + 97);
        return c + String.valueOf(++this.y);
    }
}
