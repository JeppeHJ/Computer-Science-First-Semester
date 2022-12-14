package Opgave4;

public class Rectangle extends Square {
    private static int lengthOfSecondSide;

    public Rectangle(int xCoord, int yCoord, int lengthOfSide, int lengthOfSecondSideInput) {
        super(xCoord, yCoord, lengthOfSide);
        lengthOfSecondSide = lengthOfSecondSideInput;
    }

    public static int getLengthOfSecondSide() {
        return lengthOfSecondSide;
    }


    }



