package com.felipemg.mysticsquare;

import com.felipemg.util.Position;

import java.util.HashMap;
import java.util.Map;

public final class Board {

    private Map<String, Position> tiles;

    private Board(int size){
        this.tiles = initializeBoard(size);
    }

    private Map<String, Position> initializeBoard(int size){
        Map<String,Position> tiles = new HashMap<String, Position>(size * size);
        for (int tile = 1; tile < size; tile++) {
            int x = (int) Math.ceil(tile /4.0);
            int y = tile % 4;
            tiles.put(Integer.toString(tile),Position.of(x,y));
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
