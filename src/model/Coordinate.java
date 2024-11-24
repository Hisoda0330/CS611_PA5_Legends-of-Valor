package model;

/**
 * Represents a coordinate of map.
 */
public class Coordinate {
    private int row;
    private int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Get the row.
     *
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the col.
     *
     * @return the col
     */
    public int getCol() {
        return col;
    }


}
