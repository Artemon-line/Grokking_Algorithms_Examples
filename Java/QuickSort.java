package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import Java.assets.Helper;

/**
 * QuickSort
 */
public class QuickSort {
    private static int steps = 0;

    public static int[] doSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        } else {
            // choose random pivote
            int pivot = arr[new Random().nextInt(arr.length)];
            // int pivot = arr[0];

            // init sud-arrays
            List<Integer> less, more;
            less = new ArrayList<>();
            more = new ArrayList<>();

            // fill sub-arrays
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= pivot) {
                    less.add(arr[i]);
                } else {
                    more.add(arr[i]);
                }
            }
            int[] doSortLess = QuickSort.doSort(less.stream().mapToInt(i -> i).toArray());
            int[] doSortMore = QuickSort.doSort(more.stream().mapToInt(i -> i).toArray());
            steps++;
            return IntStream.concat(Arrays.stream(doSortLess), Arrays.stream(doSortMore)).toArray();
        }
    }

    public static void main(String[] args) {
        int[] unsorted = new int[] { 10, 5, 2, 3, 11, 1, 33, 543, 44, 59, 2393, 75 };
        int[] sorted = QuickSort.doSort(unsorted);
        Helper.print(unsorted, QuickSort.steps);
        System.out.println(Arrays.toString(sorted)); // [1, 2, 3, 5, 10, 11, 33, 44, 59, 75, 543, 2393]
    }
}