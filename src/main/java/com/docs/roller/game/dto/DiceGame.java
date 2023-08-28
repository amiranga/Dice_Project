package com.docs.roller.game.dto;

import com.docs.roller.game.constants.DiceGameDefaults;
import com.docs.roller.game.enums.GameMode;
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

    private int numberOfDices = DiceGameDefaults.NUMBER_OF_DICES;
    private int numberOfFaces = DiceGameDefaults.NUMBER_OF_FACES;
    private int numberOfRounds = DiceGameDefaults.NUMBER_OF_ROUNDS;
    private GameMode gameMode;

    public DiceGame() {
    }

    @Override
    public void buildGame() {
        for (int i = 1; i <= numberOfRounds; i++) {
            rounds.add(new DiceGameRound(numberOfDices, numberOfFaces));
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
        switch (gameMode) {
            case MULTI_ROUND:
                printFrequencyMap();
                break;
            case MULTI_DICE:
                printEachRoundResult();
                printEachRoundTotal();
                break;
            case SINGLE_DICE:
                printEachRoundTotal();
                break;
            default:
                printFrequencyMap();
                printEachRoundResult();
                printEachRoundTotal();
        }
    }

    /**
     * Print each round each dice value comma seperated
     */
    private void printEachRoundResult() {
        for (int i = 0; i < finalResult.size(); i++) {
            int roundNumber = i + 1;
            List<Integer> roundResult = finalResult.get(i);
            System.out.println("Round " + roundNumber + " result = " + roundResult);
        }
    }

    /**
     * Print each round total
     */
    private void printEachRoundTotal() {
        for (int i = 0; i < finalResult.size(); i++) {
            int roundNumber = i + 1;
            List<Integer> roundResult = finalResult.get(i);
            System.out.println("Round " + roundNumber + " total = " + roundResult.stream().mapToInt(r -> r).sum());
        }
    }


    /**
     * print frequency of each face thought the game
     */
    private void printFrequencyMap() {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        finalResult.forEach(roundResult -> roundResult.forEach(diceValue -> {
            int currentFrequency = 0;
            if (frequencyMap.containsKey(diceValue)) {
                currentFrequency = frequencyMap.get(diceValue);
            }
            frequencyMap.put(diceValue, currentFrequency + 1);
        }));
        frequencyMap.forEach((key, value) -> System.out.println("Frequency of " + key + " = " + value));
    }

    public List<List<Integer>> getFinalResult() {
        return finalResult;
    }

    public int getNumberOfDices() {
        return numberOfDices;
    }

    public void setNumberOfDices(int numberOfDices) {
        this.numberOfDices = numberOfDices;
    }

    public int getNumberOfFaces() {
        return numberOfFaces;
    }

    public void setNumberOfFaces(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }
}
