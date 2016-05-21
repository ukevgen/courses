package mytask;

import mytask.Imp.DaoBank;

/**
 * Created by Администратор on 21.05.2016.
 */
public class Factory {

    private static DaoBank daoBank = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public DaoBank getDaoBank() {
        if (daoBank == null) {
            daoBank = new DaoBank();
        }
        return daoBank;
    }
}
