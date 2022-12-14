package Opgave1;

public class App {
    public static void main(String[] args) {
        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

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
}
