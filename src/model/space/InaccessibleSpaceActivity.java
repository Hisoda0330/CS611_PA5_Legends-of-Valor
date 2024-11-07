package model.space;


import model.user.hero.HeroGroup;

/**
 * Represents an Activity of InaccessibleSpace.
 */
public class InaccessibleSpaceActivity implements SpaceActivity {

    /**
     * When heros enter the space, some actions are caused.
     *
     * @param heroGroup the group of hero.
     * @param model     the model of game.
     */
    public void action(HeroGroup heroGroup, Space space) {
        System.out.println("\nHeros cannot enter inaccessible spaces.");
    }
}
