package controller.command;

import model.World;

/**
 * The Move command.
 */
public class QuitCommand extends KeyboardCommand {
    private World world;

    public QuitCommand(World world) {
        this.world = world;
    }

    /**
     * Run command.
     */
    @Override
    public boolean runCommand() {
        world.setGameover(true);
        System.out.println("\nBye!");
        return true;
    }

}
