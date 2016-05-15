package Customer;

/**
 * Created by Администратор on 08.05.2016.
 */
public class Ad {

    private String CAR_NAME;
    private int PRICE;
    private int ID;

    public Ad (){}
    public Ad(int ID, String CAR_NAME, int PRICE ) {
        this.CAR_NAME = CAR_NAME;
        this.PRICE = PRICE;
        this.ID=ID;
    }

    public String getCAR_NAME() {
        return CAR_NAME;
    }

    public int getPRICE() {
        return PRICE;
    }

    public void setCAR_NAME(String CAR_NAME) {
        this.CAR_NAME = CAR_NAME;
    }

    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "CAR_NAME='" + CAR_NAME + '\'' +
                ", PRICE=" + PRICE +
                ", ID=" + ID +
                '}';
    }
}
