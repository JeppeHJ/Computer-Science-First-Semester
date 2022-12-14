package Opgave1;

import java.util.ArrayList;

// The Parkeringshus class represents a parking garage

public class Parkeringshus {
    // List of parking spaces in the garage
    private ArrayList<Parkeringsplads> parkeringspladser = new ArrayList<>();
    private String adresse;
    private int saldo;

    // Constructor
    public Parkeringshus(String adresse) {
        this.adresse = adresse;

    }

    // Method to add a new parking space to the garage
    public Parkeringsplads createParkeringsplads(int nummer) {
        Parkeringsplads p = new Parkeringsplads(nummer, this);
        parkeringspladser.add(p);
        return p;
    }

    public Invalideplads createInvalideplads(double area, int nummer) {
        Invalideplads i = new Invalideplads(area, nummer, this);
        parkeringspladser.add(i);
        return i;
    }

    public ArrayList<Parkeringsplads> getParkeringspladser() {
        return new ArrayList<>(this.parkeringspladser);
    }

    // Method to remove a parking space from the garage
    public void removeParkering(Parkeringsplads p) {
        parkeringspladser.remove(p);
    }

    public void addToSaldo(int amount) {
        this.saldo += amount;
    }

    public int antalLedigePladser() {
        int ledigepladser = 0;
        for (Parkeringsplads parkeringsplads: parkeringspladser) {
            if (parkeringsplads.getAnkomst() == null) {
                ledigepladser++;
            }
        }

        return ledigepladser;
    }

    //Opgave S3
    //Function that finds a specific car based on registration number
    public int findPladsMedBil(String regNummer) {
        for (Parkeringsplads parkeringsplads: parkeringspladser) {
            if (parkeringsplads.getBil().getRegNr() == regNummer) {
                return parkeringsplads.getNummer();
            }
        }

        return -1;
    }


}