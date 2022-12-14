package Opgave5;

public class Food extends Vare {
    private final double tax;
    private int expirationDays;

    public Food(double price, String name, String description, int expirationDays) {
        super(price, name, description);
        this.tax = 1.05;
        this.expirationDays = expirationDays;
    }

    public double calcSalesPrice() {
        return this.getPrice() * this.tax;
    }
}
