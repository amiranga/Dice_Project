package org.ravi.dto;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Round> rounds = new ArrayList<>();

    public Game() {
    }

    public Game(int numberOfRounds, int numberOfDice, int numberOfFacesPerDice) {
        for (int i = 1; i <= numberOfRounds; i++) {
            rounds.add(new Round(numberOfDice, numberOfFacesPerDice));
        }
    }

    public void playGame() {
        for (Round round : rounds) {
            round.playRound();
            List<Integer> roundResult = round.getResults();
            Integer roundTotal = round.getTotal();
            System.out.println(roundResult);
            System.out.println(roundTotal);
        }
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
}
