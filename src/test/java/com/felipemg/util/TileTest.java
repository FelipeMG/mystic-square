package com.felipemg.util;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TileTest {

    @Test
    public void emptyTileToStringShouldBeEqualsToEmptyString(){
        assertThat(Tile.of(Printer.EMPTY_TILE).toString(),is("     "));
    }

    @Test
    public void number1TileToStringShouldBeEqualsTo1(){
        assertThat(Tile.of("1").toString(),is("  1  "));
    }

    @Test
    public void number10TileToStringShouldBeEqualsTo10(){
        assertThat(Tile.of("10").toString(),is("  10 "));
    }

}
