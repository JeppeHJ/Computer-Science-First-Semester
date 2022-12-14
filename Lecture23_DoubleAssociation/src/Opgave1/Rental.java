package Opgave1;

import java.util.ArrayList;

public class Rental {
    private static int rentalNumber;
    private int number;
    private int days;
    private String date;
    private ArrayList<Car> cars;

    public Rental(int days, String date) {
        rentalNumber++;
        this.number = rentalNumber;
        this.days = days;
        this.date = date;
        this.cars = new ArrayList<>();
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void addCar(Car car) {
        if (!(this.cars.contains(car))) {
            this.cars.add(car);
            car.addRental(this);
        }
    }

    public void removeCar(Car car) {
        if (this.cars.contains(car)) {
            this.cars.remove(car);
            car.removeRental(this);
        }
    }

    public int getPrice() {
        int sum = 0;
        for (Car car: this.cars) {
            sum += car.getPricePerDay() * this.days;
        }

        return sum;
    }


}
