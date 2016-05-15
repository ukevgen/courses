package Customer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 08.05.2016.
 */
public class Ad {

    private int ID;
    private Set car = new HashSet();
    private String CAR_NAME;
    private int PRICE;


    public Ad() {
    }

    public Ad(int ID, Set car, String CAR_NAME, int PRICE) {
        this.ID = ID;
        this.car = car;
        this.CAR_NAME = CAR_NAME;
        this.PRICE = PRICE;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Set getCar() {
        return car;
    }

    public void setCar(Set car) {
        this.car = car;
    }

    public String getCAR_NAME() {
        return CAR_NAME;
    }

    public void setCAR_NAME(String CAR_NAME) {
        this.CAR_NAME = CAR_NAME;
    }

    public int getPRICE() {
        return PRICE;
    }

    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "CAR_NAME='" + CAR_NAME + '\'' +
                ", PRICE=" + PRICE +
                ", ID=" + ID +
                ", car=" + car.toString() +
                '}';
    }
}
