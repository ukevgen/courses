package com.rxn1d.courses;

/**
 * Created by Администратор on 24.02.2016.
 */

import java.util.HashMap;

/**
 * @author User
 */
public class Player extends InitRoulette {
    // private static Player players;
    private static int countPlayers = 0;
    private String name;
    private long balance;
    private String bet;
    private int betSum;

    public Player(String name, long balance, String bet, int betSum) {
        this.name = name;
        this.balance = balance;
        this.bet = bet;
        this.betSum = betSum;
        countPlayers++;
    }

    public void setBalance(long n) {
        this.balance = n;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public String getBet() {
        return bet;
    }

    public String getName() {
        return name;
    }

    public void setBetSum(int betSum) {
        this.betSum = betSum;
    }

    public int getBetSum() {
        return betSum;
    }

    public long getBalance() {
        return balance;
    }

    public static int getCountPlayers() {
        return countPlayers;
    }

    public void updateBalance(int number) {

    }

}
