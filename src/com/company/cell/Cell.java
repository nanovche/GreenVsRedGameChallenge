package com.company.cell;

import com.company.colour.Colour;
import com.company.exceptions.ExceptionMessagesUtilityClass;
import com.company.exceptions.UndefinedColourException;

public class Cell {

    private int value;
    private final int xCoordinate;
    private final int yCoordinate;
    private Colour colour;

    public Cell(final int value, final int xCoordinate,final int yCoordinate) throws UndefinedColourException {
        this.value = value;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        if(this.value == 0){
            colour = Colour.RED;
        } else if(this.value == 1){
            colour = Colour.GREEN;
        } else {
            throw new UndefinedColourException(ExceptionMessagesUtilityClass.UNDEFINED_COLOUR_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this){
            return true;
        }

        if(obj == null){
            return false;
        }

        if(!(obj instanceof Cell)){
            return false;
        }

        Cell thatCell = (Cell)obj;

        return this.xCoordinate == thatCell.xCoordinate && this.yCoordinate == thatCell.yCoordinate;

    }

    public void setValue(int value){
        this.value = value;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(final Colour colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
