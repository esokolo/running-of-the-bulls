package com.Lab;

public class Coordinate
{
    private int row, column;
    private char value;

    public Coordinate(int row, int column)
    {
        this.row = row;
        this.column = column;
        this.value = ' ';
    }

    public void setValue(char value) { this.value = value; }
    public char getValue() { return value; }
    public int getRow() { return row;}
    public int getColumn() { return column; }
    public void setRow(int row) { this.row = row; }
    public void setColumn(int column) { this.column = column; }
}
