/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderlabz;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author euvinmongwe
 */
public class Roulette {

    /**
     * winningN
     */
    private int winningN;

    /**
     *
     * @return
     */
    public int getWinningN() {
        return winningN;
    }

    /**
     *
     * @param winningN
     */
    public void setWinningN(int winningN) {
        this.winningN = winningN;
    }

    /**
     *
     * @param playerNumBet
     * @param playerOddEven
     * @param betAmount
     */
    public void generateBet(Map<String, Integer> playerNumBet, Map<String, String> playerOddEven, ArrayList<Double> betAmount) {

        int winningNumber = getWinningN();
        String outcome = "Loss";
        String beType = "";
        double winnings = 0.0;
        int count = 0;
        for (Map.Entry<String, Integer> entry : playerNumBet.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            int customerNumber = (int) val;
            String playerName = (String) key;

            if (customerNumber == winningNumber) {
                outcome = "Win";
                System.out.println("betAmount.get(count)1 " + betAmount.get(count));
                winnings = (betAmount.get(count) * 36);

            }
            beType = String.valueOf(customerNumber);
            displayWinner(playerName, winningNumber, beType, outcome, winnings);
            ++count;
        }
        count = 0;
        winnings = 0;
        for (Map.Entry<String, String> entry : playerOddEven.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            String playerName = (String) key;
            String oddEven = (String) val;
            if (evenOddWinningNumbers(winningNumber).equalsIgnoreCase(oddEven)) {
                outcome = "Win";
                winnings = (betAmount.get(count) * 2);
            }
            beType = oddEven;
            displayWinner(playerName, winningNumber, beType, outcome, winnings);
            ++count;
        }

    }

    /**
     * This Method will generate a winning number
     * 
     * @return
     */
    @SuppressWarnings("empty-statement")
    public void generateRolette() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        @SuppressWarnings("empty-statement")
        Runnable generateWinningNumber;
        generateWinningNumber = () -> {
            int min = 1;
            int max = 36;

            setWinningN(((int) (Math.random() * (max - min))) + min);;
        };

        executor.scheduleAtFixedRate(generateWinningNumber, 0, 30, TimeUnit.SECONDS);
    }

    /**
     * This method will compare winning number and determine whether its an odd
     * or even number
     *
     * @param winning
     * @return
     */
    private String evenOddWinningNumbers(int winning) {
        if (winning % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    /**
     * This method will generate an output
     *
     * @param player
     * @param winningNumber
     * @param betType
     * @param outcome
     * @param winnings
     */
    private void displayWinner(String player, int winningNumber, String betType, String outcome, double winnings) {
        System.out.println("         ");
        System.out.println("Number:" + winningNumber);
        System.out.println("Player      Bet     Outcome     Winnings");
        System.out.println("---");
        System.out.println(player + "     " + betType.toUpperCase() + "     " + outcome.toUpperCase() + "     " + winnings);
        System.out.println("         ");
    }

}
