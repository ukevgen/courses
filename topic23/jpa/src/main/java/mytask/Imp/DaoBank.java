package mytask.Imp;

import mytask.JpaConnection.JpaUtil;

import javax.persistence.EntityManager;

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


    }
}
