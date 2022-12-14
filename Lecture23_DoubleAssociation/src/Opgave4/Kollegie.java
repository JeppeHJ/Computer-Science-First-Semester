package Opgave4;

import java.util.ArrayList;

import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

public class Kollegie {
    private String name;
    private String address;
    private ArrayList<Bolig> boliger;

    public Kollegie(String name, String address) {
        this.name = name;
        this.address = address;
        this.boliger = new ArrayList<>();

    }

    public Bolig createBolig(int squareKilometers, String address, int pricePerMonth) {
        Bolig bolig = new Bolig(squareKilometers, address, pricePerMonth, this);
        this.boliger.add(bolig);
        return bolig;
    }

    /*public void addBolig(Bolig bolig) {
        if (!(this.boliger.contains(bolig))) {
            this.boliger.add(bolig);
            bolig.setKollegie(this);
        }
    }*/

    public void removeBolig(Bolig bolig) {
        if (this.boliger.contains(bolig)) {
            this.boliger.remove(bolig);
        }
    }


    public int getAntalLejeAftaler() {
        int antal = 0;
        for (Bolig bolig: this.boliger) {
            antal += bolig.getLejeAftaler().size();
        }

        return antal;
    }

    public double gennemsnitligAntalDage() {
        double antalLejeAftaler = 0;
        double totalDays = 0;
        for (int i = 0; i <= this.boliger.size() - 1; i++) {
            for (Lejeaftale lejeaftale : this.boliger.get(i).getLejeAftaler()) {
                if (!(lejeaftale.getToDate() == null)) {
                    antalLejeAftaler++;
                    totalDays += DAYS.between(lejeaftale.getFromDate(), lejeaftale.getToDate());
                }
            }
        }

        return totalDays / antalLejeAftaler;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
