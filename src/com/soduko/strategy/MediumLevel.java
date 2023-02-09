package com.soduko.strategy;

import com.soduko.enums.SodukoLevel;
import com.soduko.model.SudokuBoard;

public class MediumLevel implements Level {

    public SodukoLevel level = SodukoLevel.MEDIUM;
    public int prefilledPositions = 6 * 6;

    public SudokuBoard generateGame(SudokuBoard sudokuBoard) {

        return null;
    }
}
