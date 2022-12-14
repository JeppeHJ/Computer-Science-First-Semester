package Opgave1;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        Customer c1 = new Customer("Åse","Asesen", 15);
        Customer c2 = new Customer("Åse","Csesen", 15);
        Customer c3 = new Customer("Åse","Esesen", 15);
        Customer c4 = new Customer("Åse","Gsesen", 15);
        Customer c5 = new Customer("Åse","Isesen", 15);
        Customer c6 = new Customer("Åse","Dsesen", 15);
        ArrayList<Customer> kunder = new ArrayList<>();
        kunder.add(c1);
        kunder.add(c2);
        kunder.add(c3);
        kunder.add(c4);
        kunder.add(c5);

        insert(kunder,c6);

        System.out.println(kunder);
    }

    /**
     * Indsætter kunde i kunder. Listen kunder er sorteret
     * Krav: kunder er sorteret
     *
     */
    public static void insert (ArrayList<Customer> list, Customer kunde) {
        boolean found = false;
        int i = 0;
        while (!found && i<list.size()) {
            if (list.get(i).compareTo(kunde)>0) {
                found = true;
            }
            else {
                i++;
            }
        }
        list.add(i,kunde);
    }

    private static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void selectionSort(String[] list) {
        for (int i = 0; i < list.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[minPos]) < 0) {
                    minPos = j;
                }

            }
            swap(list, i, minPos);
        }
    }

    public static void selectionSortCustomer(ArrayList<Customer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < list.size () - 1; j++) {
                if (list.get(j).compareTo(list.get(minPos)) < 0) {
                    minPos = j;
                }

                Customer temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
    }
}


