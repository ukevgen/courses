package Customer;

/**
 * Created by Администратор on 10.05.2016.
 */
public class Owner {
    private int id;
    private String name;
    private String fio;
    private String phone;

    public Owner(int id, String name, String fio, String phone) {
        this.id = id;
        this.name = name;
        this.fio = fio;
        this.phone = phone;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
