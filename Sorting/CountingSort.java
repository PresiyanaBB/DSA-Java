package Sorting;

public class CountingSort {
    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        int max = arr[0];
        int min = arr[0];

        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int num : arr)
            count[num - min]++;
        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];
        for (int i = arr.length - 1; i >= 0; i--)
            output[--count[arr[i] - min]] = arr[i];

        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}

//the number and its index in the array are the same
//the index is our number and the int to it is the number of occurs in the array
