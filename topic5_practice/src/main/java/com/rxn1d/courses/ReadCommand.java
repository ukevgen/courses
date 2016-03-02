package com.rxn1d.courses;

/**
 * Created by Администратор on 02.03.2016.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Random;

/**
 *
 * @author User
 */
public  final class ReadCommand extends InitRoulette   {
    private StatRoulette stat = new StatRoulette();
    private static ArrayList<Player> players=new ArrayList<>();

    public boolean readCommand() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String comandLine = reader.readLine();
        String[] comands = comandLine.split(" ");
        boolean accept=true;
        for (String s: comands){
            if (s.equals("EXIT"))
                accept=!exit();
            else if (s.equals("NEW_USER"))
                accept=newUser(comands);
            else if (s.equals("PLAY_GAME"))
                accept=playGame();
            else if (s.equals("STATS"))
                accept=stats();
            else if (s.equals("BET"))
                accept=doBet(comands);
            else if (accept && !comands[0].equals("NEW_USER") && !comands[0].equals("BET"))
                System.out.println("Wrong command!");
        }
        return accept;
    }


    boolean doBet(String [] s){
        int k=0;
        for(Player pl:players){
            if (pl.getName().equals(s[1]) && pl.getBetSum()==0){
                setBet(pl,s);
                k++;
            }
        }
        if(k==0)
            System.out.println("BET NOTE ACCEPTED 0"+k);

        return true;
    }



    boolean newUser(String [] s){

        if (Player.getCountPlayers()<5 && checkPlayers(s[1])){

            players.add(new Player(s[1], Long.parseLong(s[2]),"",0));
            System.out.println("-> New user with name = " + s[1] + " and balance = " + s[2] + "$ is added to table" + Player.getCountPlayers());

        }
        else
            System.out.println("The table is full or this player was add");
        return true;
    }
    boolean playGame(){
        // StatRoulette stat = new StatRoulette();

        long random = new Random().nextInt(37);

        if (random == 0)
            System.out.println("-> Winning number=" + random + "-GREEN");
        else if (isRed(""+random))
            System.out.println("-> Winning number=" + random + "-RED");
        else
            System.out.println("-> Winning number=" + random + "-BLACK");
        stat.setStatNumbers("" + random);
        ///обнлить ставки игроков
        win(random);
        return true;
    }
    boolean stats(){
        System.out.print(stat.toString());
        String player="Players [";
        for( Player pl: players){
            player+=pl.getName()+" = "+pl.getBalance()+"$, ";
        }
        System.out.println(player+"]");

        return true;
    }
    boolean  exit(){return true;}
    void  setBet(Player pl, String []s){
        if(s.length==5)
        {
            pl.setBet(s[4]);
            pl.setBetSum(Integer.parseInt(s[2]));
            System.out.println("BET ACCEPTED");
        }
        else
        {
            pl.setBet(s[3]);
            pl.setBetSum(Integer.parseInt(s[2]));
            System.out.println("BET ACCEPTED");
        }


    }
    boolean  checkPlayers(String name){
        boolean check=true;
        for( Player pl: players){
            if (pl.getName().equals(name))
                check = false;
        }
        return check;
    }
    void win(long number){

        for( Player pl: players){
            String bet=pl.getBet();

            String winers="Player: ";

            if (bet!=""){
                if(bet.equals(""+number)){
                    pl.setBalance((pl.getBalance()+pl.getBetSum()*35));
                    setCasinoBalance(getCasinoBalance()-pl.getBetSum());
                    System.out.println(winers +pl.getName()+" + "+pl.getBetSum()*35+ "$!!");
                }
                else if (isRed(""+number) && bet.equals("RED")){
                    pl.setBalance((pl.getBalance()+pl.getBetSum()));
                    setCasinoBalance(getCasinoBalance()-pl.getBetSum());
                    System.out.println(winers +pl.getName()+" + "+pl.getBetSum()+ "$!!");
                }
                else if(isEven(""+number) && bet.equals("EVEN")) {
                    pl.setBalance((pl.getBalance()+pl.getBetSum()));
                    setCasinoBalance(getCasinoBalance()-pl.getBetSum());
                    System.out.println(winers +pl.getName()+" + "+pl.getBetSum()+ "$!!");
                }
                else if (isBig(""+number)&& bet.equals("BIG")){
                    pl.setBalance((pl.getBalance()+pl.getBetSum()));
                    setCasinoBalance(getCasinoBalance()-pl.getBetSum());
                    System.out.println(winers +pl.getName()+" + "+pl.getBetSum()+ "$!!");
                }
                else{
                    pl.setBalance((pl.getBalance()-pl.getBetSum()));
                    setCasinoBalance(getCasinoBalance()+pl.getBetSum());
                    System.out.println(winers +pl.getName()+" - "+pl.getBetSum()+ "$"+ "=(");
                }

            }
        }
        for( Player pl: players){
            pl.setBetSum(0);
            pl.setBet("");}

    }

}

