package com.rxn1d.courses;

import java.util.Arrays;

import com.rxn1d.courses.util.ValueToValuePair;
import com.rxn1d.courses.variables.StringTestVariables;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Ievgen Tararaka
 */
@RunWith(Parameterized.class)
public class HomeWork2StringTest {
    private ValueToValuePair<Integer, String> countEvenEntry;
    private ValueToValuePair<String, ValueToValuePair<String, String>> removeSymbolFromStringEntry;

    public HomeWork2StringTest(ValueToValuePair<Integer, String> countEvenEntry,
                               ValueToValuePair<String, ValueToValuePair<String, String>> removeSymbolFromStringEntry) {
        this.countEvenEntry = countEvenEntry;
        this.removeSymbolFromStringEntry = removeSymbolFromStringEntry;
    }

    @Parameterized.Parameters(name = "{index}: countEven:{0}, removeSymbolFromString:{1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(StringTestVariables.getAllRandom(), StringTestVariables.getAllRandom(), StringTestVariables.getAllRandom());
    }

    @Test
    public void testCountEven() {
        Assert.assertTrue("", HomeWork2String.countEvenInString(countEvenEntry.right) == countEvenEntry.left);
    }

    @Test
    public void testRemoveSymbolFromString() {
        ValueToValuePair<String, String> arguments = removeSymbolFromStringEntry.right;
        Assert.assertTrue("", HomeWork2String.removeSymbolFromString(arguments.left, arguments.right).equals(removeSymbolFromStringEntry.left));
    }
}
