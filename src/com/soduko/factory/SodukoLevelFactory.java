package com.soduko.factory;

import com.soduko.model.Grid;
import com.soduko.strategy.EasyLevel;
import com.soduko.strategy.Level;

public class SodukoLevelFactory {

    Level easyLevel;
    Grid grid;

    public SodukoLevelFactory(Grid grid){

        this.grid = grid;
        easyLevel = new EasyLevel();
        //Level medLevel = new MediumLevel();
        //Level hardLevel = new HardLevel();

    }


}
