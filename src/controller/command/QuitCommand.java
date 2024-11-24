package controller.command;

import model.World;

/**
 * The Move command. The class can let the game quit immediately when the player press "Q"
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
