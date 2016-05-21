package com.rxn1d.courses;

/**
 * Created by Администратор on 06.03.2016.
 */
public class Player {
    private String name;
    private int balance;

    Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

class PlayerBets extends Player {
    private String betType;
    private int betSum;
    private int number;

    public PlayerBets(String name, int balance, String betType, int betSum, int number) {
        super(name, balance);
        this.betType = betType;
        this.betSum = betSum;
        this.number = number;
    }

    public int getBetSum() {
        return betSum;
    }

    public String getName() {
        return super.getName();
    }


    public void setNumber(int number) {
        this.number = number;
    }

    public String getBetType() {
        return betType;
    }

    public int getNumber() {
        return number;
    }

    public void setBalance(int balance) {
        super.setBalance(balance);
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }
}
