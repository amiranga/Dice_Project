package com.cs.game.dice.roller.app.model;

import java.util.HashMap;
import java.util.List;

public class GameWriter implements IWriter {

    public String printEachRoundResult(List<List<Integer>> finalResult) {
        StringBuffer output = new StringBuffer();
        output.append("Dice Values:");
        output.append(NEW_LINE);
        finalResult.forEach(x -> output.append(x).append(NEW_LINE));
        return output.toString();
    }

    public String printEachRoundTotal(List<List<Integer>> finalResult) {
        StringBuffer output = new StringBuffer();
        output.append("Total:");
        output.append(NEW_LINE);
        finalResult.forEach(roundResult -> output.append(roundResult.stream().mapToInt(r -> r).sum()).append(NEW_LINE));
        return output.toString();
    }

    public String printDiceFaceFrequency(List<List<Integer>> finalResult) {
        StringBuffer output = new StringBuffer();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        finalResult.forEach(roundResult -> {
            roundResult.forEach(diceValue -> {
                int currentFrequency = 0;
                if (frequencyMap.containsKey(diceValue)) {
                    currentFrequency = frequencyMap.get(diceValue);
                }
                frequencyMap.put(diceValue, currentFrequency + 1);
            });
        });
        output.append("Dice Values Frequency:");
        output.append(NEW_LINE);
        output.append(frequencyMap);
        return output.toString();
    }

}
