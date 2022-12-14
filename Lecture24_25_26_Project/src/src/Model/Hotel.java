package src.Model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private String adress;
    private double prisNetflix;
    private double prisBad;
    private double prisMad;
    private double prisPrDagEnkelt;

    private double prisPrDagDobbelt;
    private boolean enkeltVaerelse;

    private ArrayList<Tilmelding> tilmeldinger;

    public Hotel(String navn, String adress, double prisNetflix, double prisBad, double prisMad, double prisPrDagEnkelt, double prisPrDagDobbelt) {
        this.navn = navn;
        this.adress = adress;
        this.prisNetflix = prisNetflix;
        this.prisBad = prisBad;
        this.prisMad = prisMad;
        this.prisPrDagEnkelt = prisPrDagEnkelt;
        this.prisPrDagDobbelt = prisPrDagDobbelt;
        this.tilmeldinger = new ArrayList<>();
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }

    public double getPrisNetflix() {
        return prisNetflix;
    }

    public void addKonference(Konference konference) {
        konference.addHotel(this);
    }

    public double getPrisBad() {
        return prisBad;
    }

    public double getPrisMad() {
        return prisMad;
    }

    public String getNavn() {
        return navn;
    }

    public String getAdress() {
        return adress;
    }

    public double getTotalPrisDage() {
        return prisPrDagEnkelt * 2;
    }

    public double getTotalPrisDageDouble() {
        return prisPrDagDobbelt * 2;
    }

    public void addHotelTilmelding(Tilmelding tilmelding) {
        this.tilmeldinger.add(tilmelding);
    }

    @Override
    public String toString() {
        return this.navn;
    }


}

