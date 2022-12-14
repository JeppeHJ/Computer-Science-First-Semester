package Opgave1;

import java.time.Duration;
import java.time.LocalTime;

public class Invalideplads extends Parkeringsplads {
    private double area;
    private LocalTime ankomst;

    public Invalideplads(double area, int nummer, Parkeringshus parkeringshus) {
        super(nummer, parkeringshus);
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    @Override
    public int calculatePrice(LocalTime afslutningstidspunkt) {
        return 0;
    }

}
