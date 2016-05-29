package Dao.Imp;

import Dao.BankDao;
import Domain.Client;
import JpaConnection.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Администратор on 26.05.2016.
 */
public class BankDaoImp implements BankDao {

    public List getAllClient() {
        EntityManager entityManager = null;
        List clients = null;

        try {
            entityManager = JpaUtil.getEntityManager().createEntityManager();
            entityManager.getTransaction().begin();
            clients = entityManager.createQuery("from Client", Client.class).getResultList();
            System.out.println("al is good");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        entityManager.close();

        return clients;
    }

    public void test() {
        EntityManager entityManager = null;
        try {
            entityManager = JpaUtil.getEntityManager().createEntityManager();

            System.out.println("al is good");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        entityManager.close();

    }
}
