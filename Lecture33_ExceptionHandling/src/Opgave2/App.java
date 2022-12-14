package Opgave2;

import java.io.*;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        try {
            //Create Scanner object to read from the file
            Scanner data = new Scanner(new File("C:/Users/jeppe/IdeaProjects/Programming1/Lek33_ThrowExceptions/src/Opgave2/data.txt"));
            //Loop through each line in the txt document
            while (data.hasNextLine()) {
                int line = data.nextInt();
                System.out.println(line * 2);
            }
            //Catch IOExceptions, these include FileNotFound, EOF, UnsupportedEncoding and more.
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
