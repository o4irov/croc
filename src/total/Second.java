package total;

/**
 * Класс для сериализации JSON для второго задания
 */

public class Second {
    private String date;
    private int quantity;

    public Second(String date, int quantity) {
        this.date = date;
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }
}
