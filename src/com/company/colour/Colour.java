package com.company.colour;

public enum Colour {
    RED(0),GREEN(1);

    private final int number;

    Colour(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

}
