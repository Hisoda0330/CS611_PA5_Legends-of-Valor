package model.space;

import model.user.hero.Hero;

/**
 * The interface of space activities.
 */
public interface SpaceActivity {

    /**
     * When heros enter the space, some actions are caused.
     *
     * @param hero  the hero
     * @param space the space entered
     */
    boolean enterAction(Hero hero, Space space);

    /**
     * When heros enter the space, some actions are caused.
     *
     * @param hero the hero
     */
    void leftAction(Hero hero);
}
