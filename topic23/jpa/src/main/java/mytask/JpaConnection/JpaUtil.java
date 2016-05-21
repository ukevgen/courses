package mytask.JpaConnection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Администратор on 21.05.2016.
 */
public class JpaUtil {
    private static final EntityManagerFactory entityManager;
    static {
        try {
            entityManager = Persistence.createEntityManagerFactory("mytask.jpa");
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getSessionFactory() {
        return entityManager;
    }
}
