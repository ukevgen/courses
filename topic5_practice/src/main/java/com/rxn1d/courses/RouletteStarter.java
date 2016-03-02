package com.rxn1d.courses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

public class RouletteStarter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {


        System.out.println("->Game Started");
        InitRoulette roulette = new InitRoulette();
        roulette.SetRoulette();
        ReadCommand readCommands=new ReadCommand();
        System.out.println("->Genarated Roulette:" + roulette.toString());


        while (readCommands.readCommand()) {

        }



    }
}
