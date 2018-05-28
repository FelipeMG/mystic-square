package com.felipemg.mysticsquare;

import com.felipemg.util.Position;
import com.felipemg.util.Printer;

import java.util.HashMap;
import java.util.Map;

public final class Board {

    private Map<String, Position> tilesPosition;
    private String[][] tiles;
    private int size;

    private Board(int size){
        this.size = size;
        this.tiles = initializeBoard(size);
    }

    private String[][] initializeBoard(int size){

        int number = 1;
        String[][] tiles = new String[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                tiles[row][col] = String.valueOf(number);
                ++number;
            }
        }
        tiles[size-1][size-1] = Printer.EMPTY_SPACE;
        return tiles;
    }

    public static Board of(int size){
        return new Board(size);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                builder.append(Printer.TILE_SEPARATOR);
                builder.append(tiles[row][col]);
            }
            builder.append(Printer.TILE_SEPARATOR);
            builder.append(Printer.NEW_LINE);
        }

        return builder.toString();
    }
}
