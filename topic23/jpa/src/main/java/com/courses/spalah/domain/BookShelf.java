package com.courses.spalah.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Ievgen Tararaka
 */
@Entity
@Table(name = "book_shelves")
public class BookShelf {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book", orphanRemoval = true)
    private Collection<Book> books = new ArrayList<Book>();

    public BookShelf() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
}
