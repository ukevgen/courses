package com.rxn1d.courses;

import java.util.Arrays;

import com.rxn1d.courses.util.ValueToArrayPair;
import com.rxn1d.courses.variables.EquationTestVariables;
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
        int a = coefficientsEntry.right[0];
        int b = coefficientsEntry.right[1];
        int c = coefficientsEntry.right[2];
        int expectedResponse = coefficientsEntry.left;

        int response = HomeWork2Equation.solveEquation(a, b, c);

        assertTrue("Уравнение решенно неверно. " +
                        "\nКоэфициенты: a=" + a + ", b=" + b + ", c=" + c +
                        "\nРезультат: " + response +
                        "\nОжидаемый результат: " + expectedResponse,
                response == expectedResponse);
    }
}
