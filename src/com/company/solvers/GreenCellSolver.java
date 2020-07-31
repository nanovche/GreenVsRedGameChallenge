package com.company.solvers;

import com.company.cell.Cell;
import com.company.colour.Colour;
import com.company.solvers.CellSolver;

public class GreenCellSolver extends CellSolver {

    public GreenCellSolver(Cell[][] grid) {
        super(grid);
    }

    @Override
    public Colour checkForSpecificColour() {
        if(getCounterOfGreenCells() == 2 || getCounterOfGreenCells() == 3 || getCounterOfGreenCells() == 6){
            return Colour.GREEN;
        } else {
            return Colour.RED;
        }
    }
}
