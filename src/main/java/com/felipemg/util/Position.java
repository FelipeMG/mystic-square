package com.felipemg.util;

public class Position {

    private int x;
    private int y;

    private Position(final int x, final int y) {
        if(x <= 0 || y <= 0){
            throw new IllegalArgumentException();
        }
        this.x = x;
        this.y = y;
    }

    public static Position of(int x, int y){
        return new Position(x,y);
    }

}
