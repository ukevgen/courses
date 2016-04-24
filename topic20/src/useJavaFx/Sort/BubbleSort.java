package useJavaFx.Sort;

/**
 * Created by Администратор on 22.04.2016.
 */
public final class BubbleSort {
    public static void bubbleSort(int[] unsorted) {

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < unsorted.length; i++) {
                int temp = 0;
                if (unsorted[i - 1] > unsorted[i]) {
                    temp = unsorted[i - 1];
                    unsorted[i - 1] = unsorted[i];
                    unsorted[i] = temp;
                    swapped = true;
                }
            }
        }
    }
}
