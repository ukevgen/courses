package Entity;

/**
 * Created by Администратор on 02.04.2016.
 */
public class Cars {
    private int id,yearOut;
    private String name,manufacturer,vin,description;

    public Cars(int id, int yearOut, String name, String manufacturer, String vin, String description) {
        this.id = id;
        this.yearOut = yearOut;
        this.name = name;
        this.manufacturer = manufacturer;
        this.vin = vin;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getYearOut() {
        return yearOut;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getVin() {
        return vin;
    }

    public String getDescription() {
        return description;
    }
}
