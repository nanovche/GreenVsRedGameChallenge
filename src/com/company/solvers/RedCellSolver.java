package com.company.solvers;

import com.company.cell.Cell;
import com.company.colour.Colour;
import com.company.solvers.CellSolver;

public class RedCellSolver extends CellSolver {
    
    public RedCellSolver(Cell[][] grid) {
        super(grid);
    }

    @Override
    public Colour checkForSpecificColour() {
        if(getCounterOfGreenCells() == 3 || getCounterOfGreenCells() == 6){
            return Colour.GREEN;
        } else {
            return Colour.RED;
        }
    }
}
