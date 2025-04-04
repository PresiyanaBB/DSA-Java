package Sorting;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}

//sort the first two, then sort the first three, then the first four and so on
//every current number is moved to its position so the mini array is sorted
//every bigger number moves one position to the right
