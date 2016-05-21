package com.courses.spalah.text.analyzer;

import java.util.*;

/**
 * Created by Администратор on 09.03.2016.
 */
public final class TextMainer {
    static int countSymbols;
    static int countSentence;
    static final int MINIMALLEN = 2;
    static ArrayList<String> asList;

    static void HowMuchSymbols(char a) {
        if (a != ' ')
            countSymbols++;
    }

    static String HowMuchWords(ArrayList<Character> list) {
        int countWords = 0;
        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i) != ' ' && list.get(i + 1) != ' ' && list.get(i + 2) == ' ')
                countWords++;
        }

        return String.valueOf(countWords);
    }

    static String HowMuchUniqueWords(ArrayList<Character> list) {
        HashSet<String> set = new HashSet<String>(asList);
        return String.valueOf(set.size());
    }

    static void HowMuchSentence(char ch) {
        if (ch == '.' || ch == '?' || ch == '!')
            countSentence++;
    }

    static String frequentWord(ArrayList<Character> list) {
        String word = "";
        int kol = 0;
        HashMap<String, Integer> map = preapareMap(asList);
        for (String str : asList) {
            map.put(str, map.get(str) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value >= kol) {
                kol = value;
                word = entry.getKey();
            }
        }

        return word;
    }

    static String theShortWordLength(ArrayList<Character> list) {
        HashSet<String> set = new HashSet<String>(asList);
        int len = MINIMALLEN;
        for (String str : set) {
            if (str.length() < len && str.length() != 1)
                len = str.length();
        }
        return String.valueOf(len);
    }

    static String theLongestWordLength(ArrayList<Character> list) {
        HashSet<String> set = new HashSet<String>(asList);
        int len = 0;
        for (String str : set) {
            if (str.length() > len)
                len = str.length();
        }

        return String.valueOf(len);
    }

    static String statWords(ArrayList<Character> list) {
        String result = "";
        HashMap<String, Integer> map = preapareMap(asList);
        for (String str : asList) {
            map.put(str, map.get(str) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result += entry.getKey() + " - " + entry.getValue() + "\n";
        }
        return result;

    }

    static String statSymbols(ArrayList<Character> list) {
        HashSet<Character> set = new HashSet<Character>(list);
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : set) {
            map.put(ch, 0);
        }
        for (Character ch : list) {
            if (Character.isLetter(ch))
                map.put(ch, map.get(ch) + 1);
        }
        String result = "";
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0)
                result += entry.getKey() + " - " + entry.getValue() + "\n";
        }
        return result;
    }

    public static void prepare(ArrayList<Character> list) {
        String s = "";
        String s1 = "";
        for (Character ch : list) {
            if (!(Character.isLetterOrDigit(ch) || Character.isSpaceChar(ch)))
                s += " ";
            if (Character.isAlphabetic(ch) || ch.equals(' '))
                s += Character.toLowerCase(ch);
        }
        s1 = s.replaceAll("\\s+", " ");
        asList = new ArrayList<String>(Arrays.asList(s1.split(" ")));

    }

    private static HashMap<String, Integer> preapareMap(ArrayList<String> asList) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : asList) {
            map.put(str, 0);
        }
        return map;
    }

    public static String getCountSymbols() {
        return String.valueOf(countSymbols);
    }

    public static String getCountSentence() {
        return String.valueOf(countSentence);
    }

}
