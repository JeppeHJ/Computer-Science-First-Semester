package Opgave2;

public class Gift {
    private String description;
    private double price;
    private Person giver;

    public Gift(String description, double price, Person giver) {
        this.description = description;
        this.price = price;
        this.giver = giver;
    }

    public String getGiver() {
        return this.giver.toString();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
