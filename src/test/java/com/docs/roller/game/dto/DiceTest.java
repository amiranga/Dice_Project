package com.docs.roller.game.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    void roleDice() {
        int numberOfFaces = 10;
        Dice dice = new Dice(numberOfFaces);
        int result = dice.roleDice();
        // assert that result is in [0, numberOfFaces] range
        assertTrue(result > 0);
        assertTrue(result <= numberOfFaces);
    }
}