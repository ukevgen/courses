/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mytask.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author User
 */
@Entity
@Table(name = "transactions")
public class Schet {
    @Id
    @Column(name = "trans_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "trn_payment_id", nullable = false)
    private Payment payment;

    @Column
    private Date date;

    public Schet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Schet{" +
                "id=" + id +
                ", payment=" + payment +
                ", balance=" + date +
                '}';
    }
}
