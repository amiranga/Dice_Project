package com.docs.roller.game.dto;

/**
 * Input from the user
 */
public class UserResponse {
    //Value user entered
    private int value;

    //Is user entered value
    private boolean given;

    public UserResponse(int value, boolean given) {
        this.value = value;
        this.given = given;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isGiven() {
        return given;
    }

    public void setGiven(boolean given) {
        this.given = given;
    }
}
