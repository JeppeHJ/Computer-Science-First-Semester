package Opgave2;

public class ElBil extends Bil {
    private int opladningsTid;
    public ElBil() {}
    public ElBil(int opladningsTid) {
        this.opladningsTid = opladningsTid;
    }
    public int getOpladningsTid(){
        return opladningsTid;
    }
}