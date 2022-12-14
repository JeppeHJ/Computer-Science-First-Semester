package Opgave5;

public abstract class Vare {
    private double price;
    private String name;
    private String description;

    public Vare(double price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return this.name + " | Price: " + this.calcSalesPrice() + "\n";
    }

    public abstract double calcSalesPrice();
}
