package useJavaFx.Sort;

/**
 * Created by Администратор on 22.04.2016.
 */
public final class BogoSort {

    public static void bogoSort(int[] i) {
        int counter = 0;
        while (!isSorted(i)) {
            shuffle(i);
            counter++;
        }
    }

    private static void shuffle(int[] i) {
        for (int x = 0; x < i.length; ++x) {
            int index1 = (int) (Math.random() * i.length), index2 = (int) (Math
                    .random() * i.length);
            int a = i[index1];
            i[index1] = i[index2];
            i[index2] = a;
        }
    }

    private static boolean isSorted(int[] i) {
        for (int x = 0; x < i.length - 1; ++x) {
            if (i[x] > i[x + 1]) {
                return false;
            }
        }
        return true;
    }
}
