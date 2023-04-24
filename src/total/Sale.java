package total;

/**
 * Класс для десериализации JSON с продажами
 */

public class Sale {
    private int idSale;
    private int idSeller;
    private int idGood;
    private int quantity;
    private String date;

    public Sale(int idSale, int idSeller, int idGood, int quantity, String date) {
        this.idSale = idSale;
        this.idSeller = idSeller;
        this.idGood = idGood;
        this.quantity = quantity;
        this.date = date;
    }

    public int getIdSale() {
        return idSale;
    }

    public int getIdSeller() {
        return idSeller;
    }

    public int getIdGood() {
        return idGood;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }
}