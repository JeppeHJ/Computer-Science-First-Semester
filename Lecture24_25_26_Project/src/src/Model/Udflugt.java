package src.Model;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Udflugt {
    private String navn;
    private String beskrivelse;
    private String dato;
    private double pris;
    private ArrayList<Ledsager> ledsagere;


    public Udflugt(String navn, String beskrivelse, String dato, double pris) {
        this.ledsagere = new ArrayList<>();
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.pris = pris;
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

    public ArrayList<Ledsager> getLedsagere() {
        return ledsagere;
    }

    public double getPris() {
        return pris;
    }
    public void addLedsager(Ledsager ledsager){ledsagere.add(ledsager);
    }
    @Override
    public String toString() {
        return this.navn;
    }
}
