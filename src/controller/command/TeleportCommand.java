package controller.command;

import java.util.ArrayList;
import java.util.List;

import model.ValorWorld;
import model.space.Space;
import model.user.hero.Hero;

/**
 * The Move command.
 */
public class TeleportCommand extends KeyboardCommand {
    private Hero hero;
    private ValorWorld world;

    /**
     * Constructor.
     *
     * @param hero
     */
    public TeleportCommand(Hero hero, ValorWorld world) {
        this.hero = hero;
        this.world = world;
    }

    private boolean hasMonsterBehind(int row, int col) {
        col = (col / 3) * 3;
        for (int i = row; i < 8; i++) {
            for (int j = col; j < col + 2; j++) {
                Space space = world.getSpace(i, j);
                if (space.getMonster() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Run command.
     */
    @Override
    public boolean runCommand() {

        List<Hero> targetHeros = world.getHeros();

        // find minimum row
        int minRow = 7;
        for (Hero hero : targetHeros) {
            if (hero.getSpace().getRow() < minRow) {
                minRow = hero.getSpace().getRow();
            }
        }

        targetHeros.remove(hero);
        List<String> coordinates = new ArrayList<String>();
        for (Hero hero : targetHeros) {
            int col = hero.getSpace().getCol();
            col = (col / 3) * 3;

            for (int i = minRow; i < 8; i++) {
                for (int j = col; j < col + 2; j++) {
                    Space space = world.getSpace(i, j);
                    if (space.getHero() == null && !hasMonsterBehind(i, j)) {
                        coordinates.add(i + "," + j);
                    }
                }
            }
        }

        if (coordinates.isEmpty()) {
            System.out.println("No valid target space found.");
            return false;
        }

        String coord = select(coordinates);
        if(coord == null) {
            return false;
        }

        int r = Integer.parseInt(coord.split(",")[0]);
        int c = Integer.parseInt(coord.split(",")[1]);
        Space space1 = world.getSpace(r, c);
        hero.setSpace(space1);

        System.out.println("Hero " + hero.getName() + " failed to teleport.");
        return false;
    }

}
