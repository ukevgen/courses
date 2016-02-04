package com.rxn1d.courses;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

/**
 * Это файл должен остаться неизменным!
 *
 * @author Ievgen Tararaka
 */
@RunWith(Parameterized.class)
public class HomeWork2Test {
    private ValueToArrayPair<Integer, Integer> coefficientsEntry;
    private ValueToArrayPair<Integer, Integer> minArrayEntry;
    private ValueToArrayPair<Double, Double> maxArrayEntry;
    private ValueToArrayPair<Short, Short> averageArrayEntry;
    private ValueToArrayPair<char[], Character> reverseArrayEntry;
    private HomeWork2 homeWork;

    public HomeWork2Test(ValueToArrayPair<Integer, Integer> coefficientsEntry, ValueToArrayPair<Integer, Integer> minArrayEntry, ValueToArrayPair<Double, Double> maxArrayEntry,
                         ValueToArrayPair<Short, Short> averageArrayEntry, ValueToArrayPair<char[], Character> reverseArrayEntry) {
        this.coefficientsEntry = coefficientsEntry;
        this.minArrayEntry = minArrayEntry;
        this.maxArrayEntry = maxArrayEntry;
        this.averageArrayEntry = averageArrayEntry;
        this.reverseArrayEntry = reverseArrayEntry;
        homeWork = new HomeWork2();
    }

    @Parameterized.Parameters(name = "{index}: coefficient:{0}, min:{1}, max:{2}, average:{3}, reverse:{4}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(TestVariables.getAllRandom(), TestVariables.getAllRandom(), TestVariables.getAllRandom());
    }

    @Test
    public void testEquation() {

    }

    @Test
    public void testMin() {
        assertTrue(homeWork.min(ArrayUtils.toPrimitive(minArrayEntry.right)) == minArrayEntry.left);
    }

    @Test
    public void testMax() {
        assertTrue(homeWork.max(ArrayUtils.toPrimitive(maxArrayEntry.right)) == maxArrayEntry.left);
    }

    @Test
    public void testAverage() {
        assertTrue(homeWork.average(ArrayUtils.toPrimitive(averageArrayEntry.right)) == averageArrayEntry.left);
    }

    @Test
    public void testReverse() {
        assertTrue(homeWork.reverse(ArrayUtils.toPrimitive(reverseArrayEntry.right)) == reverseArrayEntry.left);
    }
}
