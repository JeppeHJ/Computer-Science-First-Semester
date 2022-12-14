package Opgave2;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Customer[] customerList = new Customer[5];
        Customer c1 = new Customer("Jeppe", "Pacobsen", 15);
        Customer c2 = new Customer("Jeppe", "Aacobsen", 20);
        Customer c3 = new Customer("Jeppe", "Xacobsen", 20);
        Customer c4 = new Customer("Jeppe", "Aacobsen", 20);
        Customer c5 = new Customer("Jeppe", "Facobsen", 20);

        Customer c6 = new Customer("Jeppe", "Gacobsen", 20);

        customerList[0] = c1;
        customerList[1] = c2;
        customerList[2] = c3;
        customerList[3] = c4;
        customerList[4] = c5;

        System.out.println(lastCustomer(customerList));

    }

    public static Customer lastCustomer(Customer[] customers) {
        Customer lastCustomer = customers[0];
        for (int i = 0; i < customers.length; i++) {
            if (!(customers[i] == null)) {
                assert lastCustomer != null;
                lastCustomer = customers[i].compareTo(lastCustomer);
            }
        }

        return lastCustomer;


    }


    }

