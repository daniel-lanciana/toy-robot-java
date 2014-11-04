package com.rea.service;

import com.rea.model.Direction;
import com.rea.model.Robot;

/**
 * Adapter between raw input and Robot object.
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

    /**
     * Calls the appropriate Robot method depending on input.
     *
     * @param input     Raw command
     * @return          Report text, invalid input error message or empty string
     */
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

    /**
     * Parses the input and calls the PLACE command.
     *
     * @param input     Raw input
     */
    private void callPlaceCommand(String input) {
        String[] args = input.replaceAll("place ", "").split(",");

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        Direction facing = Direction.valueOf(args[2].toUpperCase());

        robot.place(x, y, facing);
    }

    /**
     * Matches the PLACE command input against a regular expression.
     *
     * @param input     Place command input
     * @return          TRUE if a valid-formatted command
     */
    private boolean isValidPlaceCommand(String input) {
        return input.matches("^place [0-9]+,[0-9]+,(north|south|east|west)");
    }
}