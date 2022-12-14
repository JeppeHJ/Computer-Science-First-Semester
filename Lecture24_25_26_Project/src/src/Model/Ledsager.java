package src.Model;

import java.util.ArrayList;

public class Ledsager {
    private String navn;
    private ArrayList<Udflugt> udflugter;

    public Ledsager(String navn) {
        this.navn = navn;
        this.udflugter = new ArrayList<>();
    }

    public void addUdflugter(Udflugt udflugt) {
        this.udflugter.add(udflugt);
    }

    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    public double getPris(){
        double pris = 0;
        for (Udflugt udflugt : udflugter){
            pris += udflugt.getPris();
        }
        return pris;
    }

    @Override
    public String toString() {
        return this.navn;
    }
}
