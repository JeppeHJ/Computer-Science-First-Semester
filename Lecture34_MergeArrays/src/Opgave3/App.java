package Opgave3;

import Opgave1.Customer;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Customer> list1 = new ArrayList<>();
        Customer[] list2 = new Customer[4];

        Customer c1 = new Customer(15,"Jeppe","Aacobsen");
        Customer c2 = new Customer(15,"Jeppe","Cacobsen");
        Customer c3 = new Customer(15,"Jeppe","Eacobsen");
        Customer c4 = new Customer(15,"Jeppe","Gacobsen");
        Customer c5 = new Customer(15,"Jeppe","Iacobsen");
        Customer c6 = new Customer(15,"Jeppe","Bacobsen");
        Customer c7 = new Customer(15,"Jeppe","Dacobsen");
        Customer c8 = new Customer(15,"Jeppe","Facobsen");
        Customer c9 = new Customer(15,"Jeppe","Jacobsen");

        list1.add(c1);
        list1.add(c2);
        list1.add(c3);
        list1.add(c4);

        list2[0] = c6;
        list2[1] = c7;
        list2[2] = c8;
        list2[3] = c9;

    }

    public static ArrayList<Customer> goodCustomers(ArrayList<Customer> list1, Customer[] list2) {
        // Create a new ArrayList to store the missing customers
        ArrayList<Customer> missingCustomers = new ArrayList<>();

        // Loop through the first list of customers
        for (Customer c1 : list1) {
            // Assume that the customer is not in the second list
            boolean found = false;

            // Loop through the second list of customers
            for (Customer c2 : list2) {
                // If the customer is found in the second list,
                // set the "found" flag to true and break out of the loop
                if (c1.equals(c2)) {
                    found = true;
                    break;
                }
            }

            // If the customer was not found in the second list, add it to the missing customers list
            if (!found) {
                missingCustomers.add(c1);
            }
        }

        // Return the list of missing customers
        return missingCustomers;
    }
    }

