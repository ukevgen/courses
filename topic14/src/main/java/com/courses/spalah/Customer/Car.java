package com.courses.spalah.Customer;

/**
 * Created by Администратор on 17.04.2016.
 */
public class Car {
    private String name;
    private String manufacturer;
    private String yearOut;
    private String vin;
    private String description;

    public Car(String name, String manufacturer, String yearOut, String vin, String description) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.yearOut = yearOut;
        this.vin = vin;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getYearOut() {
        return yearOut;
    }

    public String getVin() {
        return vin;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\":" + '\"' + name + '\"' + "," +
                "\"manufacturer\":\"" + manufacturer + '\"' + "," +
                "\"yearOut\":\"" + yearOut + '\"' + "," +
                "\"vin\":\"" + vin + '\"' + "," +
                "\"description\":\"" + description + '\"' +
                '}';
    }
}
