package useSwing.swingSort;

import useSwing.sortThread.Lock;

/**
 * Created by Администратор on 22.04.2016.
 */
public final class BubbleSort extends Array implements Runnable {

    public BubbleSort(Lock lock) {
        super(lock);
    }

    private void bubbleSort() throws InterruptedException {

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < array.length; i++) {
                int temp = 0;
                if (array[i - 1] > array[i]) {
                    temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                    Thread.sleep(20);
                }
            }
        }
    }

    @Override
    public void run() {

        while (true) {
            if (!lock.isWait()) {
                try {
                    System.out.println(lock.isWait());
                    bubbleSort();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int[] getArray() {
        return super.getArray();
    }
}
