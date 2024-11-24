package model.space;

import model.user.hero.Hero;

/**
 * Represents an Activity of InaccessibleSpace.
 */
public class BushSpaceActivity implements SpaceActivity {

    @Override
    public boolean enterAction(Hero hero, Space space) {

        hero.setSpace(space);
        System.out.println("\n" + "Hero " + hero.getName() + " enter bush space.");

        hero.increaseDexterity(0.1);
        return true;
    }

    @Override
    public void leftAction(Hero hero) {
        System.out.println("\n" + "Hero " + hero.getName() + " left bush space.");

        hero.decreaseDexterity(0.1);
    }

}
