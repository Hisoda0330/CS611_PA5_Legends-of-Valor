package controller.command;

import model.space.Space;
import model.user.hero.Hero;

/**
 * The class for hero came back to the Nexus. User need to press "r".
 */
public class RecallCommand extends KeyboardCommand {
    private Hero hero;

    public RecallCommand(Hero hero) {
        this.hero = hero;
    }

    @Override
    public boolean runCommand() {
        Space spawnSpace = hero.getSpawnSpace();
        if (spawnSpace.getHero() != null) {
            System.out.println("The Nexus space you spawned at is occupied by another hero!");
            return false;
        }

        if (hero.getSpace() != null) {
            hero.getSpace().leftAction(hero);
        }

        hero.setSpace(spawnSpace);
        System.out.println("Hero " + hero.getName() + " returns to the nexus spawned at.");
        return true;
    }

}
