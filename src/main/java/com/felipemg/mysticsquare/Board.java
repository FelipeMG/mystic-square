package com.felipemg.mysticsquare;

import com.felipemg.util.Position;
import com.felipemg.util.Printer;

import java.util.HashMap;
import java.util.Map;

public final class Board {

    private Map<String, Position> tiles;
    private int size;

    private Board(int size){
        this.size = size;
        this.tiles = initializeBoard(size);
    }

    private Map<String, Position> initializeBoard(int size){

        Integer numberOfTiles = (size * size) -1 ;
        Map<String,Position> tiles = new HashMap<String, Position>(numberOfTiles);
        for (int tile = 1; tile < size; tile++) {
            int xIndex = (int) Math.ceil(tile * 1.0 /size);
            int yIndex = tile % size;
            tiles.put(Integer.toString(tile),Position.of(xIndex,yIndex));
        }
        tiles.put("",Position.of(size,size));
        return tiles;
    }


    public static Board of(int size){
        return new Board(size);
    }

    @Override
    public String toString() {
        return "Board{" +
                "tiles=" + tiles +
                '}';
    }

}
