package com.rxn1d.courses.util;

import java.util.Arrays;

/**
 * @author Ievgen Tararaka
 */
public class ValueToArrayPair<L, R> {
    public final L left;
    public final R[] right;

    public ValueToArrayPair(L left, R[] right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String rightString = Arrays.toString(right);
        return "{" +
                "ожидаемый результат=" + left +
                ", входные данные=" + rightString +
                '}';
    }
}
