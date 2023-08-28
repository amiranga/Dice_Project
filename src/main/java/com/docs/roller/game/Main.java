package com.docs.roller.game;

import com.docs.roller.game.dto.DiceGame;
import com.docs.roller.game.interfaces.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new DiceGame();
        game.readGameParameters();
        game.playGame();
        game.printGameResult();
    }
}