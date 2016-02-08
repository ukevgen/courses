package com.rxn1d.courses.util;

/**
 * @author Ievgen Tararaka
 */
public class ValueToValuePair<L, R> {
    public final L left;
    public final R right;

    public ValueToValuePair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "ValueToValuePair{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
