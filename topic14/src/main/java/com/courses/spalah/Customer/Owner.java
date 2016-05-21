package com.courses.spalah.Customer;

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

    @Override
    public String toString() {
        return "{" +
                "\"name\":" + '\"' + name + '\"' + "," +
                "\"fio\":\"" + fio + '\"' + "," +
                "\"phone\":\"" + phone + '\"' +
                '}';
    }

}
