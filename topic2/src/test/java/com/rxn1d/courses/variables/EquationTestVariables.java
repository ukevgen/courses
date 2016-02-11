package com.rxn1d.courses.variables;

import java.util.ArrayList;
import java.util.List;

import com.rxn1d.courses.util.RandomUtils;
import com.rxn1d.courses.util.ValueToArrayPair;

/**
 * @author Ievgen Tararaka
 */
public class EquationTestVariables {
    public static final List<ValueToArrayPair<Integer, double[]>> coefficients = new ArrayList<>();

    static {
        EquationTestVariables.coefficients.add(new ValueToArrayPair(1, new Integer[]{1, 3, -4}));
        EquationTestVariables.coefficients.add(new ValueToArrayPair(3, new Integer[]{1, 0, -9}));
        EquationTestVariables.coefficients.add(new ValueToArrayPair(4, new Integer[]{1, -4, 0}));
    }

    public static Object[] getAllRandom() {
        return new Object[]{RandomUtils.getRandomFrom(coefficients)};
    }
}
