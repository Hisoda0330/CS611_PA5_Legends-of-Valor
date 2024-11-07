package model.user.hero;

import model.space.Space;
import model.user.UserFactory;
import model.user.UserGroup;

/**
 *
 */
public class HeroGroup extends UserGroup<Hero> {

    private Space space;
    private boolean atMarket;

    public HeroGroup(int size, UserFactory heroFactory) {
        for (int i = 0; i < size; i++) {
            add((Hero) heroFactory.createUser());
        }
    }

    @Override
    public String toString() {
        String text = "";
        text += "\nHero party at " + space.getType() + " Space\n";
        for (Hero hero : this) {
            text += "\n" + hero.toString() + "\n";
        }
        return text.trim();
    }

    /**
     * Set the space.
     *
     * @param space the space to set
     */
    public void setSpace(Space space) {
        this.space = space;
    }

    /**
     * Get the space.
     *
     * @return the space
     */
    public Space getSpace() {
        return space;
    }

    /**
     * Get the atMarket.
     *
     * @return the atMarket
     */
    public boolean isAtMarket() {
        return atMarket;
    }

    /**
     * Set the atMarket.
     *
     * @param atMarket the atMarket to set
     */
    public void setAtMarket(boolean atMarket) {
        this.atMarket = atMarket;
    }
}
