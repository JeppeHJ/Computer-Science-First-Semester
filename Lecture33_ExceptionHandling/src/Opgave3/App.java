package Opgave3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        try {
            //Create Scanner object to read from the file
            Scanner data = new Scanner(new File("C:/Users/jeppe/IdeaProjects/Programming1/Lek33_ThrowExceptions/src/Opgave2/data.txt"));
            //Loop through each line in the txt document
            while (data.hasNextLine()) {
                //Add try-block to catch potential MisMatchExceptions
                try {
                    int line = data.nextInt();
                    //Add each number to an ArrayList
                    list.add(line);
                } catch (InputMismatchException e) {
                    //Catch InputMisMatchException, typically if input is not an integer
                    System.out.println(e.getMessage());
                    //Skip the line if it is not a valid integer
                    data.nextLine();
                }
            }
        } catch (IOException e) {
            //Catch IOExceptions, these include FileNotFound, EOF, UnsupportedEncoding and more.
            System.out.println(e.getMessage());
        }

        //Initialize i as size of list, loop through list backwards to print numbers
        for (int i = list.size() - 1; i >= 0; i--) {
                System.out.println(list.get(i));

            }

        }
    }
