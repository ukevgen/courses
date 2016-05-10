package main.java.HibernateConnection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Created by Администратор on 08.05.2016.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
