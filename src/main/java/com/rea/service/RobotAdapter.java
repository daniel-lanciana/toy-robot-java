package com.rea.service;

import com.rea.model.Direction;
import com.rea.model.Robot;

import java.util.Vector;

/**
 * Created by akumadevil on 4/11/2014.
 */
public class RobotAdapter {
    private static String ERROR_MSG_INVALID_INPUT = "Invalid input";

    private Robot robot;

    public RobotAdapter() {
        robot = new Robot();
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public String input(String input) {
        if (input != null) {
            input = input.trim().toLowerCase();

            switch(input) {
                case "move":
                    robot.move();
                    break;
                case "right":
                    robot.right();
                    break;
                case "left":
                    robot.left();
                    break;
                case "report":
                    return robot.report();
                default:
                    if (isValidPlaceCommand(input)) {
                        callPlaceCommand(input);
                    }
                    else {
                        return ERROR_MSG_INVALID_INPUT;
                    }
            }
        }

        return "";
    }

    private void callPlaceCommand(String input) {
        String[] args = input.replaceAll("place ", "").split(",");

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        Direction facing = Direction.valueOf(args[2].toUpperCase());

        robot.place(x, y, facing);
    }

    private boolean isValidPlaceCommand(String input) {
        return input.matches("^place [0-9]+,[0-9]+,(north|south|east|west)");
    }
}