package com.company.solvers;

import com.company.cell.Cell;
import com.company.solvers.GreenCellSolver;
import com.company.solvers.RedCellSolver;
import com.company.colour.Colour;
import com.company.exceptions.UndefinedColourException;
import com.company.grid.Grid;

public class NextGenerationSolver {

    private static int counterOfMutations;
    private final int lastGeneration;
    Grid currentGenGrid;
    private final Cell targetCell;

    public NextGenerationSolver(Grid grid, int lastGeneration, final Cell targetCell){
        this.currentGenGrid = grid;
        this.lastGeneration = lastGeneration;
        this.targetCell = targetCell;
    }

    public int solve() throws UndefinedColourException {
        int index = 0;

        //every while iteration corresponds to one generation
        while(index++ < lastGeneration){

            Grid nextGenGrid = new Grid(currentGenGrid.getWidth(), currentGenGrid.getHeight());
            currentGenGrid.initializeEmptyGrid(nextGenGrid);

            for (int row = 0; row < currentGenGrid.getWidth(); row++) {
                for (int col = 0; col < currentGenGrid.getHeight(); col++) {

                    final Cell currentCellCurrentGenGrid = currentGenGrid.getGrid()[row][col];
                    final Cell currentCellNextGenGrid = nextGenGrid.getGrid()[row][col];

                    //if colour of the current cell is red we call the red solver which makes comparisons for 3 or 6 green neighbouring cells
                    if(currentCellCurrentGenGrid.getColour() == Colour.RED){
                        Colour colour = new RedCellSolver(currentGenGrid.getGrid()).solveForTargetCell(currentCellCurrentGenGrid);
                        currentCellNextGenGrid.setColour(colour);

                        if(currentCellNextGenGrid.getColour() == Colour.GREEN){
                            if(currentCellCurrentGenGrid.equals(targetCell)){
                                counterOfMutations++;
                            }
                            currentCellNextGenGrid.setValue(1);
                        }
                        // if colour of the current cell is green we call the green solver which makes comparisons for 3 or 6 green neighbouring cells
                    } else {
                        Colour colour = new GreenCellSolver(currentGenGrid.getGrid()).solveForTargetCell(currentCellCurrentGenGrid);
                        currentCellNextGenGrid.setColour(colour);
                        if(currentCellNextGenGrid.getColour() == Colour.RED){
                            currentCellNextGenGrid.setValue(0);
                        } else {
                            currentCellNextGenGrid.setValue(1);
                        }
                    }
                }
            }
            System.out.println();
            nextGenGrid.displayGrid();

            currentGenGrid = nextGenGrid;

        }
        return counterOfMutations;
    }
}
