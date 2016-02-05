package com.rxn1d.courses;

import java.util.Arrays;

import com.rxn1d.courses.util.ValueToArrayPair;
import com.rxn1d.courses.variables.EquationTestVariables;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

/**
 * Это класс(файл) должен остаться неизменным!
 *
 * @author Ievgen Tararaka
 */
@RunWith(Parameterized.class)
public class HomeWork2EquationTest {
    private ValueToArrayPair<Integer, Integer> coefficientsEntry;

    public HomeWork2EquationTest(ValueToArrayPair<Integer, Integer> coefficientsEntry) {
        this.coefficientsEntry = coefficientsEntry;
    }

    @Parameterized.Parameters(name = "{index}: coefficient:{0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(EquationTestVariables.getAllRandom(), EquationTestVariables.getAllRandom(), EquationTestVariables.getAllRandom());
    }

    @Test
    public void testEquation() {
        assertTrue(HomeWork2Loops.min(ArrayUtils.toPrimitive(coefficientsEntry.right)) == coefficientsEntry.left);
    }
}
