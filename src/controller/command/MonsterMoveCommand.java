package controller.command;

import model.ValorWorld;
import model.space.Space;
import model.user.monster.Monster;

/**
 * The Move command for monster.
 */
public class MonsterMoveCommand extends KeyboardCommand {
    private Monster monster;
    private ValorWorld world;
    private char direction;


    public MonsterMoveCommand(Monster monster, ValorWorld world, char direction) {
        this.monster = monster;
        this.world = world;
        this.direction = direction;
    }

    @Override
    public boolean runCommand() {
        // move up
        Space space = monster.getSpace();

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
            return false;
        } else if ("IO".contains(nextSpace.getSymbol() + "")) {
            // next space is obstacle or impassible
            return false;
        } else if (direction == 's'
                && world.hasHeroInSameRow(monster.getSpace().getRow(), monster.getSpace().getCol())) {
            // System.out.println("\nCannot move behind a hero without killing it!");
            return false;
        } else {
            monster.setSpace(nextSpace);
            return true;
        }
    }
}
