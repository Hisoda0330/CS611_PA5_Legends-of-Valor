package controller.command;

import model.ValorWorld;
import model.user.hero.Hero;
import model.user.monster.Monster;

/**
 * The class to show the information:when pressed the i, SHOW the information of heroes and monsters.
 */
public class InfoCommand extends KeyboardCommand {
    private ValorWorld world;

    public InfoCommand(ValorWorld world) {
        this.world = world;
    }

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
