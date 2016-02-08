package com.rxn1d.courses.util;

import java.util.List;
import java.util.Random;

/**
 * @author Ievgen Tararaka
 */
public class RandomUtils {
    public static Object getRandomFrom(List<? extends Object> list) {
        Random r = new Random();
        int random = r.nextInt(list.size());
        return list.get(random);
    }
}
