package controller.command;

import java.util.List;

import controller.Input;

/**
 * The interface for all keyboard commands.
 */
public abstract class KeyboardCommand {

    /**
     * Run command.
     */
    public abstract boolean runCommand();

    public <T> T select(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).toString());
        }
        System.out.println("0. Cancel");

        int choice = Input.enterInt("Your choice", 0, list.size());
        if (choice == 0) {
            return null;
        }

        return list.get(choice - 1);
    }

}
