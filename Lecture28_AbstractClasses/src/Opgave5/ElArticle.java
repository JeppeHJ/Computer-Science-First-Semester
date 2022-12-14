package Opgave5;

public class ElArticle extends Vare {
    private final double tax;
    private double avgEnergyPerHour;

    public ElArticle(double price, String name, String description, double avgEnergyPerHour) {
        super(price, name, description);
        this.tax = 1.30;
        this.avgEnergyPerHour = avgEnergyPerHour;
    }

    public double calcSalesPrice() {
        if (this.getPrice() * (this.tax - 1) < 3) {
            return this.getPrice() + 3;
        } else {
            return this.getPrice() * this.tax;
        }
    }
}
