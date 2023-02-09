package com.soduko.model;

public class SudokuBoard {

    int size;
    Grid[][] game;

    // size = 9*9
    public SudokuBoard(int size) {

        this.size = size;
        int gridSize = (int) Math.sqrt(size);

        for (int i = 0; i < Math.sqrt(gridSize); i++) {
            for (int j = 0; j < Math.sqrt(gridSize); j++) {
                game[i][j] = new Grid(gridSize);
            }
        }
    }
}
