package Opgave3;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;


public class App {


    public static void main(String[] args) {
        ArrayList <Ansat> a1 = new ArrayList<>();
        Mekaniker m1 = new Mekaniker(1990, "Anders", "HejHus", 100, 10);
        Mekaniker m2 = new Mekaniker(1992,"Oliver","NejHus",100, 10);

        Værkfører v1 = new Værkfører(1995, 20,100, "Ole","OpHus", 10);
        Værkfører v2 = new Værkfører(1980, 20, 100, "Troels", "FløjHus", 10);

        Synsmand s1 = new Synsmand(1990,"Ulla","LedHus",100,5, 10);
        Synsmand s2 = new Synsmand(1954,"Frederik","MamaMia",100,3, 10);

        a1.add(m1);
        a1.add(m2);
        a1.add(v1);
        a1.add(v2);
        a1.add(s1);
        a1.add(s2);

        System.out.println(samletUgeLøn(a1));


        //Printer den samlede løn for alle i ArrayListen


    }

    //Metoder der tager alle i listen og beregner deres løn
    public static double samletUgeLøn(ArrayList<Ansat> list){
        int sum = 0;
        for (Ansat ansat : list){
            sum+=ansat.beregnLøn();
        }

        return sum;
    }


}




