package sortering.measure;

import Opgave2.Customer;

public class SortMethods {

    public static void bubbleSort(String[] list) {
        //Loop through the array
        for (int i = list.length - 1; i >= 0; i--) {
            //Loop through the array again
            for (int j = 0; j < i; j++) {
                //Compare the current element with the next element
                if (list[j].compareTo(list[j + 1]) > 0) {
                    //Swap elements if the current element is greater than the next
                    String temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(String[] list) {
        for (int i = 1; i < list.length; i++) {
            String next = list[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(list[j - 1]) > 0) {
                    found = true;
                } else {
                    list[j] = list[j - 1];
                    j--;
                }
            }

            list[j] = next;
        }
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

    public static void selectionSortCustomer(Customer[] list) {
        for (int i = 0; i < list.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[minPos]) < 0) {
                    minPos = j;
                }

                Customer temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
    }
}


