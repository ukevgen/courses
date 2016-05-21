package Dao.Imp;

import Customer.Ad;
import Dao.AdDao;
import HibernateConnection.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Администратор on 08.05.2016.
 */
public class AdDaoImp implements AdDao {

    @Override
    public void addAd(Ad ad) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(ad);
            session.getTransaction().commit();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    @Override
    public List getAll() throws SQLException {
        Session session = null;
        List advertisement = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Query query = session.createQuery("from Ad");
            Query query = session.createQuery(
                    "select b from Ad b left join b.car car left join car.owner owner");
            advertisement = query.list();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
        return advertisement;
    }
}

