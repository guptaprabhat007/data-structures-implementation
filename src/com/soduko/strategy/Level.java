package com.soduko.strategy;

import com.soduko.model.SudokuBoard;

public interface Level {

    SudokuBoard generateGame(SudokuBoard sudokuBoard);
}
