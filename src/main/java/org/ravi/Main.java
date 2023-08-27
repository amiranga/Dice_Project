package org.ravi;

import org.ravi.dto.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.readGameParameters();
        game.playGame();
        game.printGameResult();
    }
}