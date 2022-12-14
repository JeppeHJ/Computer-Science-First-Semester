package Opgave1;

import java.util.ArrayList;

public class Car {
    private String license;

    private double pricePerDay;
    private int purchaseYear;
    private ArrayList<Rental> rentals;


    public Car(String license, int year, double pricePerDay) {
        this.license = license;
        this.purchaseYear = year;
        this.pricePerDay = pricePerDay;
        this.rentals = new ArrayList<>();
    }

    public void addRental(Rental rental) {
        if (!(this.rentals.contains(rental))) {
            this.rentals.add(rental);
            rental.addCar(this);
        }
    }

    public void removeRental(Rental rental) {
        if (this.rentals.contains(rental)) {
            this.rentals.remove(rental);
            rental.removeCar(this);
        }
    }

    public ArrayList<Rental> getRentals() {
        return this.rentals;
    }

    public int getMaxDays() {
        int highestNumber = 0;
        for (Rental days: this.rentals) {
            if (days.getDays() > highestNumber) {
                highestNumber = days.getDays();
            }
        }

        return highestNumber;
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
