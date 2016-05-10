package main.java;

import main.java.Dao.AdDao;
import main.java.Dao.Imp.AdDaoImp;

/**
 * Created by Администратор on 08.05.2016.
 */
public class Factory {

    private static AdDao adDao = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public AdDao getAdDAO() {
        if (adDao == null) {
            adDao = new AdDaoImp();
        }
        return adDao;
    }
}
