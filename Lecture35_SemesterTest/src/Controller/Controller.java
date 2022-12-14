package Controller;

import Opgave1.Bil;
import Opgave1.Invalideplads;
import Opgave1.Parkeringshus;
import Opgave1.Parkeringsplads;

public class Controller {
    public static Parkeringshus createParkeringshus(String adresse) {
        Parkeringshus parkeringshus = new Parkeringshus(adresse);
        return parkeringshus;
    }

    public static Parkeringsplads createParkeringsplads(int nummer, Parkeringshus parkeringshus) {
        Parkeringsplads p = parkeringshus.createParkeringsplads(nummer);
        return p;
    }

    public static Bil createBil(String regNr) {
        Bil bil = new Bil(regNr);
        return bil;
    }

    public static Invalideplads createInvalideplads(double area, int nummer, Parkeringshus parkeringshus) {
        Invalideplads i = parkeringshus.createInvalideplads(area, nummer);
        return i;
    }

    public static void createSomeObjects() {
        Bil b1 = new Bil("AB 11 222");
        Bil b2 = new Bil("EF 33 222");
        Bil b3 = new Bil("AB 11 222");
    }



}
