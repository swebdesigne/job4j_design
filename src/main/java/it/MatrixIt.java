package it;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int empty = 0;
        for (int[] it : data) {
            if (it.length == 0) {
                empty++;
            }
        }
        if (empty == data.length) {
            return false;
        }
        if (row + 1 == data.length) {
            return column < data[row].length;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (column == data[row].length) {
            column = 0;
            row++;
        }
        for (int i = row; i < data.length; i++) {
            if (data[i].length != 0) {
                row = i;
                break;
            }
        }
        return data[row][column++];
    }
}
