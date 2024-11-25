package model.space;

import model.user.hero.Hero;

/**
 * Represents an Activity of InaccessibleSpace.
 */
public class CaveSpaceActivity implements ValorSpaceActivity {

    @Override
    public boolean enterAction(Hero hero, Space space) {
        hero.setSpace(space);
        System.out.println("\n" + "Hero " + hero.getName() + " enter cave space.");

        hero.increaseAgility(0.1);
        return true;
    }

    @Override
    public void leftAction(Hero hero) {
        System.out.println("\n" + "Hero " + hero.getName() + " left cave space.");

        hero.decreaseAgility(0.1);
    }

}
