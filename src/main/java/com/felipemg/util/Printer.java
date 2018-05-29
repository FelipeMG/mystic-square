package com.felipemg.util;

public final class Printer {

    public static final String NEW_LINE = String.format("%n");
    public static final String ROW_SEPARATOR = "*--";
    public static final String END_OF_ROW = "*";
    public static final String TILE_SEPARATOR = "|";
    public static final String EMPTY_TILE = " ";


    private Printer(){
        throw new AssertionError("This class should not be instantiated");
    }

}
