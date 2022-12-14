package Opgave2;

public class App {
    public static void main(String[] args) {
        Person p1 = new Person("Jeppe", 29);
        Gift g1 = new Gift("Monkey", 10, p1);
        Person p2 = new Person("Mikael", 25);
        Gift g2 = new Gift("Zebra", 15, p2);

        p1.receiveGift(g2);
        p2.receiveGift(g1);

        g1.getGiver();
        System.out.println(p2.getTotalGiftPrice());

    }
}
