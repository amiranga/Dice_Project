package org.ravi;

import org.ravi.dto.Game;
import org.ravi.utils.GameUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.ravi.constants.GameConstants.*;

public class Main {
    public static void main(String[] args) {
        int numberOfDices = DEFAULT_NUMBER_OF_DICES;
        int numberOfFaces = DEFAULT_NUMBER_OF_FACES_OF_DICE;
        int numberOfRounds = DEFAULT_NUMBER_OF_ROUNDS_PER_GAME;
        String stdIn;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter number of dices: (Default " + DEFAULT_NUMBER_OF_DICES + ")");
            stdIn = br.readLine();
            if (GameUtils.isNumeric(stdIn)) {
                numberOfDices = Integer.parseInt(stdIn);
            }

            System.out.println("Enter number of faces in dice: (Default " + DEFAULT_NUMBER_OF_FACES_OF_DICE + ")");
            stdIn = br.readLine();
            if (GameUtils.isNumeric(stdIn)) {
                numberOfFaces = Integer.parseInt(stdIn);
            }

            System.out.println("Enter number of rounds: (Default " + DEFAULT_NUMBER_OF_ROUNDS_PER_GAME + ")");
            stdIn = br.readLine();
            if (GameUtils.isNumeric(stdIn)) {
                numberOfRounds = Integer.parseInt(stdIn);
            }

            Game game = new Game(numberOfRounds, numberOfDices, numberOfFaces);
            game.playGame();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}