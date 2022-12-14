package Opgave1;

import java.lang.reflect.Array;

public class App {
    public static void main(String[] args) {
        Chili[] chiliList = new Chili[10];

        Chili c1 = new Chili("Habanero",100);
        Chili c2 = new Chili("Habanero",200);
        Chili c3 = new Chili("Habanero",300);
        Chili c4 = new Chili("Habanero",400);
        Chili c5 = new Chili("Habanero",500);

        chiliList[0] = c1;
        chiliList[1] = c2;
        chiliList[2] = c3;
        chiliList[3] = c4;
        chiliList[4] = c5;
        chiliList[5] = c1;
        chiliList[6] = c2;
        chiliList[7] = c3;

        System.out.println(max(chiliList));
        System.out.println(avg(chiliList));

        }

    public static Measurable max(Measurable[] objects) {
        Measurable maxObject = null;
        if (!(objects == null)) {
            double max = objects[0].getMeasure();
            for (Measurable object: objects) {
                if (object != null && object.getMeasure() > max) {
                    max = object.getMeasure();
                    maxObject = object;
                }
            }
        }

        return maxObject;

    }

    public static double avg(Measurable[] objects) {
        double sum = 0;
        int counter = 0;
        if (!(objects == null)) {
            for (Measurable object : objects) {
                if (!(object == null)) {
                    sum += object.getMeasure();
                    counter++;
                }

            }

            return sum / counter;

        }

        return 0;
    }
}
