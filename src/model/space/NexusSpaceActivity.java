package model.space;

import model.user.hero.Hero;

/**
 * NexusSpaceActivity
 */
public class NexusSpaceActivity implements ValorSpaceActivity {

    @Override
    public boolean enterAction(Hero hero, Space space) {
        hero.setSpace(space);
        System.out.println("\n" + "Hero " + hero.getName() + " enter nexus space.");

        return true;
    }

    @Override
    public void leftAction(Hero hero) {
        System.out.println("\n" + "Hero " + hero.getName() + " left nexus space.");
    }
}
