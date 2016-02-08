package com.rxn1d.courses.variables;

import java.util.ArrayList;
import java.util.List;

import com.rxn1d.courses.util.RandomUtils;
import com.rxn1d.courses.util.ValueToValuePair;

/**
 * @author Ievgen Tararaka
 */
public class StringTestVariables {
    public static final List<ValueToValuePair<Integer, String>> countEvenList = new ArrayList<>();
    public static final List<ValueToValuePair<String, ValueToValuePair<String, String>>> removeSymbolFromStringList = new ArrayList<>();

    static {
        countEvenList.add(new ValueToValuePair<>(3, "1_4_8_11_22"));
        countEvenList.add(new ValueToValuePair<>(3, "1_4_8_11_22"));
        countEvenList.add(new ValueToValuePair<>(3, "1_4_8_11_22"));
        countEvenList.add(new ValueToValuePair<>(3, "1_4_8_11_22"));

        removeSymbolFromStringList.add(new ValueToValuePair<>("", new ValueToValuePair<>("", "")));
        removeSymbolFromStringList.add(new ValueToValuePair<>("", new ValueToValuePair<>("", "")));
        removeSymbolFromStringList.add(new ValueToValuePair<>("", new ValueToValuePair<>("", "")));
        removeSymbolFromStringList.add(new ValueToValuePair<>("", new ValueToValuePair<>("", "")));
    }

    public static Object[] getAllRandom() {
        return new Object[]{
                RandomUtils.getRandomFrom(countEvenList),
                RandomUtils.getRandomFrom(removeSymbolFromStringList)
        };
    }
}
