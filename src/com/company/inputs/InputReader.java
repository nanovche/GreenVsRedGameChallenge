package com.company.inputs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    BufferedReader bufferedReader;

    public InputReader(){
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int readWidthOfGrid() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }
    public int readHeightOfGrid() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }
    public List<String> readRowsOfGrid(int numberOfRows) throws IOException {

        List<String> rows = new ArrayList<>();

        for (int index = 0; index < numberOfRows; index++) {
            rows.add(bufferedReader.readLine());
        }
        return rows;
    }
    public int readXCoordinateOfTargetCell() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }
    public int readYCoordinateOfTargetCell() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }
    public int readNumOfGenerations() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

    public void closeReader() throws IOException{
        bufferedReader.close();
    }
}