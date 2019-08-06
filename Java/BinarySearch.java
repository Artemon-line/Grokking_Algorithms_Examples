package Java;

import java.util.Random;

import Java.assets.Helper;

/**
 * binarySearch
 */
public class BinarySearch {

    public static Integer findIndex(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;
        int steps = 0;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            int guess = list[mid];
            steps++;
            if (guess == item) {
                Helper.print(list, steps);
                return mid;
            }
            if (guess > item) {
                high = --mid;
            } else {
                low = ++mid;
            }
        }
        Helper.print(list, steps);
        return null;

    }

    public static void main(String args[]) {
        int[] intArray = { 1, 3, 5, 7, 9, 11, 16, 17, 19, 22, 25, 27, 29, 33 };
        int target = new Random().ints(1, 33).findFirst().getAsInt();
        Integer result = BinarySearch.findIndex(intArray, target);
        System.out.println(String.format("%d is on %d", target, result));
    }
}