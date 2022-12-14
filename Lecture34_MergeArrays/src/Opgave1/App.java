package Opgave1;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Customer> list1 = new ArrayList<>();
        ArrayList<Customer> list2 = new ArrayList<>();

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

        list2.add(c6);
        list2.add(c7);
        list2.add(c8);
        list2.add(c9);

        System.out.println(list1);
        System.out.println(list2);

        System.out.println(mergeAlleCustomers(list1,list2));

    }

    public static ArrayList<Customer> mergeAlleCustomers(ArrayList<Customer> list1, ArrayList<Customer> list2) {
        //Initializes an empty list that'll be the merged one
        ArrayList<Customer> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;

        //Merge as long as there are items in both lists
        while (i1 < list1.size() && i2 < list2.size()) {
            if (list1.get(i1).compareTo(list2.get(i2)) <= 0) {
                //list1's first number is smallest
                result.add(list1.get(i1));
                i1++;
            } else {
                //list2's first number is smallest
                result.add(list2.get(i2));
                i2++;
            }
        }
        //Exits while loop, empty the list that's not empty
        //Loop through list1
        while (i1 < list1.size()) {
            result.add(list1.get(i1));
            i1++;
        }
        //Loop through list2
        while (i2 < list2.size()) {
            result.add(list2.get(i2));
            i2++;
        }

        return result;

    }


}
