import java.util.*;

public class Week3Problem3 {
    static void merge(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length)
            arr[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static int partition(int[] arr, int l, int r) {
        int pivot = arr[r], i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] > pivot) {
                i++;
                int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        }
        int t = arr[i + 1]; arr[i + 1] = arr[r]; arr[r] = t;
        return i + 1;
    }

    static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {500, 100, 300};

        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Merge:");
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println("Quick Desc:");
        System.out.println(Arrays.toString(arr));

        int sum = 0;
        for (int x : arr) sum += x;
        System.out.println("Total: " + sum);
    }
}