package com.courses.spalah;

import java.io.*;
import java.nio.file.Files;

/**
 * @author Ievgen Tararaka
 */
public class FileReader {
    public String pathToFile;

    public FileReader(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    /**
     * Should return content of file by path
     *
     * @return content of file
     */
    public String readFile() {

        try (BufferedReader in = new BufferedReader(new java.io.FileReader(
                "F:\\JavaLesson\\courses\\topic10\\src\\test\\resources\\"+pathToFile))) {
            StringBuilder sb = new StringBuilder();
            String line = in.readLine();
            while (line != null) {
                sb.append(line);
                line = in.readLine();
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public boolean inputText(String text) {
        try (Writer writer = new FileWriter("F:\\JavaLesson\\courses\\topic10\\src\\test\\resources\\"+pathToFile,true)) {
            writer.write(text);
            writer.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void clearFile() {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("F:\\JavaLesson\\courses\\topic10\\src\\test\\resources\\"+pathToFile);
            out.write(new String().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
