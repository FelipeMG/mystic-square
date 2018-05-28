package com.felipemg.mysticsquare;

import com.felipemg.util.Printer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BoardTest {

    private StringBuilder builder;

    @Before
    public void init(){
        this.builder = new StringBuilder();
    }

    @Test
    public void boardOfSize3ShouldBeWellInitiliazed(){
        builder.append("|1|2|3|").append(Printer.NEW_LINE);
        builder.append("|4|5|6|").append(Printer.NEW_LINE);
        builder.append("|7|8| |").append(Printer.NEW_LINE);
        assertThat(Board.of(3).toString(), is(builder.toString()));
    }

    @Test
    public void boardOfSize4ShouldBeWellInitiliazed(){
        builder.append("|1|2|3|4|").append(Printer.NEW_LINE);
        builder.append("|5|6|7|8|").append(Printer.NEW_LINE);
        builder.append("|9|10|11|12|").append(Printer.NEW_LINE);
        builder.append("|13|14|15| |").append(Printer.NEW_LINE);
        assertThat(Board.of(4).toString(), is(builder.toString()));
    }

    @Test
    public void boardOfSize5ShouldBeWellInitiliazed(){
        builder.append("|1|2|3|4|5|").append(Printer.NEW_LINE);
        builder.append("|6|7|8|9|10|").append(Printer.NEW_LINE);
        builder.append("|11|12|13|14|15|").append(Printer.NEW_LINE);
        builder.append("|16|17|18|19|20|").append(Printer.NEW_LINE);
        builder.append("|21|22|23|24| |").append(Printer.NEW_LINE);
        assertThat(Board.of(5).toString(), is(builder.toString()));
    }
}
