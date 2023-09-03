package com.cs.game.dice.roller.app.model;

import java.util.ArrayList;
import java.util.List;


public class Round {
	private List<Dice> dices = new ArrayList<>();
    private List<Integer> results;

    public Round(int numberOfDice, int numberOfFacesPerDice) {
        for (int i = 1; i <= numberOfDice; i++) {
            dices.add(new Dice(numberOfFacesPerDice));
        }
    }

    /**
     * This will call role dice method of each dice in the round and save the results in results list
     */
    public void playRound() {
        setResults(new ArrayList<>());
        dices.forEach(dice -> {
            int value = dice.getFaceValue();
            getResults().add(value);
        });
    }

    public List<Dice> getDices() {
        return dices;
    }

    public void setDices(List<Dice> dices) {
        this.dices = dices;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }
}
