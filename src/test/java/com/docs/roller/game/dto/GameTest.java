package com.docs.roller.game.dto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void playGame() {
        int numberOfDices = 10;
        int numberOfFaces = 5;
        int numberOfRounds = 1000;
        DiceGame game = new DiceGame(numberOfDices, numberOfFaces, numberOfRounds);
        game.playGame();
        List<List<Integer>> finalResult = game.getFinalResult();
        assertEquals(numberOfRounds, finalResult.size());
    }
}