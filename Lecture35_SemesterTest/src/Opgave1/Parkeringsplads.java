package Opgave1;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Parkeringsplads {
    private int nummer;
    private LocalTime ankomst = null;
    private Parkeringshus parkeringshus;
    private Bil bil;

    public Parkeringsplads(int nummer, Parkeringshus parkeringshus) {
        this.nummer = nummer;
        this.parkeringshus = parkeringshus;
    }

    public int getNummer() {
        return nummer;
    }



    public Bil addBil(Bil bil) {
        this.bil = bil;
        this.ankomst = LocalTime.now();
        return bil;
    }

    public Bil removeBil(Bil bil) {
        this.ankomst = null;
        this.bil = null;
        return bil;
    }

    public Bil getBil() {
        return this.bil;
    }

    public LocalTime getAnkomst() {
        return this.ankomst;
    }

    //Opgave S4
    public int calculatePrice(LocalTime afslutningstidspunkt) {
        Duration duration = Duration.between(this.ankomst, afslutningstidspunkt);
        int durationInMinutes = (int) duration.toMinutes();
        return (durationInMinutes / 10 * 6);
    }

    //Opgave S5
    public void hentBil(LocalTime afgangstidspunkt) {
        this.parkeringshus.addToSaldo(this.calculatePrice(afgangstidspunkt));
        this.bil = null;
    }

}

