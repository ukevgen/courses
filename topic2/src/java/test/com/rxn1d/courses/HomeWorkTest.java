package com.rxn1d.courses;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.omg.CORBA.Object;

import java.util.Arrays;
import java.util.Map;

/**
 * Это файл должен остаться неизменным!
 *
 * @author Ievgen Tararaka
 */
@RunWith(Parameterized.class)
public class HomeWorkTest {
    private Map.Entry<Integer, int[]> coefficientsMap;
    private Map.Entry<Integer, int[]> minArrayMap;
    private Map.Entry<Double, double[]> maxArrayMap;
    private Map.Entry<Short, short[]> averageArrayMap;
    private Map.Entry<char[], char[]> reverseArrayMap;
    private HomeWork homeWork;

    public HomeWorkTest(Map.Entry<Integer, int[]> coefficientsMap, Map.Entry<Integer, int[]> minArrayMap, Map.Entry<Double, double[]> maxArrayMap,
                        Map.Entry<Short, short[]> averageArrayMap, Map.Entry<char[], char[]> reverseArrayMap) {
        this.coefficientsMap = coefficientsMap;
        this.minArrayMap = minArrayMap;
        this.maxArrayMap = maxArrayMap;
        this.averageArrayMap = averageArrayMap;
        this.reverseArrayMap = reverseArrayMap;
        homeWork = new HomeWork();
    }

    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{

        });
    }
}
