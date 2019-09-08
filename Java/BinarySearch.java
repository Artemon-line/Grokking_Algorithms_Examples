package Java;

import java.util.Random;

import Java.assets.Algorithm;
import Java.assets.Helper;

/**
 * binarySearch
 */
public class BinarySearch implements Algorithm {

    int steps = 0;
    int[] list;

    @Override
    public int[] getStats() {
        return new int[] { this.list.length, this.steps };
    }

    public Integer findIndex(int[] list, int item) {
        this.list = list;
        int low = 0;
        int high = this.list.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            int guess = this.list[mid];
            this.steps++;
            if (guess == item) {
                return mid;
            }
            if (guess > item) {
                high = --mid;
            } else {
                low = ++mid;
            }
        }
        return null;

    }

    public static void main(String args[]) {
        int[] intArray = { 1, 3, 5, 7, 9, 11, 16, 17, 19, 22, 25, 27, 29, 33 };
        int target = new Random().ints(1, 33).findFirst().getAsInt();
        BinarySearch algorithm = new BinarySearch();
        Integer result = algorithm.findIndex(intArray, target);
        Helper.print(algorithm.getStats());
        System.out.println(target + " is on index " + result);
    }

}