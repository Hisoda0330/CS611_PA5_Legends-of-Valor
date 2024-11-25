package model.space;


import model.user.hero.Hero;

/**
 * Represents an Activity of InaccessibleSpace.
 */
public class InaccessibleSpaceActivity implements ValorSpaceActivity {

    @Override
    public boolean enterAction(Hero hero, Space space) {
        System.out.println("\nHero cannot enter inaccessible spaces.");
        return false;
    }

    @Override
    public void leftAction(Hero hero) {
        return;
    }

}
