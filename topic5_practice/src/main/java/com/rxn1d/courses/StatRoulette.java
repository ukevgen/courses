package com.rxn1d.courses;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author User
 */
public  class StatRoulette extends InitRoulette {
    private static TreeMap<String, Integer> statRoulette = new TreeMap<>(roulette);


    public  void setStatNumbers(String number) {
        statRoulette.put(number, statRoulette.get(number) + 1);

    }

    @Override
    public String toString() {

        int countStaight = 0;
        int countRed = 0;
        int countBlack = 0;
        int countEeven = 0;
        int countOdd = 0;
        int countBig = 0;
        int countSmall = 0;

        for (Map.Entry<String, Integer> entry : statRoulette.entrySet()) {
            String number=entry.getKey();
            boolean isZero=number.equals("0");
            if (entry.getValue() != 0)
                countStaight+=entry.getValue();
            if (!isZero){
                if (isRed(number))
                    countRed+=entry.getValue();
                else
                    countBlack+=entry.getValue();
                if (isBig(number))
                    countBig+=entry.getValue();
                else
                    countSmall+=entry.getValue();
                if (isEven(number))
                    countEeven+=entry.getValue();
                else
                    countOdd+=entry.getValue();
            }
        }
        return "["+"RED ="+countRed+", "+"BLACK ="+countBlack+", "+"ODD ="+countOdd+", "+
                "EVEN ="+countEeven+", "+"SMALL ="+countSmall+", "+"BIG ="+countBig+", "+
                "STRAIGHT_UP = " + countStaight + "]" +"\n"+"Balance = "+getCasinoBalance()+"$"+"\n";

    }

    public  void getStatRoulette() {
        for (Map.Entry<String, Integer> entry : statRoulette.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
