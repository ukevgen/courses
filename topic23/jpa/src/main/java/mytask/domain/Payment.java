/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mytask.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author User
 */

@Entity
@Table(name = "paymants")
public class Payment {
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private long numberOfPayment;

    @Column
    private long balance;

    @ManyToOne
    @JoinColumn(name = "client_payment_id", nullable = false)
    private Client client;

    public Payment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumberOfPayment() {
        return numberOfPayment;
    }

    public void setNumberOfPayment(long numberOfPayment) {
        this.numberOfPayment = numberOfPayment;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", numberOfPayment=" + numberOfPayment +
                ", balance=" + balance +
                ", client=" + client +
                '}';
    }
}
