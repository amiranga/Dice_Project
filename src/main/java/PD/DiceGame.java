package PD;

import java.util.ArrayList;
import java.util.List;

public class DiceGame implements IGame {
    private int numberOfDices;
    private int numberOfFaces;
    private boolean hasInvalidInputs;
    private List<Dice> dices = new ArrayList<>();
    private List<Integer> results;

    /**
     * Use this to initialize the game with parameters
     */
    public DiceGame(String numberOfDicesStr, String numberOfFacesStr) {
        try {

            if (DiceUtil.isNotEmpty(numberOfDicesStr) && DiceUtil.isPositiveNumber(numberOfDicesStr)) {
                numberOfDices = Integer.parseInt(numberOfDicesStr);
            } else {
                hasInvalidInputs = true;
            }
            if (DiceUtil.isNotEmpty(numberOfFacesStr) && DiceUtil.isPositiveNumber(numberOfFacesStr)) {
                numberOfFaces = Integer.parseInt(numberOfFacesStr);
            } else {
                hasInvalidInputs = true;
            }
            if (!hasInvalidInputs) {
                registerDices();
            }
        } catch (Exception e) {
            System.out.println("Unexpected error");
            hasInvalidInputs = true;
        }
    }

    @Override
    public void play() {
        if (hasInvalidInputs) {
            // Skip the game if inputs are invalid
            return;
        }
        dices.forEach(Dice::getFaceValue);
    }

    @Override
    public String GetGameResult() {
        if (hasInvalidInputs) {
            // Return error message if inputs are invalid
            return "Error: Input values should be greater than 0\nTotal => 0";
        }
        StringBuilder res = new StringBuilder("Results For Each Dice");
        for (int i = 0; i < dices.size(); i++) {
            res.append("\n").append(i + 1).append(" => ").append(dices.get(i).getResult());
        }
        res.append("\n\n").append("Total => ").append(dices.stream().map(Dice::getResult).mapToInt(r -> r).sum());
        return res.toString();
    }

    private void registerDices() {
        for (int i = 1; i <= numberOfDices; i++) {
            dices.add(new Dice(numberOfFaces));
        }
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
