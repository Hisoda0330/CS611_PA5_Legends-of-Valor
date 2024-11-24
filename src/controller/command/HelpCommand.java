package controller.command;
import static controller.Color.RESET;
import static controller.Color.YELLOW;
import static controller.Color.RED;
import static controller.Color.PURPLE;

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
        text += "\n";
        text += RED + "Welcome to game \"Legends of Valor\":" +RESET + "\n" ;

        text += "\n"+PURPLE +"In a land torn by war, monsters rise from their Nexus, threatening to overrun the world. From the Heroes' Nexus, \n" + //
        "a brave team of three Warrior, Sorcerer, and Paladin sets out to stop the invasion and bring peace to the land.\n" + //
        "\n" + //
        "The heroes must navigate through three perilous lanes, each filled with monsters, obstacles, and special terrain that boosts \n"+//
        "their abilities. Bushes make heroes quicker, Caves make them harder to hit, and Koulou makes them stronger." + //
        "\n" + //
        "Monsters attack relentlessly, moving closer to the Heroes' Nexus with every turn. The heroes must fight back using their weapons, \n"+//
        "spells, and teamwork. Along the way, they can buy potions, weapons, and gear to prepare for the battles ahead.\n" + //
        "\n" +//
        "The goal is simple: reach the Monsters' Nexus before the monsters reach yours. Only the strongest and smartest team will survive. \n" + //
        "Are you ready for the adventure?\n"+//
        "\n"+ RESET
        ;

        text += RED + "HOW TO PLAY:\n"+ RESET;
        text += "\n";
        text += YELLOW + "MOVEMENT:\n"+ RESET;
        text += "W/w: move up" + "\n";
        text += "A/a: move left" + "\n";
        text += "S/s: move down" + "\n";
        text += "D/d: move right" + "\n";
        text += "M/m: enter market" + "\n";
        text += "I/i: show hero/monster info" + "\n";

        text += "\n";
        text += YELLOW + "ATTACK/FIGHT:\n"+ RESET;
        text += "K/k: attack monster" + "\n";
        text += "C/c: cast spell" + "\n";
        text += "U/u: use potion" + "\n";

        text += "\n";
        text += YELLOW + "EQUIPE:\n"+ RESET;
        text += "E/e: equip weapon" + "\n";
        text += "O/o: equip armor" + "\n";

        text += "\n";
        text += YELLOW + "TP/RECALL:\n"+ RESET;
        text += "T/t: teleport" + "\n";
        text += "R/r: recall" + "\n";
        
        text += "\n";    
        text += YELLOW + "GAME INFO:\n"+ RESET;
        text += "Q/q: quit game" + "\n";
        text += "H/h: help" + "\n";

        System.out.println(text);
        return false;
    }
}