package model.space;

import model.user.hero.HeroGroup;

/**
 * The interface of space activities.
 */
public interface SpaceActivity {


    void action(HeroGroup heroGroup, Space space);
}
