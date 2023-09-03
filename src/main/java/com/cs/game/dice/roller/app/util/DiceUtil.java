package com.cs.game.dice.roller.app.util;

public class DiceUtil {

    public static boolean isPositiveNumber(String str) {
        try {
            int i = Integer.parseInt(str);
            if (i < 0) {
                System.out.println("Negative user input");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Non numeric user input");
            return false;
        }
    }

    public static boolean isNotEmpty(String str) {
        return !(str == null || str.trim().length() == 0);
    }
}
