package Entity;

/**
 * Created by Администратор on 02.04.2016.
 */
public class Owner {
    private String name,fio,phone;
    private int id;

    public Owner(String name, String fio, String phone, int id) {
        this.name = name;
        this.fio = fio;
        this.phone = phone;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getFio() {
        return fio;
    }

    public String getPhone() {
        return phone;
    }

    public int getId() {
        return id;
    }
}
