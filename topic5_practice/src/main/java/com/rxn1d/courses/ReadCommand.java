package com.rxn1d.courses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Random;

/**
 * Created by Администратор on 06.03.2016.
 */
public class ReadCommand {
    private Bet bet;
    private Table table;


    ReadCommand(Bet bet, Table table) {
        this.bet = bet;
        this.table = table;
    }

    public boolean readCommand() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String comandLine = reader.readLine();
        String[] commands = comandLine.split(" ");
        boolean accept = true;
        for (String s : commands) {
            if (s.equals("EXIT"))
                accept = !exitGame();
            else if (s.equals("NEW_USER"))
                accept = newUser(commands);
            else if (s.equals("PLAY_GAME"))
                accept = playGame();
            else if (s.equals("STATS"))
                accept = statTable();
            else if (s.equals("BET"))
                accept = setBet(commands);
        }
        if (!isExitPlayNewStatBet(commands))
            System.out.println("Wrong command");

        return accept;
    }

    public boolean exitGame() {
        return true;
    }

    public boolean playGame() {
        int number = new Random().nextInt(37);
        System.out.println(number + "-" + bet.isRed(number));
        table.setStatTable(bet, number);
        table.winers(number);
        return true;
    }

    public boolean statTable() {
        Map<String, Integer> map = table.getStatTable();
        String stat = "-> Total bets by type [";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (!table.isNumeric(entry.getKey()))
                stat += entry.getKey() + " = " + entry.getValue() + ", ";
        }
        System.out.println(stat + "STRAIGHT_UP = " + table.getCountGame() + "]");
        table.statPlayersAndCasino();
        return true;
    }

    public boolean newUser(String[] comands) {
        String name = comands[1];
        int balance = Integer.parseInt(comands[2]);
        table.setPlaysers(new Player(name, balance));
        return true;
    }

    public boolean setBet(String[] commands) {
        Player player;
        String name = commands[1];
        boolean playerExist = table.isPlayerExist(name);
        boolean accept = false;
        for (int i = 0; i < commands.length; i++) {
            if (bet.isStaightUp(commands[i]) && playerExist) {
                player = table.getPlayers(commands[1]);
                accept = table.setPlayersBets(player, "STRAIGHT_UP", Integer.parseInt(commands[2]),
                        Integer.parseInt(commands[4]));
            }
            if (bet.isBigOddRedSmallEvenBlack(commands[i]) && playerExist) {
                player = table.getPlayers(commands[1]);
                accept = table.setPlayersBets(player, commands[3], Integer.parseInt(commands[2]), 0);
            }
        }
        if (accept) System.out.println("-> BET ACCEPTED");
        else System.out.println("BET NOTE ACCEPTED");
        return true;
    }

    private boolean isExitPlayNewStatBet(String[] comands) {
        boolean confirm=false;
        for (String s : comands) {
            if (s.equals("EXIT") || s.equals("PLAY_GAME") || s.equals("NEW_USER") ||
                    s.equals("STATS") || s.equals("BET"))
                confirm=true;
        }
        return confirm;
    }
}

