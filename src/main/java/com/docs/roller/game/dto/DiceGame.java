package com.docs.roller.game.dto;

import com.docs.roller.game.enums.DiceGameParameter;
import com.docs.roller.game.interfaces.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Game Model which has number of rounds
 */
public class DiceGame implements Game {
    private final List<List<Integer>> finalResult = new ArrayList<>();
    private final List<DiceGameRound> rounds = new ArrayList<>();
    private UserResponse numberOfDices;
    private UserResponse numberOfFaces;
    private UserResponse numberOfRounds;

    public DiceGame() {
    }

    public DiceGame(int numberOfDices, int numberOfFaces, int numberOfRounds) {
        for (int i = 1; i <= numberOfRounds; i++) {
            rounds.add(new DiceGameRound(numberOfDices, numberOfFaces));
        }
    }

    /**
     * Read numberOfDices, numberOfFaces & numberOfRounds parameters from system input
     */
    @Override
    public void readGameParameters() {
        numberOfDices = DiceGameParameter.NUMBER_OF_DICES.readFromUser();
        numberOfFaces = DiceGameParameter.NUMBER_OF_FACES.readFromUser();
        numberOfRounds = DiceGameParameter.NUMBER_OF_ROUNDS.readFromUser();
        if (validateGameParameters()) {
            for (int i = 1; i <= numberOfRounds.getValue(); i++) {
                rounds.add(new DiceGameRound(numberOfDices.getValue(), numberOfFaces.getValue()));
            }
        }
    }

    /**
     * This method will call playRound() method of all rounds in game
     */
    @Override
    public void playGame() {
        for (DiceGameRound round : rounds) {
            round.playRound();
            finalResult.add(round.getResults());
        }
    }


    /**
     * Print the game output based on user input
     */
    @Override
    public void printGameResult() {
        if (numberOfRounds.isGiven()) {
            // If user enters number of rounds, final result will be frequency of each face
            printFrequencyMap();
        } else if (numberOfDices.isGiven()) {
            // If user enters number of dices, final result will be each round result and total
            printEachRoundResult();
            printEachRoundTotal();
        } else {
            // If user enters number of dices, final result will be total
            printEachRoundResult();
        }
    }

    /**
     * Print each round each dice value comma seperated
     */
    private void printEachRoundResult() {
        System.out.println("Dice Values:");
        finalResult.forEach(System.out::println);
    }

    /**
     * Print each round total
     */
    private void printEachRoundTotal() {
        System.out.println("Total:");
        finalResult.forEach(roundResult -> System.out.println(roundResult.stream().mapToInt(r -> r).sum()));
    }


    /**
     * print frequency of each face thought the game
     */
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

    private boolean validateGameParameters() {
        boolean result = numberOfDices.getValue() > 0 && numberOfFaces.getValue() > 0 && numberOfRounds.getValue() > 0;
        if (!result) {
            System.out.println("Number of faces, rounds, and dices should be greater than 0");
        }
        return result;
    }
}
