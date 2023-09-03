package com.cs.game.dice.roller.app.model;

import java.util.List;

public interface IWriter {

    String NEW_LINE = "\n";

    String printEachRoundResult(List<List<Integer>> finalResult);

    String printEachRoundTotal(List<List<Integer>> finalResult);

    String printDiceFaceFrequency(List<List<Integer>> finalResult);

}
