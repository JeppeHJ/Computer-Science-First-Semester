package Opgave2;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};
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


