package Opgave4;

import java.time.LocalDate;
import java.util.ArrayList;

public class SwimmerApp {
    public static void main(String[] args) {
        ArrayList<Double> times = new ArrayList<>();
        times.add(3.49);
        times.add(4.30);
        times.add(2.23);

        Swimmer jeppe = new Swimmer("Jeppe", "BIF", LocalDate.of(1992,6,30), times);

        System.out.println(jeppe.averageTime());
        System.out.println(jeppe.bestTime());
        System.out.println(jeppe.averageWithoutWorst());
    }
}
