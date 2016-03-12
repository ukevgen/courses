package com.courses.spalah.list;

import java.util.Iterator;

/**
 * Created by Администратор on 10.03.2016.
 */
public class NewLinkedList<E> implements MyList {
    private Entry head;
    private Entry next;
    private Entry tek;
    private int size;
    private int currentIndex;

    public NewLinkedList() {
        head = new Entry(null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object element) {
        Entry newEntry = new Entry(element, null);
        next = head;
        while (next.getNext() != null) {
            next = next.getNext();
        }
        next.setNext(newEntry);
        size++;
        return true;
    }

    @Override
    public Object get(int index) {
        tek = getIndex(index);
        return tek.getElement();
    }

    @Override
    public void add(int index, Object element) {
        next = head;
        Entry x = getIndex(index - 1);
        Entry y = getIndex(index);
        Entry newEntry = new Entry(element, null);
        x.setNext(newEntry);
        newEntry.setNext(y);

        size++;
    }

    @Override
    public void remove(int index) {
        Entry x = getIndex(index - 1);
        Entry y = getIndex(index + 1);
        x.setNext(y);
        size--;
    }


    @Override
    public Object set(int index, Object element) {
        getIndex(index).setElement(element);
        return null;
    }

    @Override
    public boolean contains(Object element) {
        next = head;
        boolean ex = false;
        while (next.getNext() != null) {
            next = next.getNext();
            if (next.getElement().equals(element))
                ex = true;
        }
        return ex;
    }

    @Override
    public Iterator iterator() {
        next = head;
        currentIndex = 0;
        class MyIterator implements Iterator {
            @Override
            public boolean hasNext() {
                if (currentIndex < size()) {
                    currentIndex++;
                    next = next.getNext();
                    return true;
                } else
                    return false;
            }

            @Override
            public Object next() {
                return next.getElement();
            }

            @Override
            public void remove() {
                NewLinkedList.this.remove(currentIndex);
                currentIndex--;
                size--;
            }
        }

        return new MyIterator();
    }

    private Entry getIndex(int index) {
        next = head;
        int i = 0;
        while (i <= index) {
            next = next.getNext();
            i++;
        }
        return next;
    }
}
