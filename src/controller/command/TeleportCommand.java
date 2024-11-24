package controller.command;

import java.util.List;
import model.World;
import model.space.Space;
import model.user.hero.Hero;

/**
 * The Move command.To implement the teleport for heroes.
 */
public class TeleportCommand extends KeyboardCommand {
    private Hero hero;
    private World world;

    /**
     * Constructor.
     *
     * @param hero
     */
    public TeleportCommand(Hero hero, World world) {
        this.hero = hero;
        this.world = world;
    }

    /**
     * Run command.
     */
    @Override
    public boolean runCommand() {
        List<Hero> targetHeros = world.getHeros();
        targetHeros.remove(hero);

        Hero targetHero = select(targetHeros);

        int row = targetHero.getSpace().getRow();
        int col = targetHero.getSpace().getCol();
        int col1 = (col / 3) * 3;
        int col2 = col1 + 1;
        int row2 = row + 1;

        // 3 possible positions
        // (row, col1) (row, col2), the two position in same row
        // (row2, col), the space behind the target hero
        Space space1 = world.getSpace(row, col1);
        Space space2 = world.getSpace(row, col2);
        Space space3 = world.getSpace(row2, col);

        if (space1 != null && space1.getHero() == null) {
            hero.setSpace(space1);
            System.out.println("Hero " + hero.getName() + " teleport to another nexus.");
            return true;
        }

        if (space2 != null && space2.getHero() == null) {
            hero.setSpace(space2);
            System.out.println("Hero " + hero.getName() + " teleport to another nexus.");
            return true;
        }

        if (space3 != null && space3.getHero() == null) {
            hero.setSpace(space3);
            System.out.println("Hero " + hero.getName() + " teleport to another nexus.");
            return true;
        }

        System.out.println("Hero " + hero.getName() + " failed to teleport.");
        return false;
    }

}
