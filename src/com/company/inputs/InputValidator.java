package com.company.inputs;

import com.company.exceptions.WidthIsMoreThanHeightException;
import com.company.exceptions.*;

public class InputValidator {

    public void validateWidthIsLessThanOrEqualToHeight(int width, int height) throws WidthIsMoreThanHeightException {
        if(width > height){
            throw new WidthIsMoreThanHeightException(ExceptionMessagesUtilityClass.WIDTH_MORE_THAN_HEIGHT_EXCEPTION_MESSAGE);
        }
    }

    public void validateHeight(int height) throws OutOfBoundsException {
        if(height == 0 || height >= 1000){
            throw new OutOfBoundsException("Height" + ExceptionMessagesUtilityClass.OUT_OF_BOUNDS_EXCEPTION_MESSAGE);
        }
    }

    public void validateWidth(int width) throws OutOfBoundsException {
        if(width == 0 || width >= 1000){
            throw new OutOfBoundsException("Width" + ExceptionMessagesUtilityClass.OUT_OF_BOUNDS_EXCEPTION_MESSAGE);
        }
    }

    public void targetCellXCoordinateIsWithinGrid(int xCoordinateOfTargetCell, int widthOfGrid) throws XCoordinateOfTargetCellOutOfGridException {

        if(xCoordinateOfTargetCell < 0 || xCoordinateOfTargetCell >= widthOfGrid ){
            throw new XCoordinateOfTargetCellOutOfGridException(ExceptionMessagesUtilityClass.X_COORDINATE_OF_TARGET_CELL_OUT_OF_GRID_EXCEPTION_MESSAGE);
        }
    }

    public void targetCellYCoordinateIsWithinGrid(int yCoordinateOfTargetCell, int heightOfGrid) throws YCoordinateOfTargetCellOutOfGridException {
        if(yCoordinateOfTargetCell < 0 || yCoordinateOfTargetCell >= heightOfGrid){
            throw new YCoordinateOfTargetCellOutOfGridException(ExceptionMessagesUtilityClass.Y_COORDINATE_OF_TARGET_CELL_OUT_OF_GRID_EXCEPTION_MESSAGE);
        }
    }

    public void numberNIsAtLeastOne(int numberN) throws YCoordinateOfTargetCellOutOfGridException, NumberOfGenerationsIsLessThanOneException {
        if(numberN <= 0){
            throw new NumberOfGenerationsIsLessThanOneException(ExceptionMessagesUtilityClass.NUMBER_OF_GENERATIONS_LESS_THAN_ONE_EXCEPTION_MESSAGE);
        }
    }

}
