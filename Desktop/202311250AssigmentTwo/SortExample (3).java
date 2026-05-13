import java.util.Arrays;

/**
 * This program shows quick sort and merge sort examples.
 * (Simple implementation for practice)
 */
public class SortExample {

    public static void main(String[] args) {

        // unsorted arrays
        Integer[] array1 = {12, 13, 24, 10, 3, 6, 90, 70};
        int[] array2 = {2, 6, 3, 5, 1};

        // sorting using quick sort
        quickSort(array1, 0, array1.length - 1);
        System.out.println(Arrays.toString(array1));

        // sorting using merge sort
        mergeSort(array2, array2.length);
        System.out.println(Arrays.toString(array2));
    }

    // quick sort function
    public static void quickSort(Integer[] arr, int low, int high) {

        if (arr == null || arr.length == 0) return;
        if (low >= high) return;

        // choose middle element as pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low;
        int j = high;

        while (i <= j) {

            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // recursive calls
        if (low < j) {
            quickSort(arr, low, j);
        }

        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    // swap two elements
    public static void swap(Integer[] array, int x, int y) {

        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // merge sort function
    public static void mergeSort(int[] a, int n) {

        if (n < 2) return;

        int mid = n / 2;

        int[] left = new int[mid];
        int[] right = new int[n - mid];

        // copy left part
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }

        // copy right part
        for (int i = mid; i < n; i++) {
            right[i - mid] = a[i];
        }

        // recursive calls
        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(a, left, right, mid, n - mid);
    }

    // merge two sorted arrays
    public static void merge(int[] a, int[] left, int[] right, int leftSize, int rightSize) {

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {

            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            a[k++] = left[i++];
        }

        while (j < rightSize) {
            a[k++] = right[j++];
        }
    }

    // check if array is sorted
    private static boolean isSorted(int[] x) {

        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) {
                return false;
            }
        }
        return true;
    }
}