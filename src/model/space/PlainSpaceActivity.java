package model.space;

import model.user.hero.Hero;

/**
 * Represents an Activity of InaccessibleSpace.
 */
public class PlainSpaceActivity implements SpaceActivity {

    @Override
    public boolean enterAction(Hero hero, Space space) {
        hero.setSpace(space);
        System.out.println("\n" + "Hero " + hero.getName() + " enter plain space.");

        return true;
    }

    @Override
    public void leftAction(Hero hero) {
        System.out.println("\n" + "Hero " + hero.getName() + " left plain space.");
    }

}
