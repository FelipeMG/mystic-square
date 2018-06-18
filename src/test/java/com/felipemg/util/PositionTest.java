package com.felipemg.util;

import org.junit.Test;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PositionTest {

    @Test(expected = IllegalArgumentException.class)
    public void positionOfNegativeNumbersShouldReturnIllegalArgumentException(){
        Position.of(-1,1);
    }

    @Test()
    public void positionOfXequals0AndYequals0IsNotNull(){
        assertThat(Position.of(0,0),is(notNullValue()));
    }

    @Test()
    public void positionOfXequals1AndYequals1IsNotNull(){
        assertThat(Position.of(1,1),is(notNullValue()));
    }

    @Test()
    public void positionOfXequals0AndYequals0IsNotEqualsTopositionOfXequals1AndYequals0(){
        assertThat(Position.of(0,0).toString(),is(not(Position.of(1,0).toString())));
    }

}
