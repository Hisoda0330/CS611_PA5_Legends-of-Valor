package model.space;

import model.user.hero.HeroGroup;

/**
 * The interface of space activities.
 */
public interface SpaceActivity {

    /**
     * When heros enter the space, some actions are caused.
     *
     * @param heroGroup the group of hero.
     * @param space     the space entered
     */
    void action(HeroGroup heroGroup, Space space);
}
