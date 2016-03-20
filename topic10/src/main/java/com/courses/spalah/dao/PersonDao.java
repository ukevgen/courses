package com.courses.spalah.dao;

import java.util.*;

import com.courses.spalah.FileReader;
import com.courses.spalah.domain.Person;

/**
 * Implement this file. Work with DB simulation
 *
 * @author Ievgen Tararaka
 */
public class PersonDao implements Dao<Person> {
    FileReader fileReader;
    private TreeMap<Long, Person> line = new TreeMap<>();
    private ArrayList<String> list = new ArrayList<>();
    private static final String separator = ";";

    public PersonDao(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(line.values());
    }

    @Override
    public Person findById(Long id) {
        return line.get(id);
    }

    @Override
    public boolean update(Person entity) {
        if (!line.containsKey(entity.getId()))
            return false;
        else {
            Person old = line.get(entity.getId());
            if (old.equals(entity))
                return false;
            else {
                line.put(entity.getId(), entity);
                updateList();
                updateFile();
                return true;
            }
        }
    }

    @Override
    public boolean insert(Person entity) {
        if (line.containsKey(entity.getId()))
            return false;
        else {
            String filed = makeLine(entity);
            line.put(entity.getId(), entity);
            updateList();
            updateFile();
            return true;
        }
    }


    @Override
    public Person remove(Long id) {
        if (line.containsKey(id)){
            Person person = line.get(id);
            line.remove(id);
            updateList();
            updateFile();
            return person;

        }
        else return null;

    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    private void updateFile() {
        fileReader.clearFile();
        for (String s : list) {
            fileReader.inputText(s);
        }
    }

    private String makeLine(Person entity) {
        String filed = "";
        if (!list.isEmpty()) filed = "\n";
        filed += entity.getId() + separator + entity.getFirstName() + separator + entity.getLastName() +
                separator + entity.getAddress() + ";";
        return filed;
    }
    private void updateList(){
        list.clear();
        for (Person p :line.values()){
            list.add(makeLine(p));
        }
    }
}