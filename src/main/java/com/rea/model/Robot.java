package com.rea.model;

/**
 * Created by akumadevil on 4/11/2014.
 */
public class Robot {
    private boolean placed;
    private int x;
    private int y;
    private Direction facing;

    public void place(int x, int y, Direction facing) {
        if (isValidPlacement(x) && isValidPlacement(y)) {
            this.x = x;
            this.y = y;
            this.facing = facing;
            placed = true;
        }
    }

    public String report() {
        if (placed) {
            return (x + "," + y + "," + facing).toUpperCase();
        }

        return "";
    }

    public void left() {
        if (placed) {
            facing = facing.getPrev();
        }
    }

    public void right() {
        if (placed) {
            facing = facing.getNext();
        }
    }

    public void move() {
        if (placed) {
            moveForward();
        }
    }

    private void moveForward() {
        // Lambda?
        switch (facing) {
            case NORTH:
                if (isValidPlacement(y + 1)) {
                    y++;
                }
                break;
            case SOUTH:
                if (isValidPlacement(y - 1)) {
                    y--;
                }
                break;
            case EAST:
                if (isValidPlacement(x + 1)) {
                    x++;
                }
                break;
            case WEST:
                if (isValidPlacement(x - 1)) {
                    x--;
                }
                break;
        }
    }

    private static boolean isValidPlacement(int pos) {
        if (pos >= 0 && pos < Table.LENGTH) {
            return true;
        }

        return false;
    }
}
