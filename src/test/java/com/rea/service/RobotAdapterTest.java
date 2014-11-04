package com.rea.service;

import com.rea.model.Direction;
import com.rea.model.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RobotAdapterTest {
    private static String ERROR_MSG_INVALID_INPUT = "Invalid input";
    private static String STUB_REPORT = "mock report";

    private RobotAdapter adapter;
    private Robot robot;

    @Before
    public void before() {
        adapter = new RobotAdapter();
        robot = mock(Robot.class);
        adapter.setRobot(robot);
    }

    @Test
    public void shouldHaveValidFirstArgumentForPlaceCommand() throws Exception {
        assertEquals(ERROR_MSG_INVALID_INPUT, adapter.input("PLACE FOO,1,NORTH"));
    }

    @Test
    public void shouldHaveValidSecondArgumentForPlaceCommand() throws Exception {
        assertEquals(ERROR_MSG_INVALID_INPUT, adapter.input("PLACE 1,FOO,NORTH"));
    }

    @Test
    public void shouldHaveValidThirdArgumentForPlaceCommand() throws Exception {
        assertEquals(ERROR_MSG_INVALID_INPUT, adapter.input("PLACE 1,1,FOO"));
    }

    @Test
    public void shouldIgnoreBadInput() throws Exception {
        assertEquals(ERROR_MSG_INVALID_INPUT, adapter.input("FOO BAR"));
    }

    @Test
    public void shouldIgnoreMissingInput() throws Exception {
        assertEquals(ERROR_MSG_INVALID_INPUT, adapter.input(""));
    }

    @Test
    public void shouldCallPlace() throws Exception {
        adapter.input("PLACE 123,456,NORTH");
        verify(robot).place(123, 456, Direction.NORTH);
    }

    @Test
    public void shouldCallMove() throws Exception {
        adapter.input("MOVE");
        verify(robot).move();
    }

    @Test
    public void shouldCallLeft() throws Exception {
        adapter.input("LEFT");
        verify(robot).left();
    }

    @Test
    public void shouldCallRight() throws Exception {
        adapter.input("RIGHT");
        verify(robot).right();
    }

    @Test
    public void shouldCallReport() throws Exception {
        when(robot.report()).thenReturn(STUB_REPORT);
        assertEquals(STUB_REPORT, adapter.input("REPORT"));
    }

    @Test
    public void shouldBeCaseInsensitive() throws Exception {
        adapter.input("mOvE");
        verify(robot).move();
    }
}