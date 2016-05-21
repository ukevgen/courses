package mytask.Imp;

import mytask.JpaConnection.JpaUtil;
import mytask.domain.Client;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 21.05.2016.
 */
public class DaoBank {

    public void test() {
        EntityManager entityManager = null;
        try {
            entityManager = JpaUtil.getSessionFactory().createEntityManager();

            System.out.println("al is good");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        entityManager.close();
    }

    public List getAllClient() {

        EntityManager entityManager = null;
        List clients = null;

        try {
            entityManager = JpaUtil.getSessionFactory().createEntityManager();
            entityManager.getTransaction().begin();
            clients = entityManager.createQuery("from Client", Client.class).getResultList();
            System.out.println("al is good");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        entityManager.close();

        return clients;
    }


}
