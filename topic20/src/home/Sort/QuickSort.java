package home.Sort;

/**
 * Created by Администратор on 22.04.2016.
 */
public final class QuickSort {

    private static int pivot(int[] a, int lo, int hi) {
        int mid = (lo + hi) / 2;
        int pivot = a[lo] + a[hi] + a[mid] - Math.min(Math.min(a[lo], a[hi]), a[mid])
                - Math.max(Math.max(a[lo], a[hi]), a[mid]);

        if (pivot == a[lo])
            return lo;
        else if (pivot == a[hi])
            return hi;
        return mid;
    }

    private static int partition(int[] a, int lo, int hi) {

        int k = pivot(a, lo, hi);
        //System.out.println(k);
        swap(a, lo, k);
        //System.out.println(a);
        int j = hi + 1;
        int i = lo;
        while (true) {

            while (a[lo] < a[--j])
                if (j == lo) break;

            while (a[++i] < a[lo])
                if (i == hi) break;

            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int p = partition(a, lo, hi);
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);
    }

    private static void swap(int[] a, int b, int c) {
        int swap = a[b];
        a[b] = a[c];
        a[c] = swap;
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }
}
