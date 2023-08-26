package org.ravi.dto;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private List<Dice> dices = new ArrayList<>();
    private List<Integer> results;
    private Integer total;

    public Round() {
    }

    public Round(int numberOfDice, int numberOfFacesPerDice) {
        for (int i = 1; i <= numberOfDice; i++) {
            dices.add(new Dice(numberOfFacesPerDice));
        }
    }

    public void playRound() {
        setResults(new ArrayList<>());
        this.total = 0;
        dices.forEach(dice -> {
            int value = dice.roleDice();
            getResults().add(value);
            total += value;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
