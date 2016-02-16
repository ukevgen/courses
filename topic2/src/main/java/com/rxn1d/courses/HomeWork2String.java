package com.rxn1d.courses;

/**
 * Модифицируйте этот класс(файл)
 *
 * @author Ievgen Tararaka
 */
public class HomeWork2String {
    /**
     * Метод должен вернуть количество четных чисел в строке.
     * <p>Например:
     * дана строка - 1_4_8_11_22, ответ - 3
     *
     * @param s строка типа число1_число2_число3_число4
     * @return количество четных числе в строке
     */
    public static int countEvenInString(String s) {
        int kol = 0;
        String [] arr=s.split("_");
        for (int i = 0; i < arr.length; i++) {
            if (Integer.parseInt(arr[i])%2==0)

                //int cp = s.codePointAt(i);
                //if (!Character.isAlphabetic(cp) && Character.getNumericValue(cp) % 2 == 0 && Character.getNumericValue(cp) != -1)
                kol++;
            // System.out.println(Character.getNumericValue(cp));
        }
        return kol;
    }

    /**
     * Метод должен удалить указанный символ из строки (кроме случая, если
     * символ находится на первой, последней или срединной позиции)
     * <p>Например:
     * данна строка - xabxxxx, символ - x, ответ - xabx
     *
     * @param symbol символ который необходимо удалить
     * @param s      исходная строка
     * @return результирующая строка
     */
    public static String removeSymbolFromString(String symbol, String s) {

        String s1="";
        char [] chars = s.toCharArray();
        char [] symbols = symbol.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==symbols[0] && i!=(int)    chars.length/2 && i!=0 && i!=chars.length-1)
                ;
            else
                s1+=chars[i];
        }
        return s1;
    }



}
