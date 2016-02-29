package com.rxn1d.courses;

/**
 * Created by Администратор on 24.02.2016.
 */
public class Player implements Balance{
    private static int countPlayers=0;
    private String name;
    private long balance;

    private Player(String name,long balance) {
        this.name = name;
        this.balance=balance;
        countPlayers++;
    }
    public void setBalance(int n){
        this.balance-=n;
    }

    public  long getBalance() {
        return this.balance;
    }
    public static Player setPlayer(String name,long balance){

        return new Player(name,balance);
    }

    public static int getCountPlayers() {
        return countPlayers;
    }
}
