package controller.command;

import model.ValorWorld;
import model.space.Space;
import model.user.hero.Hero;

/**
 * The Move command.
 */
public class MoveCommand extends KeyboardCommand {
    private Hero hero;
    private ValorWorld world;
    private char direction;

    /**
     * Constructor.
     *
     * @param hero
     * @param world
     * @param direction
     */
    public MoveCommand(Hero hero, ValorWorld world, char direction) {
        this.hero = hero;
        this.world = world;
        this.direction = direction;
    }

    /**
     * Run command.
     */
    @Override
    public boolean runCommand() {
        // move up
        Space space = hero.getSpace();

        int row = space.getRow();
        int col = space.getCol();

        int nextRow = row;
        int nextCol = col;

        if (direction == 'w') {
            nextRow--;
        }
        if (direction == 's') {
            nextRow++;
        }
        if (direction == 'a') {
            nextCol--;
        }
        if (direction == 'd') {
            nextCol++;
        }

        Space nextSpace = world.getSpace(nextRow, nextCol);
        if (nextSpace == null) {
            System.out.println("\nCannot go out of the world!");
            return false;
        } else if (nextSpace.getHero() != null) {
            System.out.println("\nThe next space already has one hero!");
            return false;
        } else if (direction == 'w' && world.hasMonsterInSameRow(hero.getSpace().getRow(), hero.getSpace().getCol())) {
            System.out.println("\nCannot move behind a monster without killing it!");
            return false;
        } else {
            return nextSpace.enterAction(hero, nextSpace);
        }
    }

}
