package com.courses.spalah.Customer;

/**
 * Created by Администратор on 17.04.2016.
 */
public class Ad {
    private String carName;
    private String price;

    public Ad(String carName, String price) {
        this.carName = carName;
        this.price = price;
    }

    public String getCarName() {
        return carName;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{" +
                "\"carName\":" + '\"' + carName + '\"' + "," +
                "\"price\":\"" + price + '\"' +
                '}';
    }
}
