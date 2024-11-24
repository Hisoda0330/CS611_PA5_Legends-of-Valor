package controller.command;

import model.World;
import model.user.hero.Hero;
import model.user.monster.Monster;

/**
 * The Move command.Class to display the information.
 */
public class InfoCommand extends KeyboardCommand {
    private World world;

    public InfoCommand(World world) {
        this.world = world;
    }

    /**
     * Run command.
     */
    @Override
    public boolean runCommand() {
        System.out.println(world.toString() + "\n");

        System.out.println("Heros: ");
        for (Hero hero : world.getHeros()) {
            System.out.println(hero);
        }

        System.out.println("Monsters: ");
        for (Monster monster : world.getMonsters()) {
            System.out.println(monster);
        }

        return false;
    }

}
