package Opgave4;

public class Square extends GeometricFigure {
    private final int lengthOfSide;

    public Square(int xCoord, int yCoord, int lengthOfSide) {
        super(xCoord, yCoord);
        this.lengthOfSide = lengthOfSide;
    }

    public double calculateArea() {
        if (this instanceof Rectangle) {
            return lengthOfSide * Rectangle.getLengthOfSecondSide();
        }
        return lengthOfSide * lengthOfSide;
    }

    public void moveFigure(int amount) {
        this.setxCoord(this.getxCoord() + amount);
        this.setyCoord(this.getyCoord() + amount);

    }
}
