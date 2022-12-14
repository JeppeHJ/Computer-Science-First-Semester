package soegningelevopgaver;

import java.util.ArrayList;

public class Soegning {

    public boolean findUlige(int[] tabel) {
        boolean unEvenNumber = false;
        // TODO Opgave1
        for (int number: tabel) {
            if (number % 2 != 0) {
                unEvenNumber = true;
                break;
            }
        }
        return unEvenNumber;
    }

    //---Opgave 2

    public int findNumber(int[] tabel) {
        int i = 0;
        while (i < tabel.length) {
            if (tabel[i] < 10 && tabel[i] > 15) {
                return tabel[i];
            } else {
                i++;
            }

        }

        return -1;

    }

    //---Opgave 3

    public boolean findTwoSameNumbers(int[] tabel) {
        boolean found = false;
        int i = 0;
        while (!(found) && i < tabel.length) {
            if (tabel[i] == tabel[i + 1]) {
                found = true;
            }
            i++;

        }

        return found;

    }

    //---Opgave 5
    public int calculateSquareRoot(int n) {
        int r = 0;

        // We will keep increasing r until r * r <= n
        while (r * r <= n) {
            r++;
        }

        // Once we have our value for r, we need to decrement it by 1 to get the greatest whole number
        // that satisfies r * r <= n < (r+1) * (r+1)
        return r - 1;
    }

    public int calculateSquareRootTwo(int n) {
        int low = 0;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid * mid is less than or equal to n and mid+1 * mid+1 is greater than n
            if (mid * mid <= n && (mid+1) * (mid+1) > n) {
                return mid;
            } else if (mid * mid < n) {
                // If mid * mid is less than n, search the upper half of the array
                low = mid + 1;
            } else {
                // If mid * mid is greater than n, search the lower half of the array
                high = mid - 1;
            }
        }

        // We should never reach this point
        return -1;
    }
    //This function uses a binary search algorithm to find the greatest whole number r that satisfies the condition
    // r * r <= n < (r+1) * (r+1). It does this by maintaining a search range, initially the whole range of numbers from
    // 0 to n, and repeatedly dividing the search range in half until it finds the value of r that satisfies the condition.






    public int findAndSwap(ArrayList<Integer> list, int n) {
        // Check if the ArrayList is empty
        if (list.isEmpty()) {
            return -1;
        }

        // Find the index of the number in the ArrayList
        int index = list.indexOf(n);

        // If the number is not found, return -1
        if (index == -1) {
            return -1;
        }

        // If the found number is not at index 0, swap it with the number to the left
        if (index > 0) {
            int temp = list.get(index - 1);
            list.set(index - 1, n);
            list.set(index, temp);
        }

        // Return the new index of the found number
        return index;
    }
    }



    // her skriver du metoder til opgaverne 2,3,5,6 og 7

