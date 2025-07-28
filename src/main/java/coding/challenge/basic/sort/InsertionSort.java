package coding.challenge.basic.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {6,2,1,5,4,3,8,7};
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(Arrays.toString(arr));
        insertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int prev = i-1;
            while (prev >= 0 && arr[prev] > key) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = key;
        }
    }
}
