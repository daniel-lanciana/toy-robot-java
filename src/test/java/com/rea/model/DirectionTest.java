package com.rea.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {
    @Test
    public void shouldReturnTheNextElement() throws Exception {
        assertEquals(Direction.EAST, Direction.NORTH.getNext());
    }

    @Test
    public void shouldReturnFirstElementWhenAtLastElementAndCallNext() throws Exception {
        assertEquals(Direction.NORTH, Direction.WEST.getNext());
    }

    @Test
    public void shouldReturnThePrevElement() throws Exception {
        assertEquals(Direction.EAST, Direction.SOUTH.getPrev());
    }

    @Test
    public void shouldReturnLastElementWhenAtFirstElementAndCallPrev() throws Exception {
        assertEquals(Direction.WEST, Direction.NORTH.getPrev());
    }
}