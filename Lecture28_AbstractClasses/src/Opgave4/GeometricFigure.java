package Opgave4;

public abstract class GeometricFigure {
    private int xCoord;
    private int yCoord;

    public GeometricFigure(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public abstract double calculateArea();

    public abstract void moveFigure(int amount);

}
