package controller.command;

/**
 * The Move command.
 */
public class HelpCommand extends KeyboardCommand {

    /**
     * Run command.
     */
    @Override
    public boolean runCommand() {
        String text = "";
        text += "Welcome to game \"Legends of Valor\"." + "\n";
        text += "W/w: move up" + "\n";
        text += "A/a: move left" + "\n";
        text += "S/s: move down" + "\n";
        text += "D/d: move right" + "\n";

        text += "K/k: attack monster" + "\n";
        text += "C/c: cast spell" + "\n";
        text += "U/u: use potion" + "\n";

        text += "E/e: equip weapon" + "\n";
        text += "O/o: equip armor" + "\n";

        text += "T/t: teleport" + "\n";
        text += "R/r: recall" + "\n";

        text += "Q/q: quit game" + "\n";
        text += "I/i: show information" + "\n";
        text += "M/m: enter market" + "\n";
        text += "H/h: help" + "\n";

        System.out.println(text);
        return false;
    }

}
