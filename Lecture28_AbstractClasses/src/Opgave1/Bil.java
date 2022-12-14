package Opgave1;


public class Bil {

    //Public instance variable
    public String maerke;

    //Protected instance variable
    protected int vaegt;
    private String farve;

    //Private constructor
    private Bil(String maerke, int vaegt, String farve) {
        this.maerke = maerke;
        this.vaegt = vaegt;
        this.farve = farve;
    }

    public Bil() {
        this("Ukendt", -1, "Hvid"); //Kalder constructor i
        //klassen med parameter
    }
}
