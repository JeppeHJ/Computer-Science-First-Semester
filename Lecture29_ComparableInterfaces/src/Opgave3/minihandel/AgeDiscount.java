package Opgave3.minihandel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeDiscount implements Discount {
    private final LocalDate birthday;

    public AgeDiscount(LocalDate birthday) {
        this.birthday = birthday;
    }
    public double getDiscount(double price) {
        double years = (double) ChronoUnit.YEARS.between(this.birthday, LocalDate.now());
        return price * (years / 100);

    }
}
