package Opgave4;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Bolig {
    private int squareKilometers;
    private String address;
    private int pricePerMonth;
    private Kollegie kollegie;
    private ArrayList<Lejeaftale> lejeaftaler;

    Bolig(int squareKilometers, String address, int pricePerMonth, Kollegie kollegie) {
        this.squareKilometers = squareKilometers;
        this.address = address;
        this.pricePerMonth = pricePerMonth;
        this.kollegie = kollegie;
        this.lejeaftaler = new ArrayList<>();
    }

    public Kollegie getKollegie() {
        return this.kollegie;
    }

    public Lejeaftale createLejeAftale(LocalDate fromDate) {
        Lejeaftale lejeaftale = new Lejeaftale(fromDate, this);
        this.lejeaftaler.add(lejeaftale);
        return lejeaftale;
    }

    public void endLejeAftale(Lejeaftale lejeaftale, LocalDate endDate) {
        if (this.lejeaftaler.contains(lejeaftale)) {
            lejeaftale.setToDate(endDate);
        }
    }

    public ArrayList<Lejeaftale> getLejeAftaler() {
        return this.lejeaftaler;
    }

    public void removeLejeAftale(Lejeaftale lejeaftale) {
        if (this.lejeaftaler.contains(lejeaftale)) {
            this.lejeaftaler.remove(lejeaftale);
        }
    }

    public int getSquareKilometers() {
        return squareKilometers;
    }

    public void setSquareKilometers(int squareKilometers) {
        this.squareKilometers = squareKilometers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(int pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }
}
