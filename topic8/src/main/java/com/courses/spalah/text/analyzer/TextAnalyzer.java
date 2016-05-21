package com.courses.spalah.text.analyzer;

import java.io.*;
import java.util.*;

import static com.courses.spalah.text.analyzer.TextMainer.*;

/**
 * @author Ievgen Tararaka
 */
public class TextAnalyzer {
    public static void main(String[] args) throws IOException {

        InputStream in = null;
        Writer out = null;
        ArrayList<Character> list = new ArrayList<>();
        try {
            in = new FileInputStream(new File("F:\\JavaLesson\\courses\\topic8\\src\\main\\resources\\text_sample.txt"));
            while (in.available() > 0) {
                char ch = (char) in.read();
                HowMuchSymbols(ch);
                HowMuchSentence(ch);
                list.add(Character.toLowerCase(ch));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                }
            }
        }
        in.close();
        try {
            out = new FileWriter(new File("F:\\JavaLesson\\courses\\topic8\\src\\main\\resources\\output.txt"));
            prepare(list);
            out.write("Общее количество символов " + getCountSymbols() + "\n");
            out.write("Количество предложений " + getCountSentence() + "\n");
            out.write("Количество слов " + HowMuchWords(list) + "\n");
            out.write("Количество уникальных слов " + HowMuchUniqueWords(list) + "\n");
            out.write("Самое часто встречающееся слово - " + frequentWord(list) + "\n");
            out.write("Длинa самого короткого слова " + theShortWordLength(list) + "\n");
            out.write("Длинa самого длинного слова " + theLongestWordLength(list) + "\n");
            out.write(statWords(list)+"\n");
            out.write(statSymbols(list)+"\n");
            out.flush();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                }
            }
        }

    }


}
