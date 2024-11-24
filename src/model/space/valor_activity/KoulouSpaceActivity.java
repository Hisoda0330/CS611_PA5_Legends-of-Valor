package model.space.valor_activity;

import model.space.Space;
import model.space.ValorSpaceActivity;
import model.user.hero.Hero;

/**
 * Represents an Activity of InaccessibleSpace.
 */
public class KoulouSpaceActivity implements ValorSpaceActivity {

    @Override
    public boolean enterAction(Hero hero, Space space) {
        hero.setSpace(space);
        System.out.println("\n" + "Hero " + hero.getName() + " enter koulou space.");

        hero.increaseStrength(0.1);
        return true;
    }

    @Override
    public void leftAction(Hero hero) {
        System.out.println("\n" + "Hero " + hero.getName() + " left koulou space.");

        hero.decreaseStrength(0.1);
    }

}
