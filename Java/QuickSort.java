package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import Java.assets.Algorithm;
import Java.assets.Helper;

/**
 * QuickSort
 */
public class QuickSort implements Algorithm {
    private int steps = 0;
    private int length = 0;
    private int[] list;

    @Override
    public int[] getStats() {
        return new int[] { this.length, this.steps };
    }

    public int[] doSort(int[] arr) {
        this.list = arr;
        if (this.length == 0) {
            this.length = arr.length;
        }

        if (this.list.length < 2) {
            return this.list;
        } else {
            this.steps++;
            // choose random pivote
            int pivot = arr[new Random().nextInt(this.list.length)];
            // int pivot = arr[0];

            // init sud-arrays
            List<Integer> less, more;
            less = new ArrayList<>();
            more = new ArrayList<>();

            // fill sub-arrays
            for (int i = 0; i < this.list.length; i++) {
                if (this.list[i] <= pivot) {
                    less.add(this.list[i]);
                } else {
                    more.add(this.list[i]);
                }
            }
            int[] doSortLess = this.doSort(less.stream().mapToInt(i -> i).toArray());
            int[] doSortMore = this.doSort(more.stream().mapToInt(i -> i).toArray());
            steps++;
            return IntStream.concat(Arrays.stream(doSortLess), Arrays.stream(doSortMore)).toArray();
        }
    }

    public static void main(String[] args) {
        int[] unsorted = new int[] { 10, 5, 2, 3, 11, 1, 33, 543, 44, 59, 2393, 75 };
        QuickSort algorithm = new QuickSort();
        int[] sorted = algorithm.doSort(unsorted);
        Helper.print(algorithm.getStats());
        System.out.println(Arrays.toString(sorted)); // [1, 2, 3, 5, 10, 11, 33, 44, 59, 75, 543, 2393]
    }

}