package Opgave3;

public abstract class Ansat extends Person {

    private String navn;
    private String adresse;
    private int timeløn;
    private int antalTimer;

    public Ansat(String navn, String adresse, int timeløn, int antalTimer) {
        super(navn, adresse);
        this.navn = navn;
        this.adresse = adresse;
        this.timeløn = timeløn;
        this.antalTimer = antalTimer;



    }

    public int getTimeløn() {
        return this.timeløn;
    }

    public void setTimeløn(int timeløn) {
        this.timeløn = timeløn;
    }

    public int getAntalTimer() {
        return this.antalTimer;
    }

    public abstract double beregnLøn();


}
