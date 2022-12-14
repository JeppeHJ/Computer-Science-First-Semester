package soegningelevopgaver;

import java.util.ArrayList;

public class Spillermetoder {
    public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        // TODO Opgave 4.1
        Spiller spiller = null;
        int i = 0;
        while (spiller == null && i < spillere.size()) {
            if (spillere.get(i).getMaal() == score) {
                spiller = spillere.get(i);
            }

            i++;
        }
        return spiller;
    }

    // Her tilføjes metoder der løser opgve 4.2 og 4.3
    // TODO Opgave 4.2
    public Spiller findScoreBinary(ArrayList<Spiller> spillere, int score) {
        Spiller spiller = null;
        int left = 0;
        int right = spillere.size() - 1;
        while (spiller == null && left <= right) {
            int middle = (left + right) / 2;
            Spiller s = spillere.get(middle);
            if (s.getMaal() == score) {
                spiller = s;
            } else if (s.getMaal() > score) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return spiller;
    }

    //TODO Opgave 4.3
    public String godSpiller(ArrayList<Spiller> spillere) {
        boolean found = false;
        String name = "";
        int i = 0;
        while (!found && i < spillere.size()) {
            if (spillere.get(i).getMaal() > 50 && spillere.get(i).getHoejde() < 170) {
                found = true;
                name = spillere.get(i).getNavn();
            }

            i++;
        }

        return name;
    }

    public static void main(String[] args) {
        Spillermetoder metoder = new Spillermetoder();

        // Her afprøves opgave 4.1
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Bo", 203, 89, 60));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));

        System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreLinear(spillerListe, 30));

        // Tilføj kode der afprøver opgaver 4.2 og 4.3

        System.out.println("Sut: " + metoder.findScoreBinary(spillerListe,60));

    }

}
