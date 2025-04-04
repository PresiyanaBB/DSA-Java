import static Searching.BinarySearch.binarySearch;
import static Searching.JumpSearch.jumpSearch;
import static Searching.TernarySearch.ternarySearch;
import static Sorting.BubbleSort.bubbleSort;
import static Sorting.CountingSort.countingSort;
import static Sorting.InsertionSort.insertionSort;
import static Sorting.MergeSort.mergeSort;
import static Sorting.QuickSort.quickSort;
import static Sorting.SelectionSort.selectionSort;

public class Application {
    public static void main(String[] args) {
        sorting();
        searching();
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void sorting() {
        int[] data = {64, 34, 25, 12, 22, 11, 90, 3, 121, 18,64 , 95};

        System.out.println("Original array:");
        printArray(data);

        bubbleSort(data);
        countingSort(data);
        insertionSort(data);
        mergeSort(data, 0, data.length - 1);
        quickSort(data, 0, data.length - 1);
        selectionSort(data);

        System.out.println("Sorted array:");
        printArray(data);
    }

    public static void searching() {
        int[] data = {64, 34, 25, 12, 22, 11, 90, 3, 121, 18,64 , 95};

        System.out.println("Original array:");
        printArray(data);

        bubbleSort(data);

        System.out.println("Sorted array:");
        printArray(data);

        int result1 = binarySearch(data,22);
        int result2 = ternarySearch(data,22,0,data.length - 1);
        int result3 = jumpSearch(data,22);
        System.out.println("Result binary: " + result1);
        System.out.println("Result ternary: " + result2);
        System.out.println("Result jump: " + result3);
    }
}
