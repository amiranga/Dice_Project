package org.ravi;

import org.ravi.constants.GameConstants;
import org.ravi.dto.Game;
import org.ravi.utils.GameUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int numberOfDices = GameConstants.DEFAULT_NUMBER_OF_DICES;
        int numberOfFaces = GameConstants.DEFAULT_NUMBER_OF_FACES_OF_DICE;
        int numberOfRounds = GameConstants.DEFAULT_NUMBER_OF_ROUNDS_PER_GAME;
        String stdIn;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter number of dices:");
            stdIn = br.readLine();
            if(GameUtils.isNumeric(stdIn)) {
                numberOfDices = Integer.parseInt(stdIn);
            }

            System.out.println("Enter number of faces in dice");
            stdIn = br.readLine();
            if(GameUtils.isNumeric(stdIn)) {
                numberOfFaces = Integer.parseInt(stdIn);
            }

            System.out.println("Enter number of rounds");
            stdIn = br.readLine();
            if(GameUtils.isNumeric(stdIn)) {
                numberOfRounds = Integer.parseInt(stdIn);
            }

            Game game = new Game(numberOfRounds, numberOfDices, numberOfFaces);
            game.playGame();
            System.out.println("The Result is: " + numberOfRounds);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}