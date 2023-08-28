package com.docs.roller.game.dto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void playGame() {
        int numberOfRounds = 1000;
        DiceGame game = new DiceGame();
        game.setNumberOfRounds(numberOfRounds);
        game.setNumberOfDices(10);
        game.setNumberOfFaces(5);

        game.buildGame();
        game.playGame();
        List<List<Integer>> finalResult = game.getFinalResult();
        assertEquals(numberOfRounds, finalResult.size());
    }
}