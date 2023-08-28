package com.docs.roller.game.dto;

import java.util.Random;

/**
 * Dice which has number of faces and result
 */
public class Dice {
    private Integer numberOfFaces;
    private Integer result;

    public Dice(Integer numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    /**
     * @return random integer in range 1 to numberOfFaces
     */
    public int roleDice() {
        setResult((new Random()).nextInt(numberOfFaces) + 1);
        return getResult();
    }

    public Integer getNumberOfFaces() {
        return numberOfFaces;
    }

    public void setNumberOfFaces(Integer numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
