package com.rxn1d.courses;

/**
 * Created by Администратор on 06.03.2016.
 */
public class Bet {
    String isRed(int number) {
        if (number == 0)
            return "GREEAN";
        else if (number % 2 != 0)
            return "RED";
        else
            return "BLACK";
    }

    String isOdd(int number) {
        if (number % 2 != 0)
            return "ODD";
        else
            return "EVEN";
    }

    String isBig(int number) {
        if (number >= 15)
            return "BIG";
        else
            return "SMALL";
    }

    boolean isStaightUp(String s) {
        return s.equals("STRAIGHT_UP") ? true : false;
    }

    boolean isBigOddRedSmallEvenBlack(String s) {
        if (s.equals("BIG") || s.equals("BLACK") || s.equals("EVEN")
                || s.equals("ODD") || s.equals("RED") || s.equals("SMALL"))
            return true;
        else return false;
    }


}
