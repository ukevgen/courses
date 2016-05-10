package main.java.Customer;

/**
 * Created by Администратор on 10.05.2016.
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

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setYearOut(String yearOut) {
        this.yearOut = yearOut;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
