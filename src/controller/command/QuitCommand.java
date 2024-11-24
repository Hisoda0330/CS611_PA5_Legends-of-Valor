package controller.command;

import model.ValorWorld;

/**
 * The Move command.
 */
public class QuitCommand extends KeyboardCommand {
    private ValorWorld world;

    public QuitCommand(ValorWorld world) {
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
