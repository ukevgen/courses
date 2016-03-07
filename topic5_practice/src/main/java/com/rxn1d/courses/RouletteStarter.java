package com.rxn1d.courses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class RouletteStarter {

    static void initializationRouletNumbers(Table table) {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < 37) {
            numbers.add(new Random().nextInt(37));
        }
        table.setNumbers(numbers);
        table.setStatTable(numbers);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("->Game Started");
        Table table = new Table();
        Bet bet = new Bet();
        System.out.println("->Genarated Roulette:");
        getRouletNumbers(table, bet);

        ReadCommand read = new ReadCommand(bet, table);

        while (read.readCommand()) ;

    }

    static void getRouletNumbers(Table table, Bet bet) {
        initializationRouletNumbers(table);
        Set<Integer> numbers = table.getNumbers();
        String s = "[";
        for (Integer i : numbers) {
            s += i + "-" + bet.isRed(i) + ", ";
        }
        System.out.println(s + "]");
    }


}
