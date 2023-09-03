package com.cs.game.dice.roller.app.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.cs.game.dice.roller.app.constants.AppConstant;
import com.cs.game.dice.roller.app.util.DiceUtil;

public class DiceGame implements IGame {

    private final List<List<Integer>> finalResult = new ArrayList<>();
    private final List<Round> rounds = new ArrayList<>();
    private int numberOfDices = AppConstant.DEFAULT_NUMBER_OF_DICES;
    private int numberOfFaces = AppConstant.DEFAULT_NUMBER_OF_FACES_OF_DICE;
    private int numberOfRounds = AppConstant.DEFAULT_NUMBER_OF_ROUNDS_PER_GAME;
    private boolean userEnteredNumberOfDices;
    private boolean userEnteredNumberOfRounds;
    private boolean hasInvalidInputs;

    /**
     * Use this when game parameters were taken from stdin by calling readInputParameter method
     */
    public DiceGame() {
    }

    /**
     * Use this to initialize the game with parameters
     */
    public DiceGame(String numberOfDicesStr, String numberOfFacesStr, String numberOfRoundsStr) {
        if (DiceUtil.isNotEmpty(numberOfRoundsStr)) {
            if (DiceUtil.isPositiveNumber(numberOfRoundsStr)) {
                numberOfRounds = Integer.parseInt(numberOfRoundsStr);
                userEnteredNumberOfRounds = true;
            } else {
                hasInvalidInputs = true;
            }
        }

        if (DiceUtil.isNotEmpty(numberOfDicesStr)) {
            if (DiceUtil.isPositiveNumber(numberOfDicesStr)) {
                numberOfDices = Integer.parseInt(numberOfDicesStr);
                userEnteredNumberOfDices = true;
            } else {
                hasInvalidInputs = true;
            }
        }
        if (DiceUtil.isNotEmpty(numberOfFacesStr)) {
            if (DiceUtil.isPositiveNumber(numberOfFacesStr)) {
                numberOfFaces = Integer.parseInt(numberOfFacesStr);
            } else {
                hasInvalidInputs = true;
            }
        }
        if (!hasInvalidInputs) {
            registerRounds();
        }
    }

    @Override
    public void readInputParameter() {
        String stdIn;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter number of rounds: (Default " + numberOfRounds + ")");
            stdIn = br.readLine();
            if (DiceUtil.isPositiveNumber(stdIn)) {
                numberOfRounds = Integer.parseInt(stdIn);
                userEnteredNumberOfRounds = true;
            }

            System.out.println("Enter number of dices: (Default " + numberOfDices + ")");
            stdIn = br.readLine();
            if (DiceUtil.isPositiveNumber(stdIn)) {
                numberOfDices = Integer.parseInt(stdIn);
                userEnteredNumberOfDices = true;
            }

            System.out.println("Enter number of faces in dice: (Default " + numberOfFaces + ")");
            stdIn = br.readLine();
            if (DiceUtil.isPositiveNumber(stdIn)) {
                numberOfFaces = Integer.parseInt(stdIn);
            }

            registerRounds();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    @Override
    public void play() {
        if (hasInvalidInputs) {
            return;
        }
        for (Round round : rounds) {
            round.playRound();
            finalResult.add(round.getResults());
        }
    }

    @Override
    public String GetGameResult() {
        if (hasInvalidInputs) {
            return "Invalid Input values\nTotal: 0";
        }
        GameWriter gameWriter = new GameWriter();
        if (userEnteredNumberOfRounds) {
            return gameWriter.printDiceFaceFrequency(finalResult);
        } else if (userEnteredNumberOfDices) {
            return gameWriter.printEachRoundResult(finalResult) + gameWriter.printEachRoundTotal(finalResult);
        } else {
            return gameWriter.printEachRoundResult(finalResult);
        }
    }

    private void registerRounds() {
        for (int i = 1; i <= numberOfRounds; i++) {
            rounds.add(new Round(numberOfDices, numberOfFaces));
        }
    }
}
