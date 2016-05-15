package Customer;

/**
 * Created by Администратор on 10.05.2016.
 */
public class Owner {
    private int ID;
    private String name;
    private String fio;
    private String phone;

    public Owner() {
    }

    public Owner(int ID, String name, String fio, String phone) {
        this.ID = ID;
        this.name = name;
        this.fio = fio;
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
