package Opgave4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lejeaftale {
    private LocalDate fromDate;
    private LocalDate toDate;
    private Bolig bolig;
    private ArrayList<Lejer> lejere;

    Lejeaftale(LocalDate fromDate, Bolig bolig) {
        this.fromDate = fromDate;
        this.bolig = bolig;
        this.lejere = new ArrayList<>();
    }

    public ArrayList<Lejer> getLejere() {
        return this.lejere;
    }

    public void addLejer(Lejer lejer) {
        if (!(this.lejere.size() >= 2) || this.lejere.contains(lejer)) {
            this.lejere.add(lejer);
        }
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
}
