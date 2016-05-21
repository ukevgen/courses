package Customer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 10.05.2016.
 */
public class Car {

    private String name;
    private String manufacturer;
    private int yearOut;
    private String vin;
    private String description;
    private Set owner = new HashSet<>();
    private int ID;

    public Car() {
    }

    public Car(String name, String manufacturer, int yearOut, String vin, String description, int ID) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.yearOut = yearOut;
        this.vin = vin;
        this.description = description;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOut() {
        return yearOut;
    }

    public void setYearOut(int yearOut) {
        this.yearOut = yearOut;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set getOwner() {
        return owner;
    }

    public void setOwner(Set owner) {
        this.owner = owner;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOut=" + yearOut +
                ", vin='" + vin + '\'' +
                ", description='" + description + '\'' +
                ", owner=" + owner.toString() +
                ", ID=" + ID +
                '}';
    }
}
