package controller.command;

import model.ValorWorld;

/**
 * The Quit command.When user presses "Q".
 */
public class QuitCommand extends KeyboardCommand {
    private ValorWorld world;

    public QuitCommand(ValorWorld world) {
        this.world = world;
    }

    @Override
    public boolean runCommand() {
        world.setGameover(true);
        System.out.println("\nBye!");
        return true;
    }

}
