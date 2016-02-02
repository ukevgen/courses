package com.rxn1d.courses;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Ievgen Tararaka
 */
public class Constants {
    public static Map<Integer, int[]> coefficientsMap = new HashMap<Integer, int[]>();
    public static Map<Integer, int[]> minArrayMap = new HashMap<Integer, int[]>();
    public static Map<Double, double[]> maxArrayMap = new HashMap<Double, double[]>();
    public static Map<Short, short[]> averageArrayMap = new HashMap<Short, short[]>();
    public static Map<char[], char[]> reverseArrayMap = new HashMap<char[], char[]>();

    static {
        int[][] coefficients = new int[][]{
                {3, 2, 1},
                {9, 4, 1},
                {1, 1, 1}
        };
        coefficientsMap.put(1, coefficients[0]);
        coefficientsMap.put(1, coefficients[1]);
        coefficientsMap.put(1, coefficients[2]);

        int[][] minArray = new int[][]{
                {7, 8, 10, 11, 12, 1},
                {1, 2, 3, 4, 8, 9, 9},
                {6, 6, 6, 6, 6},
                {3, 2, 1, 0, -1, -111}
        };
        minArrayMap.put(1, minArray[0]);
        minArrayMap.put(1, minArray[1]);
        minArrayMap.put(6, minArray[2]);
        minArrayMap.put(-111, minArray[3]);

        double[][] maxArray = new double[][]{
                {1.0, 3.111, 2.2555, 9.9999},
                {-2.333, 123.123, 4.0},
                {3.33, 1.0, 2.0, 7.0, 100.0}
        };
        maxArrayMap.put(9.9999, maxArray[0]);
        maxArrayMap.put(123.123, maxArray[1]);
        maxArrayMap.put(100.0, maxArray[2]);

        short[][] averageArray = new short[][]{
                {10, 20, 30, 40, 50},
                {2, 126},
                {23, 13, 23, -59},
                {4, 4, 4, 4, 4, 4, 4}
        };
        averageArrayMap.put((short) 30, averageArray[0]);
        averageArrayMap.put((short) 64, averageArray[1]);
        averageArrayMap.put((short) 0, averageArray[2]);
        averageArrayMap.put((short) 4, averageArray[3]);

        char[][] reverseArray = new char[][]{
                {'a'},
                {'r', 'e', 'v', 'e', 'r', 's', 'e'},
                {'l', 'e', 'v', 'e', 'l'},
        };
        reverseArrayMap.put(new char[]{'a'}, reverseArray[0]);
        reverseArrayMap.put(new char[]{'e', 's', 'r', 'e', 'v', 'e', 'r'}, reverseArray[1]);
        reverseArrayMap.put(new char[]{'l', 'e', 'v', 'e', 'l'}, reverseArray[2]);
    }

    public static <T, V> Map.Entry<T, V> getRandomFrom(Map<T, V> map) {
        Random r = new Random();
        int random = r.nextInt(map.entrySet().size());
        int i = 0;
        for (Map.Entry<T, V> entry : map.entrySet()) {
            i++;
            if (i == random) {
                return entry;
            }
        }
        return map.entrySet().iterator().next();
    }
}
