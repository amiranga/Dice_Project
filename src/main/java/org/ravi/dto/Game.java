package org.ravi.dto;

import org.ravi.utils.GameUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.ravi.constants.GameConstants.*;

/**
 * Game Model which has number of rounds
 */
public class Game {
    private final List<List<Integer>> finalResult = new ArrayList<>();
    private final List<Round> rounds = new ArrayList<>();

    private int numberOfDices = DEFAULT_NUMBER_OF_DICES;

    private int numberOfFaces = DEFAULT_NUMBER_OF_FACES_OF_DICE;

    private int numberOfRounds = DEFAULT_NUMBER_OF_ROUNDS_PER_GAME;

    private boolean userEnteredNumberOfDices;

    private boolean userEnteredNumberOfFaces;

    private boolean userEnteredNumberOfRounds;

    public Game() {
    }

    public Game(int numberOfDices, int numberOfFaces, int numberOfRounds) {
        this.numberOfDices = numberOfDices;
        this.numberOfFaces = numberOfFaces;
        this.numberOfRounds = numberOfRounds;
        for (int i = 1; i <= numberOfRounds; i++) {
            rounds.add(new Round(numberOfDices, numberOfFaces));
        }
    }

    /**
     * Read numberOfDices, numberOfFaces & numberOfRounds parameters from system input
     */
    public void readGameParameters() {
        String stdIn;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter number of dices: (Default " + DEFAULT_NUMBER_OF_DICES + ")");
            stdIn = br.readLine();
            if (GameUtils.isNumeric(stdIn)) {
                numberOfDices = Integer.parseInt(stdIn);
                userEnteredNumberOfDices = true;
            }

            System.out.println("Enter number of faces in dice: (Default " + DEFAULT_NUMBER_OF_FACES_OF_DICE + ")");
            stdIn = br.readLine();
            if (GameUtils.isNumeric(stdIn)) {
                numberOfFaces = Integer.parseInt(stdIn);
                userEnteredNumberOfFaces = true;
            }

            System.out.println("Enter number of rounds: (Default " + DEFAULT_NUMBER_OF_ROUNDS_PER_GAME + ")");
            stdIn = br.readLine();
            if (GameUtils.isNumeric(stdIn)) {
                numberOfRounds = Integer.parseInt(stdIn);
                userEnteredNumberOfRounds = true;
            }

            for (int i = 1; i <= numberOfRounds; i++) {
                rounds.add(new Round(numberOfDices, numberOfFaces));
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    /**
     * This method will call playRound() method of all rounds in game
     */
    public void playGame() {
        for (int roundNumber = 0; roundNumber < rounds.size(); roundNumber++) {
            Round round = rounds.get(roundNumber);
            round.playRound();
            finalResult.add(round.getResults());
        }
    }

    /**
     * Print the game output based on user input
     */
    public void printGameResult() {
        if (userEnteredNumberOfRounds) {
            printFrequencyMap();
        } else if (userEnteredNumberOfDices) {
            printEachRoundResult();
            printEachRoundTotal();
        } else {
            printEachRoundResult();
        }
    }

    private void printEachRoundResult() {
        System.out.println("Dice Values:");
        finalResult.forEach(System.out::println);
    }

    private void printEachRoundTotal() {
        System.out.println("Total:");
        finalResult.forEach(roundResult -> System.out.println(roundResult.stream().mapToInt(r -> r).sum()));
    }

    private void printFrequencyMap() {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        finalResult.forEach(roundResult -> {
            roundResult.forEach(diceValue -> {
                int currentFrequency = 0;
                if (frequencyMap.containsKey(diceValue)) {
                    currentFrequency = frequencyMap.get(diceValue);
                }
                frequencyMap.put(diceValue, currentFrequency + 1);
            });
        });
        System.out.println("Dice Values Frequency:");
        System.out.println(frequencyMap);
    }

    public List<List<Integer>> getFinalResult() {
        return finalResult;
    }
}
