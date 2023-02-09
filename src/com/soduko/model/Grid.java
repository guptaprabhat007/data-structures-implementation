package com.soduko.model;

public class Grid {

    private final int gridSize; //The variable that holds the size of the grid.
    private Cell[][] grid;

    // gridSize = 3*3
    public Grid(int gridSize) {

        this.gridSize = gridSize; //We assigned the variable blocks as a parameter to the sub-block size..
        for(int i=0; i< Math.sqrt(gridSize); i++){
            for(int j=0; j < Math.sqrt(gridSize); j++){
                grid[i][j] = new Cell();
            }
        }
    }
}
