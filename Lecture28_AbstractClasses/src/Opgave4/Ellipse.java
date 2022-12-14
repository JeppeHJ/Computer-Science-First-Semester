package Opgave4;

public class Ellipse extends Circle {
    private static double radiusTwo;

    public Ellipse(int xCoord, int yCoord, double radius, double radiusTwoInput) {
        super(xCoord, yCoord, radius);
        radiusTwo = radiusTwoInput;
    }

    public static double getRadiusTwo() {
        return radiusTwo;
    }
}
