package Opgave4;

public class App {
    public static void main(String[] args) {
        Square s1 = new Square(10,10,10);
        System.out.println(s1.calculateArea());
        s1.moveFigure(10);
        System.out.println(s1.getxCoord());

        Rectangle r1 = new Rectangle(10,10,10, 5);
        System.out.println(r1.calculateArea());
        r1.moveFigure(10);
        System.out.println(r1.getxCoord());

    }
}
