/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author euvinmongwe
 * please run file method and insert inputs.
 * 
 */
public class WonderlabzTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Conversion conversion = new Conversion();
        testConversions(conversion);

        Roulette roulette = new Roulette();
        roulette.generateRolette();
        testRoulette(roulette);

    }

    /**
     * This method will test the conversion logic
     *
     * @param conversion
     */
    private static void testConversions(Conversion conversion) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter Miles: ");

        while (!input.hasNextDouble()) {
            String inputString = input.next();
            System.out.printf("\"%s\" is not a valid mile, Please enter a Valid Mile: ", inputString);
        }
        System.out.println("Miles converted to Kilometers equals " + conversion.convertMilesToKilometers(input.nextDouble()));

        System.out.print("Please enter Pounds: ");
        while (!input.hasNextDouble()) {
            String inputString = input.next();
            System.out.printf("\"%s\" is not a valid Pounds, Please enter a Valid Pounds: ", inputString);
        }
        System.out.println("Pounds converted to kilograms equals " + conversion.convertPoundsToKilograms(input.nextDouble()));

        System.out.print("Please enter Kelvins: ");
        while (!input.hasNextDouble()) {
            String inputString = input.next();
            System.out.printf("\"%s\" is not a valid Kelvins, Please enter a Valid Kelvins: ", inputString);
        }
        System.out.println("Kelvin converted to Calculus equals " + conversion.convertKelvinToCalculus(input.nextDouble()));
    }

    /**
     * This method will test the logic of Roulette
     *
     * @param roulette
     */
    private static void testRoulette(Roulette roulette) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> playersName = new ArrayList<>(Arrays.asList("Euvin", "Tebogo"));
        ArrayList<Double> betAmount = new ArrayList<>();
        int num;
        String bet;
        Map<String, Integer> playerNumBet = new HashMap<>();
        Map<String, String> playerOddEven = new HashMap<>();

        for (int i = 0; i < playersName.size(); i++) {
            String moreBets = "";
            do {
                System.out.print("Please Enter bet between 1-36 for " + playersName.get(i) + " : ");
                while (!input.hasNextInt()) {
                    String inputString = input.next();
                    System.out.printf("\"%s\" is not a valid bet, Please enter a number between 1-36: ", inputString);
                }
                num = input.nextInt();
                playerNumBet.put(playersName.get(i), num);

                System.out.print("Please Enter bet Amount: ");
                while (!input.hasNextDouble()) {
                    String inputString = input.next();
                    System.out.printf("\"%s\" is not a valid bet amount, Please enter valid Amount ", inputString);
                }
                betAmount.add(input.nextDouble());
                System.out.print("do you want to place more bets YES/NO?");
                moreBets = input.next();

            } while (!moreBets.equalsIgnoreCase("NO"));
            do {
                System.out.print("Please Enter bet Even or Odd for " + playersName.get(i) + " : ");
                while (!input.hasNext()) {
                    String inputString = input.next();
                    System.out.printf("\"%s\" is not a valid bet, Please enter either Even or odd ", inputString);
                }
                bet = input.next();
                playerOddEven.put(playersName.get(i), bet);

                System.out.print("Please Enter bet Amount: ");
                while (!input.hasNextDouble()) {
                    String inputString = input.next();
                    System.out.printf("\"%s\" is not a valid bet amount, Please enter valid Amount ", inputString);
                }
                betAmount.add(input.nextDouble());
                System.out.print("do you want to place more bets YES/NO?");
                moreBets = input.next();

            } while (!moreBets.equalsIgnoreCase("NO"));
        }

        roulette.generateBet(playerNumBet, playerOddEven, betAmount);

    }
    
}
