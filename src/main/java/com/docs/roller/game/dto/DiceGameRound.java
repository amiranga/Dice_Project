package com.docs.roller.game.dto;

import com.docs.roller.game.interfaces.GameRound;

import java.util.ArrayList;
import java.util.List;

/**
 * Model that represent one round of game. Has number of dices
 */
public class DiceGameRound implements GameRound {
    private List<Dice> dices = new ArrayList<>();
    private List<Integer> results;

    public DiceGameRound(int numberOfDice, int numberOfFacesPerDice) {
        for (int i = 1; i <= numberOfDice; i++) {
            dices.add(new Dice(numberOfFacesPerDice));
        }
    }

    /**
     * This will call role dice method of each dice in the round and save the results in results list
     */
    @Override
    public void playRound() {
        setResults(new ArrayList<>());
        dices.forEach(dice -> {
            int value = dice.roleDice();
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
