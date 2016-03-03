package com.courses.spalah.list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Ievgen Tararaka
 */
public class ListFactory {
    public static <E> com.courses.spalah.list.MyList<E> createList(ListType listType) {
        return new MyMyList();
    }

    public static class MyMyList<E> implements com.courses.spalah.list.MyList<E> {
        java.util.List<E> list = new LinkedList<>();

        public MyMyList() {
        }

        @Override
        public int size() {
            return list.size();
        }

        @Override
        public boolean isEmpty() {
            return list.isEmpty();
        }

        @Override
        public boolean add(E element) {
            return list.add(element);
        }

        @Override
        public void add(int index, E element) {
            list.add(index, element);
        }

        @Override
        public void remove(int index) {
            list.remove(index);
        }

        @Override
        public E get(int index) {
            return list.get(index);
        }

        @Override
        public E set(int index, E element) {
            return list.set(index, element);
        }

        @Override
        public boolean contains(E element) {
            return list.contains(element);
        }

        @Override
        public Iterator<E> iterator() {
            return list.iterator();
        }
    }
}
