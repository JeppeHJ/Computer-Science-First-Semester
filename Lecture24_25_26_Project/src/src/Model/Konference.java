package src.Model;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class Konference {
    private String navn;

    private String beskrivelse;

    private String dato;

    private String adresse;

    private ArrayList<Hotel> hoteller;

    private ArrayList<Tilmelding> tilmeldinger;

    private ArrayList<Udflugt> udflugter;

    private double pris;
    
    private ArrayList<Konference> konferencer;


    public Konference(String navn, String beskrivelse, String dato, String adresse, double pris) {
        this.hoteller = new ArrayList<>();
        this.tilmeldinger = new ArrayList<>();
        this.udflugter = new ArrayList<>();
        this.konferencer = new ArrayList<>();
        
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.adresse = adresse;
        this.pris = pris;
    }


    public ArrayList<Hotel> getHoteller() {
        return hoteller;
    }

    public void addUdflugt(Udflugt udflugt) {
        this.udflugter.add(udflugt);
    }

    public void addHotel(Hotel hotel) {
        this.hoteller.add(hotel);
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }

    public double getPris() {
        return this.pris * 3;
    }

    public void addTilmelding(Tilmelding tilmelding) {
        this.tilmeldinger.add(tilmelding);
    }

    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    public String getNavn() {
        return navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public String getDato() {
        return dato;
    }

    public String getAdresse() {
        return adresse;
    }
    public void add(Tilmelding tilmelding) {
        this.tilmeldinger.add(tilmelding);
    }
    
    public void addKonference(Konference konference){
        this.konferencer.add(konference);
    }

    public ArrayList<Konference> getKonferencer() {
        return konferencer;
    }

    @Override
    public String toString() {
        return this.navn;
    }
}
