package com.rea.model;

/**
 * Enum class for the directions NORTH, WEST, EAST and SOUTH.
 */
public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    /**
     * Returns the next direction in the sequence. If the last enum, cycles to the first element.
     *
     * @return  Next enum
     */
    public Direction getNext() {
        if (this.ordinal() < Direction.values().length - 1) {
            return Direction.values()[this.ordinal() + 1];
        }
        else {
            return Direction.values()[0];
        }
    }

    /**
     * Returns the previous direction in the sequence. If the first enum, cycles to the last element.
     *
     * @return  Previous enum
     */
    public Direction getPrev() {
        if (this.ordinal() == 0) {
            return Direction.values()[Direction.values().length - 1];
        }
        else {
            return Direction.values()[this.ordinal() - 1];
        }
    }
}
