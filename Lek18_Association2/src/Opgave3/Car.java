package Opgave3;

public class Car {
    private String license;

    private double pricePerDay;
    private int purchaseYear;


    public Car(String license, int year, double pricePerDay) {
        this.license = license;
        this.purchaseYear = year;
        this.pricePerDay = pricePerDay;
    }

    public void setPricePerDay(double price) {
        this.pricePerDay = price;
    }

    public double getPricePerDay() {
        return this.pricePerDay;
    }


    public String getLicense() {
        return license;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }


}
