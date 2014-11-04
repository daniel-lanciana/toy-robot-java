package com.rea.model;

/**
 * Created by akumadevil on 4/11/2014.
 */
public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction getNext() {
        if (this.ordinal() < Direction.values().length - 1) {
            return Direction.values()[this.ordinal() + 1];
        }
        else {
            return Direction.values()[0];
        }
    }

    public Direction getPrev() {
        if (this.ordinal() == 0) {
            return Direction.values()[Direction.values().length - 1];
        }
        else {
            return Direction.values()[this.ordinal() - 1];
        }
    }
}
