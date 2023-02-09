package com.soduko.strategy;

import com.soduko.enums.SodukoLevel;
import com.soduko.model.SudokuBoard;

public class HardLevel implements Level{

    public SodukoLevel level = SodukoLevel.HARD;
    public int prefilledPositions = 5 * 5;

    public SudokuBoard generateGame(SudokuBoard sudokuBoard){

        return null;
    }
}
