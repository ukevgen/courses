package home;

import home.Sort.*;

import java.util.Random;

/**
 * Created by Администратор on 22.04.2016.
 */
public class MySort {
    public static void main(String[] args) {

        Random random = new Random();
        int arr[] = {11, 1, 3, 2, 10, 8};
        //for (int i=0;i<5;i++){
        //  arr[i]=random.nextInt(100);
        //}
        //s.bubbleSort(arr);
        System.out.println("next algoritm");
        //InsertionSort.insertionSort(arr);
        //HeapSort.heapSort(arr);
        //BubbleSort.bubbleSort(arr);
        //MergeSort.mergeSort(arr);

        BogoSort.bogoSort(arr);
        printNumbers(arr);

    }
    private static void printNumbers(int[] input) {

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }
}
