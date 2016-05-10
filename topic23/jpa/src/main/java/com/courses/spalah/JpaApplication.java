package com.courses.spalah;

import com.courses.spalah.domain.Book;
import com.courses.spalah.domain.BookShelf;
import com.courses.spalah.service.BookService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;

/**
 * @author Ievgen Tararaka
 */
public class JpaApplication {
    private static final String PERSISTENCE_UNIT = "com.courses.spalah.jpa";

    public static void main(String[] args) {
        EntityManager entityManager = initEntityManager();
        BookService bookService = new BookService(entityManager);

        Book book1 = new Book();
        book1.setBookName("The Seasons");
        book1.setAuthor("Edward Young ");
        book1.setPublishDate(new Date(System.currentTimeMillis()));

        Book book2 = new Book();
        book2.setBookName("Robinson Crusoe");
        book2.setAuthor("Daniel Defoe");
        book2.setPublishDate(new Date(System.currentTimeMillis()));

        bookService.save(book1);
        bookService.save(book2);

        BookShelf bookShelf = new BookShelf();
        bookShelf.getBooks().add(book1);
        bookShelf.getBooks().add(book2);

        bookService.save(bookShelf);

        entityManager.close();
    }

    private static EntityManager initEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        return entityManagerFactory.createEntityManager();
    }
}
