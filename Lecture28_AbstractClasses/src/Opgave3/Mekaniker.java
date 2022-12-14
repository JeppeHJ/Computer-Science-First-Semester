package Opgave3;

public class Mekaniker extends Ansat {
    private int år;

    public Mekaniker(int år, String navn, String adresse,int timeløn, int antalTimer) {
        super(navn,adresse, timeløn, antalTimer);
        this.år = år;
    }

    public int getÅr() {
        return år;
    }

    public void setÅr(int år) {
        this.år = år;
    }

    public double beregnLøn(){
        return this.getTimeløn() * this.getAntalTimer();
    }
}
