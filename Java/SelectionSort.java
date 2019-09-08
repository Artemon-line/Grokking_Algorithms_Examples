package Java;

import java.util.Arrays;

import Java.assets.Algorithm;
import Java.assets.Helper;

class SelectionSort implements Algorithm {
    private int steps = 0;
    private int[] arr;

    @Override
    public int[] getStats() {
        return new int[] { this.arr.length, this.steps };
    }

    public int[] selectionSort(int[] arr) {

        this.arr = arr;
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;// searching for lowest index
                }
                ++steps;
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return this.arr;
    }

    public static void main(String[] args) {
        SelectionSort alg = new SelectionSort();
        int[] arr = { 5, 3, 6, 2, 10, 4, 8, 9, 22, 19 };
        int[] res = alg.selectionSort(arr);
        Helper.print(alg.getStats());
        System.out.println(Arrays.toString(res));
    }
}