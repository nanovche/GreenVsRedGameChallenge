package com.company.solvers;

import com.company.cell.Cell;
import com.company.colour.Colour;

public abstract class CellSolver {

    private int counterOfGreenCells; // keeps track of the green cell number in order to make decision about comparing later

    private Cell[][] grid;

    public CellSolver(Cell[][] grid){
        this.grid = grid;
    }

    public Colour solveForTargetCell(final Cell cell) {

        int targetCellXCoordinate = cell.getXCoordinate();
        int targetCellYCoordinate = cell.getYCoordinate();

        int startCoordinateX  = Math.max( targetCellXCoordinate - 1, 0);
        int endCoordinateX = Math.min( targetCellXCoordinate + 1, grid.length - 1 );
        int startCoordinateY  = Math.max( targetCellYCoordinate - 1, 0);
        int endCoordinateY = Math.min( targetCellYCoordinate + 1, grid.length - 1 );


        //algorithm to check every neighbouring cell of target cell
        for (int row = startCoordinateX; row <= endCoordinateX; row++) {
            for (int col = startCoordinateY; col <= endCoordinateY; col++) {

                if(row == cell.getXCoordinate() && col == cell.getYCoordinate()){
                    continue; //cell we are determining the next color for this cell; do not compare with itself
                }

                if (grid[row][col].getColour() == (Colour.GREEN)) {
                    counterOfGreenCells++;
                }
            }
        }
        return checkForSpecificColour();
    }

    protected abstract Colour checkForSpecificColour();

    protected int getCounterOfGreenCells(){
            return counterOfGreenCells;
    }

}
