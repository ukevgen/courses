package Domain;

import javax.persistence.*;

/**
 * Created by Администратор on 26.05.2016.
 */
@Entity
@Table(name = "paymants")
public class Payment {
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private long numberOfPayment;

    @Column
    private long balance;

    @ManyToOne
    @JoinColumn(name = "client_payment_id")
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

                '}';
    }
}

