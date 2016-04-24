package useSwing.swingSort;

import java.util.Arrays;

/**
 * Created by Администратор on 22.04.2016.
 */
public final class MergeSort {

    public static void mergeSort(int[] A) {
        if (A.length > 1) {
            int q = A.length / 2;
            int[] leftArray = Arrays.copyOfRange(A, 0, q);
            int[] rightArray = Arrays.copyOfRange(A, q, A.length);
            mergeSort(leftArray);
            mergeSort(rightArray);
            merge(A, leftArray, rightArray);
        }
    }

    private static void merge(int[] a, int[] l, int[] r) {
        int totElem = l.length + r.length;
        int i, li, ri;
        i = li = ri = 0;
        while (i < totElem) {
            if ((li < l.length) && (ri < r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                } else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            } else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }

    }

}
