package Opgave1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        //It throws OutOfBounds exceptions because only primenumbers 1-10 are available.
        //Different ways of handling this: Either through input-sanitization or catching the exception
        //They can also be combined for even more graceful handling of it
        int[] prim = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

        //Option 1
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Hvilket nr. primtal skal vises?: ");
            //We store the input
            int m = scanner.nextInt();
            //Look for the associated primenumber in the array
            System.out.println("Primtal nr. " + m + " er "
                    + prim[m - 1] + "\n");
            //We catch an InputMismatchException which in this case is invalid input, ie letter/signs
        } catch (InputMismatchException e) {
            System.out.println("Not valid input. Input must be an integer");
            //We catch an ArrayIndexOutOfBoundsException when input is lower than 0 or higher than 10
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not valid input. Integer must be between 1 and 10");
        }
    }
}