package Dao;

import Customer.Ad;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Администратор on 08.05.2016.
 */
public interface AdDao {

    public void addAd(Ad ad) throws SQLException;

    public List getAll() throws SQLException;

}
