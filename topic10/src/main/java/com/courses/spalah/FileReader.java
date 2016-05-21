package com.courses.spalah;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

/**
 * @author Ievgen Tararaka
 */
public class FileReader {
    private String pathToFile;

    public FileReader(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    /**
     * Should return content of file by path
     *
     * @return content of file
     */
    public String readFile() {
        URL url = Thread.currentThread().getContextClassLoader().getResource(getPathToFile());
        try (BufferedReader in = new BufferedReader(new java.io.FileReader(new File(url.toURI())))) {
            StringBuilder sb = new StringBuilder();
            String line = in.readLine();
            while (line != null) {
                sb.append(line);
                line = in.readLine();
            }
            return sb.toString();
        } catch (IOException | URISyntaxException e) {
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
        URL url = Thread.currentThread().getContextClassLoader().getResource(getPathToFile());
        try (Writer writer = new FileWriter(new File(url.toURI()), true)) {
            writer.write(text);
            writer.flush();
            return true;
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clearFile() {
        FileOutputStream out = null;
        URL url = Thread.currentThread().getContextClassLoader().getResource(getPathToFile());
        try {
            out = new FileOutputStream(new File(url.toURI()));
            out.write(new String().getBytes());
        } catch (IOException | URISyntaxException e) {
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
