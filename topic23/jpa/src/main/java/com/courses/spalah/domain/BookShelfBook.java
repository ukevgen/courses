package com.courses.spalah.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Ievgen Tararaka
 */
//@Entity
//@Table(name = "book_shelves_books")
public class BookShelfBook {
    @Column(name = "shelfe_id")
    private BookShelf bookShelf;
    @Column(name = "book_id")
    private Book book;

    public BookShelfBook() {
    }

    public BookShelf getBookShelf() {
        return bookShelf;
    }

    public void setBookShelf(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
