package useSwing.swingSort;

import useSwing.sortThread.Lock;

import java.util.Random;

/**
 * Created by Администратор on 05.05.2016.
 */
public abstract class Array {

    private static final int SIZE = 100;
    protected int[] array = new int[SIZE];
    protected   Lock lock;

    Array(Lock lock) {
        this.lock = lock;
        setArray();
    }

    private void setArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    public int[] getArray() {
        return array;
    }
}
