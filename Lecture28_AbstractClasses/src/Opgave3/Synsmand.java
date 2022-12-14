package Opgave3;

public class Synsmand extends Mekaniker {


    private int syn;


    public Synsmand(int år, String navn, String adresse, int timeløn, int syn, int antalTimer) {
        super(år, navn, adresse, timeløn, antalTimer);
        this.syn = syn;

    }

    public int getSyn() {
        return syn;
    }

    public void setSyn(int syn) {
        this.syn = syn;
    }

    public double beregnLøn() {
        return this.getTimeløn() * this.getAntalTimer() + this.syn * 100;
    }


}
