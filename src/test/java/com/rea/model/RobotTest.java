package com.rea.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {
    private static String MSG_PLACE_FIRST = "Foo";
    private Robot robot;

    @Before
    public void before() {
        robot = new Robot();
    }

    @Test
    public void shouldNotPlaceInNegativePosition() throws Exception {
        robot.place(-1, -1, "north");
        assertEquals(robot.report, MSG_PLACE_FIRST);
    }

    @Test
    public void shouldNotPlaceOffTable() throws Exception {
        robot.place(Table.LENGTH + 1, Table.LENGTH + 1, "north");
        assertEquals(robot.report, MSG_PLACE_FIRST);
    }

    @Test
    public void shouldIgnoreLeftIfNotPlaced() throws Exception {
        robot.left();
        assertEquals(robot.report, MSG_PLACE_FIRST);
    }

    @Test
    public void shouldIgnoreRightIfNotPlaced() throws Exception {
        robot.right();
        assertEquals(robot.report, MSG_PLACE_FIRST);
    }

    @Test
    public void shouldIgnoreIfNotPlaced() throws Exception {
        robot.report();
        assertEquals(robot.report, MSG_PLACE_FIRST);
    }

    @Test
    public void shouldPlaceOnTable() throws Exception {
        robot.place(0, 0, "north");
        assertEquals(robot.report, "0,0,NORTH");
    }

    @Test
    public void shouldReplaceOnTable() throws Exception {
        robot.place(0, 0, "north");
        robot.place(3, 3, "south");
        assertEquals(robot.report, "3,3,SOUTH");
    }

    @Test
    public void shouldRotateLeft() throws Exception {
        robot.place(0, 0, "north");
        robot.left();
        assertEquals(robot.report, "0,0,WEST");
    }

    @Test
    public void shouldRotateLeftTwice() throws Exception {
        robot.place(0, 0, "north");
        robot.left();
        robot.left();
        assertEquals(robot.report, "0,0,SOUTH");
    }

    @Test
    public void shouldRotateLeftThrice() throws Exception {
        robot.place(0, 0, "north");
        for (int i = 0; i < 3; i++) {
            robot.left();
        }
        assertEquals(robot.report, "0,0,EAST");
    }

    @Test
    public void shouldRotateLeftFullRotation() throws Exception {
        robot.place(0, 0, "north");
        for (int i = 0; i < 4; i++) {
            robot.left();
        }
        assertEquals(robot.report, "0,0,NORTH");
    }

    @Test
    public void shouldRotateRight() throws Exception {
        robot.place(0, 0, "north");
        robot.right();
        assertEquals(robot.report, "0,0,EAST");
    }

    @Test
    public void shouldRotateRightTwice() throws Exception {
        robot.place(0, 0, "north");
        robot.right();
        robot.right();
        assertEquals(robot.report, "0,0,SOUTH");
    }

    @Test
    public void shouldRotateRightThrice() throws Exception {
        robot.place(0, 0, "north");
        for (int i = 0; i < 3; i++) {
            robot.right();
        }
        assertEquals(robot.report, "0,0,WEST");
    }

    @Test
    public void shouldRotateRightFullRotation() throws Exception {
        robot.place(0, 0, "north");
        for (int i = 0; i < 4; i++) {
            robot.right();
        }
        assertEquals(robot.report, "0,0,NORTH");
    }

    @Test
    public void shouldMoveOnce() throws Exception {
        robot.place(0, 0, "north");
        robot.move();
        assertEquals(robot.report, "0,1,NORTH");
    }

    @Test
    public void shouldMoveTwice() throws Exception {
        robot.place(0, 0, "north");
        robot.move();
        robot.move();
        assertEquals(robot.report, "0,2,NORTH");
    }

    @Test
    public void shouldIgnoreMovingOffTable() throws Exception {
        robot.place(0, 0, "north");
        for (int i = 0; i < Table.LENGTH + 1; i++) {
            robot.move();
        }
        assertEquals(robot.report, "0,4,NORTH");
    }

    @Test
    public void shouldCombineMovingAndRotating() throws Exception {
        robot.place(1, 2, "east");
        robot.move();
        robot.move();
        robot.left();
        robot.move();
        assertEquals(robot.report, "3,3,NORTH");
    }

    @Test
    public void shouldIgnoreMovingOffTableAllSides() throws Exception {
        robot.place(0, 0, "north");

        for (int i = 0; i < 4; i++) {
            for (int i = 0; i < Table.LENGTH; i++) {
                robot.move();
            }

            robot.right();
        }

        robot.move();
        robot.move();
        robot.left();
        robot.move();
        assertEquals(robot.report, "0,0,NORTH");
    }
}