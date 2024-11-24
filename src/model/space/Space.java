package model.space;

import model.Coordinate;
import model.user.hero.Hero;
import model.user.monster.Monster;

/**
 *
 */
public class Space {
    private Coordinate position;
    private Hero hero;
    private Monster monster;

    private String type;

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
        this.position = new Coordinate(row, col);
        this.activity = activity;
        this.type = type;
    }

    public boolean enterAction(Hero hero, Space space) {
        return activity.enterAction(hero, space);
    }

    public void leftAction(Hero hero) {
        activity.leftAction(hero);
    }

    public char getSymbol() {
        return type.toUpperCase().charAt(0);
    }

    /**
     * Get the position.
     *
     * @return the position
     */
    public Coordinate getPosition() {
        return position;
    }

    /**
     * Get the row.
     *
     * @return the row
     */
    public int getRow() {
        return position.getRow();
    }

    /**
     * Get the col.
     *
     * @return the col
     */
    public int getCol() {
        return position.getCol();
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

    /**
     * Set the activity.
     *
     * @param activity the activity to set
     */
    public void setActivity(SpaceActivity activity) {
        this.activity = activity;
    }

    /**
     * Set the hero.
     *
     * @param hero the hero to set
     */
    public void setHero(Hero hero) {
        this.hero = hero;
    }

    /**
     * Set the monster.
     *
     * @param monster the monster to set
     */
    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    /**
     * Get the hero.
     *
     * @return the hero
     */
    public Hero getHero() {
        return hero;
    }

    /**
     * Get the monster.
     *
     * @return the monster
     */
    public Monster getMonster() {
        return monster;
    }
}
