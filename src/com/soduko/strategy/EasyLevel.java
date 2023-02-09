package com.soduko.strategy;

import com.soduko.constant.ConfigConstant;
import com.soduko.enums.SodukoLevel;
import com.soduko.model.SudokuBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EasyLevel implements Level {

    public SodukoLevel level = SodukoLevel.EASY;
    public int prefilledPositions = 7 * 7;

    public SudokuBoard generateGame(SudokuBoard sudokuBoard) {

        List<Integer> positions = new ArrayList<>();
        int totalPositions = ConfigConstant.SIZE * ConfigConstant.SIZE;
        for (int i = 0; i < totalPositions; i++)
            positions.add(i);

        Collections.shuffle(positions);
        return generateGame(positions, sudokuBoard);
    }

    private SudokuBoard generateGame(List<Integer> positions, SudokuBoard sudokuBoard) {

        int count = 0;
        while (positions.size() > 0 && count < prefilledPositions) {

            int position = positions.remove(0);
            int x = position / 9;
            int y = position % 9;

            //put a number at each cell & check
        }

        return sudokuBoard;
    }
}
