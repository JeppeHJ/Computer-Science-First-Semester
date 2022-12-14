package Opgave2;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] array1 = {2, 4, 6, 8, 10, 12, 14};
        int[] array2 = {1, 2, 4, 5, 6, 9, 12, 17};

        System.out.println(Arrays.toString(commonNumber(array1, array2)));

    }


    public static int amountOfCommonNumbers(int[] a1, int[] a2) {
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        int commonNumber = 0;

        //Iterate over a1 and a2 simultaneously
        while (i1 < a1.length && i2 < a2.length) {
            //If a1[i1] is equal to a2[i2], add it to mergedArray
            if (a1[i1] == a2[i2]) {
                i++;
                i1++;
                i2++;
                commonNumber++;
            } else if (a1[i1] > a2[i2]) {
                //If a1[i1] is larger than a2[i2], move on to the next index in a2
                i2++;
            } else {
                //If a1[i1] is smaller than a2[i2], move on to the next index in a1
                i1++;
            }


        }
        return commonNumber;
    }

    public static int[] commonNumber(int[] a1, int[] a2) {
        //Initialize a new Array that'll contain the common numbers
        int[] mergedArray = new int[amountOfCommonNumbers(a1,a2)];
        int i1 = 0;
        int i2 = 0;
        int i = 0;

        //Attempt to merge while both arrays still contain items
        while (i1 < a1.length && i2 < a2.length) {
            //If items are the same, increment all i-values with 1, add item to mergedArray
                if (a1[i1] == a2[i2]) {
                    //If the numbers are the same, add to the merged array
                    mergedArray[i] = a1[i1];
                    i++;
                    i1++;
                    i2++;
                } else if (a1[i1] > a2[i2]) {
                    //If item from a1 is bigger than item from a2, move to the next index in a2
                    i2++;
                } else {
                    //If item from a2 is bigger than item from a1, move to the next index in a1
                    i1++;
                }
        }

        return mergedArray;
    }
}
