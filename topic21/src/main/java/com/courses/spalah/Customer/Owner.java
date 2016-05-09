package main.java.com.courses.spalah.Customer;

/**
 * Created by Администратор on 17.04.2016.
 */
public class Owner {
    private String name;
    private String fio;
    private String phone;

    public Owner(String name, String fio, String phone) {
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

    @Override
    public String toString() {
        return "{" +
                "\"name\":" + '\"' + name + '\"' + "," +
                "\"fio\":\"" + fio + '\"' + "," +
                "\"phone\":\"" + phone + '\"' +
                '}';
    }

}
