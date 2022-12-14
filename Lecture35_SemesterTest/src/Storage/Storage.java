package Storage;

import Opgave1.Bil;
import Opgave1.Parkeringshus;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Parkeringshus> parkeringshuse = new ArrayList<>();
    private static ArrayList<Bil> biler = new ArrayList<>();

    ///------------------------------------------------------///


    public static ArrayList<Parkeringshus> getParkeringshuse() {
        return parkeringshuse;
    }

    public static ArrayList<Bil> getBiler() {
        return biler;
    }
}
