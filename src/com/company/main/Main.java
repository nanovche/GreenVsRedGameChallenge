package com.company.main;

import com.company.solvers.NextGenerationSolver;
import com.company.exceptions.*;
import com.company.grid.Grid;
import com.company.inputs.InputReader;
import com.company.inputs.InputValidator;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws UndefinedColourException, WidthIsMoreThanHeightException, OutOfBoundsException, XCoordinateOfTargetCellOutOfGridException, YCoordinateOfTargetCellOutOfGridException, NumberOfGenerationsIsLessThanOneException, IOException {

        InputReader inputReader = new InputReader();
        InputValidator inputValidator = new InputValidator();

        final int widthOfTheGrid = inputReader.readWidthOfGrid();
        final int heightOfTheGrid = inputReader.readHeightOfGrid();

        inputValidator.validateWidth(widthOfTheGrid);
        inputValidator.validateHeight(heightOfTheGrid);
        inputValidator.validateWidthIsLessThanOrEqualToHeight(widthOfTheGrid, heightOfTheGrid);

        List<String> rows = inputReader.readRowsOfGrid(heightOfTheGrid);
        int xCoordinateOfTargetCell = inputReader.readXCoordinateOfTargetCell();
        int yCoordinateOfTargetCell = inputReader.readYCoordinateOfTargetCell();
        int numberOfGenerations = inputReader.readNumOfGenerations();
        inputReader.closeReader();

        inputValidator.targetCellXCoordinateIsWithinGrid(xCoordinateOfTargetCell, widthOfTheGrid);
        inputValidator.targetCellYCoordinateIsWithinGrid(yCoordinateOfTargetCell, heightOfTheGrid);
        inputValidator.numberNIsAtLeastOne(numberOfGenerations);

        ZeroGenerationCreator zeroGenerationCreator = new ZeroGenerationCreator();
        Grid zeroGenerationGrid = zeroGenerationCreator.createZeroGeneration(widthOfTheGrid, heightOfTheGrid, rows);

        zeroGenerationGrid.displayGrid();
        int result = new NextGenerationSolver(zeroGenerationGrid, numberOfGenerations, zeroGenerationGrid.getCell(xCoordinateOfTargetCell,yCoordinateOfTargetCell)).solve();

        System.out.println(result);

    }
}
