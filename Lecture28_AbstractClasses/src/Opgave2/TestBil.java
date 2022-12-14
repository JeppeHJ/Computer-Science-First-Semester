package Opgave2;

public class TestBil {
    public static void main(String[] args) {
        Bil minBil;
        ElBil minElBil;

        minBil = new Bil();

        //Sets instance variables without set functions cause theyre public/protected
        minBil.maerke = "Ford";
        minBil.vaegt = 1000;

        //--- Tries to a set private instance variable without a set function
        //minBil.farve = "Rød";

        minElBil = new ElBil();

        //--- Sets instance variables without set functions cause theyre public/protected
        minElBil.maerke = "Volvo";
        minElBil.vaegt = 1500;

        //--- Tries to a set private instance variable without a set function
        //minElBil.farve = "Sort";

        //--- The variable minElBil is an ElBil object and cant point to a Bil object. You'd have to (cast) minBil into an ElBil class.
        //minElBil = minBil;
        minBil = new ElBil();

        //--- The method getOpladningsTid is only available to the ElBil class. Again, you'd have to (cast) Bil-class into ElBil
        //minBil.getOpladningsTid();
        minBil.getFarve();

        //--- An object of a subclass type is also a type of parent class. So the if-condition is always true.
        //if (minBil instanceof ElBil){
            ((ElBil)minBil).getOpladningsTid();
        }
    }
