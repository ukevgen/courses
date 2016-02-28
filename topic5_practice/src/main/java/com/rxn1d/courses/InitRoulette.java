package com.rxn1d.courses;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Администратор on 28.02.2016.
 */
class InitRoulette implements Roulette {
    protected static HashMap<String, Integer> roulette = new HashMap();


    public void SetRoulette() {
        for (int i = 0; i < numbers.length; i++) {
            roulette.put(numbers[i], 0);
        }
    }

    @Override
    public String toString() {
        String result = "[";
        for (Map.Entry<String, Integer> entry : roulette.entrySet()) {
            result += entry.getKey();
            if (entry.getKey().equals("0"))
                result += "-GREEN, ";
            else if (isRed(entry.getKey()))
                result += "-RED, ";
            else result += "-BLACK, ";
        }
        return result.substring(0,result.length()-2)+"]";
    }

    public HashMap<String, Integer> getRoulette() {
        return roulette;
    }

    public void getRouletteSize() {
        System.out.println(roulette.size());
    }

    public boolean isRed(String color) {
        if (Integer.parseInt(color) % 2 != 0)
            return true;
        else
            return false;
    }

    public boolean isEven(String even) {
        if (Integer.parseInt(even) % 2 == 0)
            return true;
        else return false;
    }

    public boolean isBig(String num) {
        if (Integer.parseInt(num) > 18)
            return true;
        else return false;
    }


}
