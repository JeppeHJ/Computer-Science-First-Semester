package Opgave3;

public class App {
    public static void main(String[] args) {
        System.out.println(match("eee", 4));
    }

    private static boolean match(String m, int i) {
        boolean foundCharIAmountOfTimes = false;
        int counter = 1;
        int j = 1;
        while (!foundCharIAmountOfTimes && j < m.length()) {
                if (m.charAt(j) == m.charAt(j - 1)) {
                    System.out.println(counter);
                    counter++;
                }

            j++;

            if (counter == i) {
                System.out.println(counter);
                foundCharIAmountOfTimes = true;
            }


            }

        return foundCharIAmountOfTimes;
    }
}
