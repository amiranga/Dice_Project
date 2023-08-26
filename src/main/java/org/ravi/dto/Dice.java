package org.ravi.dto;

import java.util.Random;

public class Dice {
    private Integer numberOfFaces;
    private Integer value;

    public Dice() {
    }

    public Dice(Integer numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public Integer getNumberOfFaces() {
        return numberOfFaces;
    }

    public void setNumberOfFaces(Integer numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public int roleDice() {
        setValue((new Random()).nextInt(numberOfFaces) + 1);
        return getValue();
    }
}
