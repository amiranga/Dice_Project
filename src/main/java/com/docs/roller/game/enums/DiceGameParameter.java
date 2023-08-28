package com.docs.roller.game.enums;

import com.docs.roller.game.dto.UserResponse;
import com.docs.roller.game.interfaces.GameParameter;
import com.docs.roller.game.utils.GameUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.docs.roller.game.constants.DiceGameConstants.*;

/**
 * ENUM class to define the parameters required from user during dice game
 */
public enum DiceGameParameter implements GameParameter {
    NUMBER_OF_DICES("Enter number of dices", DEFAULT_NUMBER_OF_DICES), NUMBER_OF_FACES("Enter number of faces", DEFAULT_NUMBER_OF_FACES), NUMBER_OF_ROUNDS("Enter number of rounds", DEFAULT_NUMBER_OF_ROUNDS);
    private final String message;
    private final int defaultValue;

    DiceGameParameter(String message, int defaultValue) {
        this.message = message;
        this.defaultValue = defaultValue;
    }

    public String getMessage() {
        return message;
    }

    public int getDefaultValue() {
        return defaultValue;
    }

    private String getFullMessage() {
        return message + " (default is " + defaultValue + ")";
    }

    @Override
    public UserResponse readFromUser() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(getFullMessage());
            String userInput = br.readLine();
            if (GameUtils.isNumeric(userInput)) {
                return new UserResponse(Integer.parseInt(userInput), true);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new UserResponse(defaultValue, false);
    }

}
