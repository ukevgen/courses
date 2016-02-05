package com.rxn1d.courses;

import java.util.Arrays;

import com.rxn1d.courses.util.ValueToArrayPair;
import com.rxn1d.courses.variables.LoopTestVariables;
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
public class HomeWork2LoopsTest {
    private ValueToArrayPair<Integer, Integer> minArrayEntry;
    private ValueToArrayPair<Double, Double> maxArrayEntry;
    private ValueToArrayPair<Short, Short> averageArrayEntry;
    private ValueToArrayPair<char[], Character> reverseArrayEntry;

    public HomeWork2LoopsTest(ValueToArrayPair<Integer, Integer> minArrayEntry, ValueToArrayPair<Double, Double> maxArrayEntry,
                              ValueToArrayPair<Short, Short> averageArrayEntry, ValueToArrayPair<char[], Character> reverseArrayEntry) {
        this.minArrayEntry = minArrayEntry;
        this.maxArrayEntry = maxArrayEntry;
        this.averageArrayEntry = averageArrayEntry;
        this.reverseArrayEntry = reverseArrayEntry;
    }

    @Parameterized.Parameters(name = "{index}: coefficient:{0}, min:{1}, max:{2}, average:{3}, reverse:{4}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(LoopTestVariables.getAllRandom(), LoopTestVariables.getAllRandom(), LoopTestVariables.getAllRandom());
    }

    @Test
    public void testMin() {
        assertTrue(HomeWork2Loops.min(ArrayUtils.toPrimitive(minArrayEntry.right)) == minArrayEntry.left);
    }

    @Test
    public void testMax() {
        assertTrue(HomeWork2Loops.max(ArrayUtils.toPrimitive(maxArrayEntry.right)) == maxArrayEntry.left);
    }

    @Test
    public void testAverage() {
        assertTrue(HomeWork2Loops.average(ArrayUtils.toPrimitive(averageArrayEntry.right)) == averageArrayEntry.left);
    }

    @Test
    public void testReverse() {
        assertTrue(HomeWork2Loops.reverse(ArrayUtils.toPrimitive(reverseArrayEntry.right)) == reverseArrayEntry.left);
    }
}
