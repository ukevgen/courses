package com.rxn1d.courses;

/**
 * Created by Администратор on 24.02.2016.
 */
public class Player implements Balance{
    private String name;
    private long balance;

    public Player(String name,long balance) {
        this.name = name;
        this.balance=balance;
    }
    public void setBalance(int n){
        this.balance-=n;
    }

    public  long getBalance() {
        return this.balance;
    }
}
