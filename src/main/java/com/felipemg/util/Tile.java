package com.felipemg.util;

public class Tile {

    private String symbol;

    private Tile(String symbol){
        this.symbol = symbol;
    }

    public static Tile of(String symbol){
        return new Tile(symbol);
    }

    @Override
    public String toString() {
        String symbolString = "  " + symbol + "  ";
        return symbolString.substring(0,5);
    }
}
