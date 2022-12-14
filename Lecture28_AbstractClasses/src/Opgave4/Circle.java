package Opgave4;

public class Circle extends GeometricFigure {
    private double radius;


    public Circle(int xCoord, int yCoord, double radius) {
        super(xCoord, yCoord);
        this.radius = radius;
    }

    public double calculateArea() {
        if (this instanceof Ellipse) {
            return 3.14 * this.radius * Ellipse.getRadiusTwo();
        }
        return 3.14 * (this.radius * this.radius);
    }

    public double getRadius() {
        return radius;
    }

    public void moveFigure(int amount) {
        this.setxCoord(this.getxCoord() + amount);
        this.setyCoord(this.getyCoord() + amount);
    }
}
