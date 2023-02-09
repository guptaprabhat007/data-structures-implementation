package com.soduko.controller;

import com.soduko.enums.SodukoLevel;
import com.soduko.model.Grid;
import com.soduko.service.SodukuService;

public class SodukoController {

    SodukuService sodukuService;

    public SodukoController() {

        sodukuService = new SodukuService();
    }

    public Grid getSoduko(int size, SodukoLevel sodukoLevel) {

        Grid grid = sodukuService.createSoduko(size, sodukoLevel);
        return grid;
    }

    public Boolean validateInput(Grid grid, int r, int c, int value) {

        Boolean aBoolean = sodukuService.validateInput(grid, r, c, value);
        return aBoolean;
    }


}
