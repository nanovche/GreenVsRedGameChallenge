package com.company.exceptions;

import com.company.cell.Cell;
import com.company.grid.Grid;

import java.util.List;

public class ZeroGenerationCreator {

    public Grid createZeroGeneration(final int widthOfTheGrid,final int heightOfTheGrid, List<String> rows) throws UndefinedColourException {
        Grid grid = new Grid(widthOfTheGrid, heightOfTheGrid);

        for (int height = 0, successiveRowFromInput = 0; height < heightOfTheGrid; height++, successiveRowFromInput++) {

            String[] currentRowValues = rows.get(successiveRowFromInput).split("");

            for (int width = 0; width < widthOfTheGrid; width++) {
                grid.getGrid()[height][width] = new Cell(Integer.parseInt(currentRowValues[width]), height, width);
            }
        }

        return grid;
    }

}
