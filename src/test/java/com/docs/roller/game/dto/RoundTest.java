package com.docs.roller.game.dto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    @Test
    void playRound() {
        int numberOfDice = 5;
        int numberOfFaces = 6;
        DiceGameRound round = new DiceGameRound(numberOfDice, numberOfFaces);
        round.playRound();
        //Assert that number of results are equal to number of dices
        List<Integer> results = round.getResults();
        assertEquals(results.size(), numberOfDice);
        results.forEach(result -> {
            // assert that each result is in [0, numberOfFaces] range
            assertTrue(result > 0);
            assertTrue(result <= numberOfFaces);
        });
    }
}