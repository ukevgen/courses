package com.rxn1d.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Ievgen Tararaka
 */
public class TestVariables {
    public static final List<ValueToArrayPair<Integer, int[]>> coefficients = new ArrayList<ValueToArrayPair<Integer, int[]>>();
    public static final List<ValueToArrayPair<Integer, int[]>> minArrays = new ArrayList<ValueToArrayPair<Integer, int[]>>();
    public static final List<ValueToArrayPair<Double, double[]>> maxArrays = new ArrayList<ValueToArrayPair<Double, double[]>>();
    public static final List<ValueToArrayPair<Short, short[]>> averageArrays = new ArrayList<ValueToArrayPair<Short, short[]>>();
    public static final List<ValueToArrayPair<char[], char[]>> reverseArrays = new ArrayList<ValueToArrayPair<char[], char[]>>();

    static {
        Integer[][] coefficients = new Integer[][]{
                {3, 2, 1},
                {9, 4, 1},
                {1, 1, 1}
        };
        TestVariables.coefficients.add(new ValueToArrayPair(1, coefficients[0]));
        TestVariables.coefficients.add(new ValueToArrayPair(1, coefficients[1]));
        TestVariables.coefficients.add(new ValueToArrayPair(1, coefficients[2]));

        Integer[][] minArray = new Integer[][]{
                {7, 8, 10, 11, 12, 1},
                {1, 2, 3, 4, 8, 9, 9},
                {6, 6, 6, 6, 6},
                {3, 2, 1, 0, -1, -111}
        };
        TestVariables.minArrays.add(new ValueToArrayPair(1, minArray[0]));
        TestVariables.minArrays.add(new ValueToArrayPair(1, minArray[1]));
        TestVariables.minArrays.add(new ValueToArrayPair(6, minArray[2]));
        TestVariables.minArrays.add(new ValueToArrayPair(-111, minArray[3]));

        Double[][] maxArray = new Double[][]{
                {1.0, 3.111, 2.2555, 9.9999},
                {-2.333, 123.123, 4.0},
                {3.33, 1.0, 2.0, 7.0, 100.0}
        };
        TestVariables.maxArrays.add(new ValueToArrayPair(9.9999, maxArray[0]));
        TestVariables.maxArrays.add(new ValueToArrayPair(123.123, maxArray[1]));
        TestVariables.maxArrays.add(new ValueToArrayPair(100.0, maxArray[2]));

        Short[][] averageArray = new Short[][]{
                {10, 20, 30, 40, 50},
                {2, 126},
                {23, 13, 23, -59},
                {4, 4, 4, 4, 4, 4, 4}
        };
        TestVariables.averageArrays.add(new ValueToArrayPair((short) 30, averageArray[0]));
        TestVariables.averageArrays.add(new ValueToArrayPair((short) 64, averageArray[1]));
        TestVariables.averageArrays.add(new ValueToArrayPair((short) 0, averageArray[2]));
        TestVariables.averageArrays.add(new ValueToArrayPair((short) 4, averageArray[3]));

        Character[][] reverseArray = new Character[][]{
                {'a'},
                {'r', 'e', 'v', 'e', 'r', 's', 'e'},
                {'l', 'e', 'v', 'e', 'l'},
        };
        TestVariables.reverseArrays.add(new ValueToArrayPair(new char[]{'a'}, reverseArray[0]));
        TestVariables.reverseArrays.add(new ValueToArrayPair(new char[]{'e', 's', 'r', 'e', 'v', 'e', 'r'}, reverseArray[1]));
        TestVariables.reverseArrays.add(new ValueToArrayPair(new char[]{'l', 'e', 'v', 'e', 'l'}, reverseArray[2]));
    }

    public static <L, R> ValueToArrayPair<L, R> getRandomFrom(List<ValueToArrayPair<L, R>> list) {
        Random r = new Random();
        int random = r.nextInt(list.size());
        return list.get(random);
    }

    public static Object[] getAllRandom() {
        return new Object[]{
                getRandomFrom(TestVariables.coefficients),
                getRandomFrom(TestVariables.minArrays),
                getRandomFrom(TestVariables.maxArrays),
                getRandomFrom(TestVariables.averageArrays),
                getRandomFrom(TestVariables.reverseArrays)
        };
    }
}
