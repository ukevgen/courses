/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mytask.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
@Entity
@Table(name="clients")

public class Client {
    @Id
    @Column(name = "clients_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
	private String surname;
    @Column
	private long inn;

    @OneToMany(mappedBy = "client")
    private List<Payment> accounts = new ArrayList<Payment>();

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

    public List<Payment> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Payment> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", inn=" + inn +
                ", accounts=" + accounts +
                '}';
    }
}
