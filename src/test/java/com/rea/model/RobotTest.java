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
    public void shouldNotPlaceRobotInNegativePosition() throws Exception {
        robot.place(-1, -1, "north");
        assertEquals(robot.report, MSG_PLACE_FIRST);
    }

    @Test
    public void shouldNotPlaceRobotOffTable() throws Exception {
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
    public void shouldIgnoreReportIfNotPlaced() throws Exception {
        robot.report();
        assertEquals(robot.report, MSG_PLACE_FIRST);
    }
}

/*


  describe "placing the robot on the table" do
    it "successful placement" do
      @robot.place 0, 0, :north
      @robot.report.must_equal "0,0,NORTH"
    end

    it "re-place robot" do
      @robot.place 3, 3, :south
      @robot.report.must_equal "3,3,SOUTH"
    end
  end

  describe "rotating the robot" do
    before do
      @robot.place 0, 0, :north
    end

    it "rotate left once" do
      @robot.left
      @robot.report.must_equal "0,0,WEST"
    end

    it "rotate left twice" do
      2.times do
        @robot.left
      end
      @robot.report.must_equal "0,0,SOUTH"
    end

    it "rotate left thrice" do
      3.times do
        @robot.left
      end
      @robot.report.must_equal "0,0,EAST"
    end

    it "rotate left one full rotation" do
      4.times do
        @robot.left
      end
      @robot.report.must_equal "0,0,NORTH"
    end

    it "rotate right once" do
      @robot.right
      @robot.report.must_equal "0,0,EAST"
    end

    it "rotate right twice" do
      2.times do
        @robot.right
      end
      @robot.report.must_equal "0,0,SOUTH"
    end

    it "rotate right thrice" do
      3.times do
        @robot.right
      end
      @robot.report.must_equal "0,0,WEST"
    end

    it "rotate right one full rotation" do
      4.times do
        @robot.right
      end
      @robot.report.must_equal "0,0,NORTH"
    end
  end

  describe "moving the robot forward" do
    before do
      @robot.place 0, 0, :north
    end

    it "forward one block" do
      @robot.move
      @robot.report.must_equal "0,1,NORTH"
    end

    it "forward two block" do
      2.times do
        @robot.move
      end
      @robot.report.must_equal "0,2,NORTH"
    end

    it "moving off the table is ignored" do
      (Table.length + 1).times do
        @robot.move
      end
      @robot.report.must_equal "0,4,NORTH"
    end
  end

  describe "combined moving and rotating the robot" do
    it "all over the place" do
      @robot.place 1, 2, :east

      2.times do
        @robot.move
      end

      @robot.left
      @robot.move
      @robot.report.must_equal "3,3,NORTH"
    end

    it "can't be moved off the table on any side (assuming table is a square)" do
      @robot.place 0, 0, :north

      4.times do
        (Table.length + 1).times do
          @robot.move
        end

        @robot.right
      end

      @robot.report.must_equal "0,0,NORTH"
    end
  end
 */