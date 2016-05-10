package com.courses.spalah.service;

import com.courses.spalah.domain.Book;
import com.courses.spalah.domain.BookShelf;

import javax.persistence.EntityManager;

/**
 * @author Ievgen Tararaka
 */
public class BookService {
    private EntityManager entityManager;

    public BookService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public void save(BookShelf bookShelf) {
        entityManager.getTransaction().begin();
        entityManager.persist(bookShelf);
        entityManager.getTransaction().commit();
    }
}
