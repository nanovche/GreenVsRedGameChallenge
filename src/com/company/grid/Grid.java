package com.company.grid;

import com.company.cell.Cell;
import com.company.exceptions.UndefinedColourException;

public class Grid {

    private Cell[][] grid;
    private final int numOfRows;
    private final int numOfCols;

    public Grid(int width, int height){
        numOfCols = width;
        numOfRows = height;
        grid = new Cell[width][height];

    }

    public Cell[][] getGrid() {
        return grid;
    }

    public Cell locateCell(int xCoordinate, int yCoordinate){
        return grid[xCoordinate][yCoordinate];
    }

    public void displayGrid(){

        for (Cell[] ints : grid) {
            for (Cell currentCell: ints) {
                System.out.print(currentCell);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public Cell getCell(int xCoordinate, int yCoordinate){
        return grid[xCoordinate][yCoordinate];
    }
    public int getWidth(){
        return numOfRows;
    }
    public int getHeight(){
        return numOfCols;
    }

    //this method initializes the next generation grid with zero values
    public void initializeEmptyGrid(Grid grid) throws UndefinedColourException {
        for (int r = 0; r < grid.getWidth(); r++) {
            for (int c = 0; c < grid.getHeight(); c++) {
                grid.getGrid()[r][c] = new Cell(0, r, c);
            }
        }
    }

}
