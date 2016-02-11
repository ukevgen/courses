package com.rxn1d.courses.util;

/**
 * @author Ievgen Tararaka
 */
public class TestUtils {
    public static String buildMessage(String methodName, String arguments, String result, String expected) {
        return "Метод " + methodName + " сделан неверно." +
                "\nВходные данные: " + arguments +
                "\nРезультат: " + result +
                "\nОжидаемый результат: " + expected;
    }
}
