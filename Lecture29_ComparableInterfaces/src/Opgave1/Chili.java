package Opgave1;

public class Chili implements Measurable {
    private String name;
    private int strength;

    public Chili(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public double getMeasure() {
        return this.strength;
    }
}
