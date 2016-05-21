package com.rxn1d.courses;

import java.util.*;

/**
 * Created by Администратор on 06.03.2016.
 */
public class Table {
    private LinkedList<Player> playsers = new LinkedList<>();
    private Set<PlayerBets> playersBets = new HashSet<>();
    private Set<Integer> numbers = new HashSet<>();
    private HashMap<String, Integer> statTable = new HashMap<>();
    private int countGame;
    private int casinoBalance = 10_000_000;
    private Bet bet = new Bet();

    public Player getPlayers(String name) {
        int i = 0;
        for (i = 0; i < playsers.size(); i++) {
            if (playsers.get(i).getName().equals(name))
                break;
        }
        return playsers.get(i);
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public Set<PlayerBets> getPlayersBets() {
        return playersBets;
    }

    public Map<String, Integer> getStatTable() {
        return statTable;
    }

    public void setPlaysers(Player playser) {
        if (!isPlayerExist(playser.getName()) && playsers.size() < 5) {
            this.playsers.add(playser);
            System.out.println("New user with name = " + playser.getName() + " and balance = " + playser.getBalance() +
                    "$ is added to table");
        } else
            System.out.println("Sory, this user exist or table is full");
    }

    public void setNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean setPlayersBets(Player player, String betType, int betSum, int number) {

        String name = player.getName();
        int balance = player.getBalance();
        boolean isSet = true;
        if (isPlayerDidBetOrNotEnuthMany(name, betSum, balance))
            isSet = false;
        else
            playersBets.add(new PlayerBets(name, balance, betType, betSum, number));
        return isSet;
    }


    public void setStatTable(Set<Integer> set) {
        for (Integer i : set) {
            statTable.put(i.toString(), 0);
        }
        statTable.put(NumbersProperty.BLACK.toString(), 0);
        statTable.put(NumbersProperty.RED.toString(), 0);
        statTable.put(NumbersProperty.EVEN.toString(), 0);
        statTable.put(NumbersProperty.ODD.toString(), 0);
        statTable.put(NumbersProperty.BIG.toString(), 0);
        statTable.put(NumbersProperty.SMALL.toString(), 0);
    }

    public void setStatTable(Bet bet, int number) {
        statTable.put("" + number, statTable.get("" + number) + 1);
        if (number != 0) {
            statTable.put(bet.isBig(number), statTable.get(bet.isBig(number)) + 1);
            statTable.put(bet.isOdd(number), statTable.get(bet.isOdd(number)) + 1);
            statTable.put(bet.isRed(number), statTable.get(bet.isRed(number)) + 1);
        }
        countGame++;
    }

    public boolean isNumeric(String s) {
        return s.matches("\\d+");
    }

    public int getCountGame() {
        return countGame;
    }

    public boolean isPlayerExist(String name) {
        boolean exist = false;
        for (Player p : playsers) {
            if (p.getName().equals(name))
                exist = true;
        }

        return exist;
    }

    private boolean isPlayerDidBetOrNotEnuthMany(String name, int betSum, int balance) {

        String betType = "";
        for (PlayerBets p : playersBets) {
            if (p.getName().equals(name)) {
                balance = p.getBalance();
                betType = p.getBetType();
            }
        }
        if (betType.equals("") && balance >= betSum)
            return false;
        else return true;
    }

    public void winers(int number) {
        statPlayers = "Players [";
        String result = "  -> Player: ";
        for (PlayerBets p : playersBets) {
            int many = 0;
            if (p.getNumber() == number) {
                p.setBalance(p.getBalance() + p.getBetSum() * 35);
                many = p.getBetSum() * 35;
                casinoBalance -= p.getBetSum() * 35;
            }
            if (bet.isBig(number).equals(p.getBetType())) {
                p.setBalance(p.getBalance() + p.getBetSum());
                many = p.getBetSum();
                casinoBalance -= p.getBetSum();
            }
            if (bet.isOdd(number).equals(p.getBetType())) {
                p.setBalance(p.getBalance() + p.getBetSum());
                many = p.getBetSum();
                casinoBalance -= p.getBetSum();
            }
            if (bet.isRed(number).equals(p.getBetType())) {
                p.setBalance(p.getBalance() + p.getBetSum());
                many = p.getBetSum();
                casinoBalance -= p.getBetSum();
            }
            if (many == 0) {
                p.setBalance(p.getBalance() - p.getBetSum());
                many = -p.getBetSum();
                casinoBalance += p.getBetSum();
            }
            statPlayers += p.getName() + " = " + p.getBalance() + "$, ";
            result += p.getName() + " " + many + "$";
            System.out.println(result);
        }
        playersBets.clear();
    }

    private String statPlayers;

    void statPlayersAndCasino() {
        System.out.println("-> Balance = " + casinoBalance);
        System.out.println(statPlayers+ "]");
    }

}
