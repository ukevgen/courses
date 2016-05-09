package main.java.com.courses.spalah.Customer;

/**
 * Created by Администратор on 17.04.2016.
 */
public class Ad {
    private String CAR_NAME;
    private String PRICE;

    public Ad(String CAR_NAME, String PRICE) {
        this.CAR_NAME = CAR_NAME;
        this.PRICE = PRICE;
    }

    public String getCAR_NAME() {
        return CAR_NAME;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setCAR_NAME(String CAR_NAME) {
        this.CAR_NAME = CAR_NAME;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    @Override
    public String toString() {
        return "{" +
                "\"CAR_NAME\":" + '\"' + CAR_NAME + '\"' + "," +
                "\"PRICE\":\"" + PRICE + '\"' +
                '}';
    }
}
