package Opgave3;

public class Værkfører extends Ansat {

    private int år;
    private int tillæg;


    public Værkfører(int år, int tillæg, int timeløn, String navn, String adresse, int antalTimer) {
        super(navn,adresse, timeløn, antalTimer);
        this.år = år;
        this.tillæg = tillæg;
    }

    public void setÅr(int år) {
        this.år = år;
    }

    public void setTillæg(int tillæg) {
        this.tillæg = tillæg;
    }

    public int getÅr() {
        return år;
    }

    public int getTillæg() {
        return tillæg;
    }


    public double beregnLøn(){
        return this.getTimeløn() * this.getAntalTimer() + this.tillæg * 100;
    }


}
