package Sorting;

public class SelectionSort {
   public static void selectionSort(int[] arr) {
       int n = arr.length;

       for (int i = 0; i < n - 1; i++) {
           int minIdx = i;

           for (int j = i + 1; j < n; j++) {
               if (arr[j] < arr[minIdx]) {
                   minIdx = j;
               }
           }

           int temp = arr[minIdx];
           arr[minIdx] = arr[i];
           arr[i] = temp;
       }
   }
}

//goes to ind 0 and in the inner for looks for the smallest number in the rest of the array
//then we have the smallest element on position 0 and go fix position 1 and go with for from 2 to len
//and so on for every index we fix the index and search about the element that must be on this position