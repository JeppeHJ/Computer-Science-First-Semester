package Opgave3.minihandel;

public class PercentDiscount implements Discount{
    private int discountPercentage;
    public PercentDiscount(int discountPercentage) {
        this.discountPercentage=discountPercentage;
    }

    public double getDiscount(double price) {
        double percent = discountPercentage/100.0;
        return price*percent;
    }
}
