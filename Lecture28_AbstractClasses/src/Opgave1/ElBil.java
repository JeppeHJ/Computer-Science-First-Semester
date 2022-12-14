package Opgave1;

public class ElBil extends Bil {
    private int opladningsTid;

    public ElBil() {
        this(10);                   //Kalder constuctor i
    }                          //klassen med parameter

    private ElBil(int tid) {
        super();
        opladningsTid = tid;
    }
}