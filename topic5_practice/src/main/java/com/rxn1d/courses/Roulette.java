package com.rxn1d.courses;

import java.util.HashMap;

/**
 * Created by Администратор on 24.02.2016.
 */
public interface Roulette {

    String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
            "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36"};

    boolean isRed(String color);

    boolean isEven(String even);

    boolean isBig(String num);
}


