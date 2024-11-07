package model.space;

import model.user.hero.HeroGroup;

/**
 *
 */
public class Space {
    private String type;

    /** row position */
    private int row;
    /** column position */
    private int col;
    /** action of space */
    private SpaceActivity activity;

    /**
     * Creates a new space.
     *
     * @param row
     * @param col
     * @param action
     */
    public Space(int row, int col, String type, SpaceActivity activity) {
        this.row = row;
        this.col = col;
        this.activity = activity;
        this.type = type;
    }

    public void action(HeroGroup heroGroup) {
        activity.action(heroGroup, this);
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

    /**
     * Get the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Get the activity.
     *
     * @return the activity
     */
    public SpaceActivity getActivity() {
        return activity;
    }
}
