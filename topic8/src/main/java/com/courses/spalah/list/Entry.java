package com.courses.spalah.list;

/**
 * Created by Администратор on 10.03.2016.
 */
public class Entry<E> {
    E element;
    Entry<E> next;

    public Entry(E element, Entry<E> next) {
        this.element = element;
        this.next = next;

    }

    public Entry(Entry<E> next) {
        element = null;
        this.next=next;
    }


    public E getElement() {
        return element;
    }

    public Entry<E> getNext() {
        return next;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(Entry<E> next) {
        this.next = next;
    }
}
