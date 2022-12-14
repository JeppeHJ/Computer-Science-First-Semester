package src.Model;

public class Service {
    private boolean netflix;
    private boolean bad;
    private boolean mad;
    private Hotel hotel;
    private boolean enkeltVærelse;

    public Service(boolean netflix, boolean bad, boolean mad, Hotel hotel, boolean enkeltVærelse) {
        this.netflix = netflix;
        this.bad = bad;
        this.mad = mad;
        this.hotel = hotel;
        this.enkeltVærelse = enkeltVærelse;

    }

    public boolean isNetflix() {
        return netflix;
    }

    public boolean isBad() {
        return bad;
    }

    public boolean isMad() {
        return mad;
    }

    public double getPris() {
        double sum = 0;
        if (this.enkeltVærelse) {
            sum += this.hotel.getTotalPrisDage();
        } else {
            sum += this.hotel.getTotalPrisDageDouble();
        }
        if (this.netflix) {
            sum += this.hotel.getPrisNetflix() * 2;
        }

        if (this.bad) {
            sum += this.hotel.getPrisBad() * 2;
        }

        if (this.mad) {
            sum += this.hotel.getPrisMad() * 2;
        }

        return sum;
    }

}
