package com.docs.roller.game;

import com.docs.roller.game.dto.DiceGame;
import com.docs.roller.game.enums.GameMode;

public class Main {
    public static void main(String[] args) {
        //AC1
        System.out.println("AC #1");
        DiceGame game1 = new DiceGame();
        game1.setNumberOfDices(10);
        game1.setNumberOfFaces(5);
        game1.setGameMode(GameMode.MULTI_DICE);
        game1.buildGame();
        game1.playGame();
        game1.printGameResult();
        System.out.println("=========================");

        //AC2
        System.out.println("AC #2");
        DiceGame game2 = new DiceGame();
        game2.setNumberOfFaces(5);
        game2.setGameMode(GameMode.SINGLE_DICE);
        game2.buildGame();
        game2.playGame();
        game2.printGameResult();
        System.out.println("=========================");

        //AC3
        System.out.println("AC #3");
        DiceGame game3 = new DiceGame();
        game3.setNumberOfRounds(300);
        game3.setGameMode(GameMode.MULTI_ROUND);
        game3.buildGame();
        game3.playGame();
        game3.printGameResult();
        System.out.println("=========================");
    }
}