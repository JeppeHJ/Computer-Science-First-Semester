package Opgave2;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private ArrayList<Gift> gifts;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.gifts = new ArrayList<>();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void receiveGift(Gift gift) {
        if (!(this.gifts.contains(gift))) {
            this.gifts.add(gift);
        }
    }

    public ArrayList<Gift> getGifts() {
        return new ArrayList<Gift>(this.gifts);
    }

    public double getTotalGiftPrice() {
        int sum = 0;
        for (Gift gift: this.gifts) {
            sum += gift.getPrice();
        }

        return sum;
    }

    public String toString() {
        return this.name + " " + this.age;
    }

}
