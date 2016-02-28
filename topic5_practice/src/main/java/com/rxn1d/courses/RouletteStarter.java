package com.rxn1d.courses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Входная точка в игру
 *
 * @author Ievgen Tararaka
 */
public class RouletteStarter {
    private static long casinoBalance = 200000;
    protected static ArrayList<Player> players = new ArrayList<>();

    public static void main(String[] args) throws IOException {


        System.out.println("->Game Started");
        InitRoulette roulette = new InitRoulette();
        roulette.SetRoulette();
        StatRoulette stat = new StatRoulette();
        System.out.println("->Genarated Roulette:" + roulette.toString());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String comandLine = reader.readLine();
            String[] comands = comandLine.split(" ");
            if (comands[0].equals("EXIT"))
                break;
            switch (comands[0]) {
                case "NEW_USER":
                    setPlayer(comands[1], Long.parseLong(comands[2]));
                    break;
                case "PLAY_GAME":{
                    int random =new Random().nextInt(37);
                    if (random==0)
                        System.out.println("-> Winning number="+random+"-GREEN");
                    else if (random%2!=0)
                        System.out.println("-> Winning number="+random+"-RED");
                    else
                        System.out.println("-> Winning number="+random+"-BLACK");
                    stat.setStatNumbers(""+random);
                }
                    break;
                case "STATS":
                    System.out.println(stat.toString());
                    break;
                case "BET":;
                    break;
                default:
                    break;
            }
        }

    }

    static void setPlayer(String name, long balance) {
        players.add(new Player(name,balance));
        System.out.println("-> New user with name = "+name +" and balance = "+balance+"$ is added to table");
    }

    static void runRoulete() {
    }
}
