package home.Sort;

/**
 * Created by Администратор on 22.04.2016.
 */
public final class InsertionSort {
    public static void insertionSort(int[] unsorted) {
        for (int i = 1; i < unsorted.length; i++) {
            int j = i;
            while (j > 0 && unsorted[j] < unsorted[j - 1]) {
                int temp = unsorted[j - 1];
                unsorted[j - 1] = unsorted[j];
                unsorted[j] = temp;
                j--;
            }
        }
    }
}
