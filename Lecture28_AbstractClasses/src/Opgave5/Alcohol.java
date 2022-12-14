package Opgave5;

public class Alcohol extends Vare {
    private double tax;
    private double alcoholPercentage;

    public Alcohol(double price, String name, String description, double alcoholPercentage) {
        super(price, name, description);
        this.alcoholPercentage = alcoholPercentage;
        this.calcTaxRate();
    }

    public void calcTaxRate() {
        if (this.getPrice() > 90) {
            this.tax = 2.20;
        } else {
            this.tax = 1.80;
        }
    }

    public double calcSalesPrice() {
        return this.getPrice() * this.tax;
    }
}
