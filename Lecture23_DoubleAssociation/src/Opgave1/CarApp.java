package Opgave1;

public class CarApp {
    public static void main(String[] args) {
        Car c1 = new Car("10-10-10", 1992, 10.5);
        Car c2 = new Car("10-10-10", 1992, 15.5);
        Car c3 = new Car("10-10-10", 1992, 20);
        Car c4 = new Car("10-10-10", 1992, 19);
        Car c5 = new Car("10-10-10", 1992, 29);

        Rental r1 = new Rental(10,"1992");
        Rental r2 = new Rental(20,"1992");
        Rental r3 = new Rental(30,"1992");
        Rental r4 = new Rental(40,"1992");
        Rental r5 = new Rental(50,"1992");
        Rental r6 = new Rental(60,"1992");

        c1.addRental(r1);
        c1.addRental(r2);
        c1.addRental(r3);
        c1.addRental(r4);

        System.out.println(c1.getRentals());
        System.out.println(c1.getMaxDays());
        System.out.println(c1.getPricePerDay());
    }
}
