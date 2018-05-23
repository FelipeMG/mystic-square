package com.felipemg.util;

import org.junit.Test;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PositionTest {

    @Test(expected = IllegalArgumentException.class)
    public void positionOf0ShouldReturnIllegalArgumentException(){
        assertThat(Position.of(0,0),is(Position.of(1,1)));
    }

    @Test()
    public void positionOfXequals1AndYequals1IsNotNull(){
        assertThat(Position.of(1,1),is(notNullValue()));
    }


}
