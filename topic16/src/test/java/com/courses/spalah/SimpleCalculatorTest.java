package com.courses.spalah;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * @author Ievgen Tararaka
 */
@RunWith(JUnit4.class)
public class SimpleCalculatorTest {
    @Test
    public void testAddition() {
        assertEquals(10, SimpleCalculator.calculate('+', 2, 8));
    }

    @Test
    public void testSubtraction() {
        assertEquals(-6, SimpleCalculator.calculate('-', 2, 8));
    }

    @Test
    public void testMultiplication() {
        assertEquals(16, SimpleCalculator.calculate('*', 2, 8));
    }

    @Test
    public void testDividing() {
        assertEquals(0.25, SimpleCalculator.calculate('/', 2, 8), 0.001);
    }
}
