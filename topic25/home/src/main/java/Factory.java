import Dao.Imp.BankDaoImp;

/**
 * Created by Администратор on 26.05.2016.
 */
public class Factory {
    private static BankDaoImp daoBank = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public BankDaoImp getDaoBank() {
        if (daoBank == null) {
            daoBank = new BankDaoImp();
        }
        return daoBank;
    }
}
