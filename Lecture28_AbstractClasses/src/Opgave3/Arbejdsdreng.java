package Opgave3;

public class Arbejdsdreng extends Ansat {


    public Arbejdsdreng(String navn, String adresse, int timeløn, int antalTimer) {
        super(navn, adresse, timeløn, antalTimer);
    }

    public double beregnLøn() {
        return this.getTimeløn() * this.getAntalTimer();
    }
}
