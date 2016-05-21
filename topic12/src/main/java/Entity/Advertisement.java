package Entity;

/**
 * Created by Администратор on 02.04.2016.
 */
public class Advertisement {
    private String carName;
    private int price;
    private int id;

    public Advertisement(String carName, int price, int id) {
        this.carName = carName;
        this.price = price;
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

}
