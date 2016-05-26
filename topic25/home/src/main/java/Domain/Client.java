package Domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 26.05.2016.
 */

@Entity
@Table(name = "clients")

public class Client {
    @Id
    @Column(name = "clients_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private long inn;

    @OneToMany(mappedBy = "client")
    private List<Payment> payments = new ArrayList<Payment>();

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", inn=" + inn +
                ", accounts=" + payments +
                '}';
    }
}

