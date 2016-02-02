package com.rxn1d.courses;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Это файл должен остаться неизменным!
 *
 * @author Ievgen Tararaka
 */
@RunWith(Parameterized.class)
public class HomeWorkTest {
    private Map.Entry<Integer, int[]> coefficientsEntry;
    private Map.Entry<Integer, int[]> minArrayEntry;
    private Map.Entry<Double, double[]> maxArrayEntry;
    private Map.Entry<Short, short[]> averageArrayEntry;
    private Map.Entry<char[], char[]> reverseArrayEntry;
    private HomeWork homeWork;

    public HomeWorkTest(Map.Entry<Integer, int[]> coefficientsEntry, Map.Entry<Integer, int[]> minArrayEntry, Map.Entry<Double, double[]> maxArrayEntry,
                        Map.Entry<Short, short[]> averageArrayEntry, Map.Entry<char[], char[]> reverseArrayEntry) {
        this.coefficientsEntry = coefficientsEntry;
        this.minArrayEntry = minArrayEntry;
        this.maxArrayEntry = maxArrayEntry;
        this.averageArrayEntry = averageArrayEntry;
        this.reverseArrayEntry = reverseArrayEntry;
        homeWork = new HomeWork();
    }

    @Parameterized.Parameters(name = "{index}: coefficient:{0}, min:{1}, max:{2}, average:{3}, reverse:{4}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Constants.getRandomFrom(Constants.coefficientsMap), Constants.getRandomFrom(Constants.minArrayMap), Constants.getRandomFrom(Constants.maxArrayMap),
                        Constants.getRandomFrom(Constants.averageArrayMap), Constants.getRandomFrom(Constants.reverseArrayMap)},

        });
    }

    @Test
    public void testEquation() {

    }

    @Test
    public void testMin() {
        assertTrue(homeWork.min(minArrayEntry.getValue()) == minArrayEntry.getKey());
    }

    @Test
    public void testMax() {
        assertTrue(homeWork.max(maxArrayEntry.getValue()) == maxArrayEntry.getKey());
    }

    @Test
    public void testAverage() {
        assertTrue(homeWork.average(averageArrayEntry.getValue()) == averageArrayEntry.getKey());
    }

    @Test
    public void testReverse() {
        assertTrue(homeWork.reverse(reverseArrayEntry.getValue()) == reverseArrayEntry.getKey());
    }
}
