package com.rxn1d.courses.variables;

import java.util.ArrayList;
import java.util.List;

import com.rxn1d.courses.util.RandomUtils;
import com.rxn1d.courses.util.ValueToArrayPair;

/**
 * @author Ievgen Tararaka
 */
public class EquationTestVariables {
    public static final List<ValueToArrayPair<Integer, int[]>> coefficients = new ArrayList<>();

    static {
        EquationTestVariables.coefficients.add(new ValueToArrayPair(1, new Integer[]{3, 2, 1}));
        EquationTestVariables.coefficients.add(new ValueToArrayPair(1, new Integer[]{9, 4, 1}));
        EquationTestVariables.coefficients.add(new ValueToArrayPair(1, new Integer[]{1, 1, 1}));
    }

    public static Object[] getAllRandom() {
        return new Object[]{RandomUtils.getRandomFrom(coefficients)};
    }
}
