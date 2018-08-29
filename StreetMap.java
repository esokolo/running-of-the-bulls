package com.Lab;

import sun.awt.SunGraphicsCallback;

import java.security.SecureRandom;

public class StreetMap
{
    private Coordinate[][] coordinates;
    private SecureRandom randomNumber;
    private int rowCount;
    private int columnCount;

    public  StreetMap(int rowCount, int columnCount)
    {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.randomNumber = new SecureRandom();
        makeCoordinate(rowCount, columnCount);
    }

    private void makeCoordinate(int rowCount, int columnCount)
    {
        coordinates = new Coordinate[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++)
            for (int j = 0; j < columnCount; j++)
                coordinates[i][j] = new Coordinate(i, j);
        assignValues();
    }

    private void assignValues()
    {
        for (int i = 0; i < columnCount; i++)
        {
            coordinates[0][i].setValue('W');
            coordinates[columnCount - 1][i].
                    setValue('W');
        }

        for (int i = 0; i < columnCount; i++)
        {
            coordinates[i][0].setValue('W');
            coordinates[i][columnCount - 1].
                    setValue('W');
        }

        for (int i = 0; i < columnCount - 2; i++)
            coordinates[rowCount - 1][i].setValue('W');


        coordinates[0][1].setValue('S');
        coordinates[rowCount - 1][columnCount - 2].
                setValue('E');
        addWalls();
    }

    private void addWalls()
    {
        int blockCount = (rowCount - 2) *
                (columnCount - 2);
        int X = 0;
        int Y = 0;

        for (int i = 0; i < blockCount; i++)
        {
            X = 1 + randomNumber.nextInt(rowCount - 2);
            Y = 1 + randomNumber.nextInt(columnCount - 2);
            coordinates[X][Y].setValue('W');
        }
        fix();
    }

    private void fix()
    {
        coordinates[1][1].setValue(' ');
        coordinates[rowCount - 2][columnCount - 2].setValue(' ');
        Path path = new Path(coordinates);

    }

    public Coordinate[][] getCoordinates() { return coordinates; }
}
