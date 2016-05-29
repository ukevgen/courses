import Dao.Imp.BankDaoImp;

/**
 * Created by Администратор on 26.05.2016.
 */
public class Factory {

    private  BankDaoImp daoBank;

    public Factory(BankDaoImp daoBank) {
        this.daoBank = daoBank;
    }

    public BankDaoImp getDaoBank() {
        if (daoBank == null) {
            daoBank = new BankDaoImp();
        }
        return daoBank;
    }
}
