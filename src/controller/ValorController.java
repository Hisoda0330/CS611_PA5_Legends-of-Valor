package controller;

import controller.command.AttackCommand;
import controller.command.CastSpellCommand;
import controller.command.ChangeArmorCommand;
import controller.command.ChangeWeaponCommand;
import controller.command.HelpCommand;
import controller.command.InfoCommand;
import controller.command.KeyboardCommand;
import controller.command.MarketCommand;
import controller.command.MonsterAttackCommand;
import controller.command.MonsterMoveCommand;
import controller.command.MoveCommand;
import controller.command.QuitCommand;
import controller.command.RecallCommand;
import controller.command.TeleportCommand;
import controller.command.UsePotionCommand;
import model.ValorWorld;
import model.user.hero.Hero;
import model.user.monster.Monster;

/**
 *The controller for play the ValorController
 */
public class ValorController implements MessageObserver, IController {

    /** The game world. */
    private ValorWorld world;

    private int everyRoundsForMonster = 8; // every 8 rounds, add monster

   //The start page for the Valor
    public ValorController() {
        world = new ValorWorld();

        for (Hero hero : world.getHeros()) {
            hero.registerMessageObserver(this);
        }

        System.out.println("Select difficulity: ");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        int index = Input.enterInt("Please select", 1, 3);

        // new spawn every 6 rounds, medium: every 4 rounds, hard: every 2 rounds
        if (index == 1) {
            everyRoundsForMonster = 6;
        }
        if (index == 2) {
            everyRoundsForMonster = 4;
        }
        if (index == 3) {
            everyRoundsForMonster = 2;
        }
    }

    public void play() {
        MusicPlayer.play();

        int round = 1;

        new InfoCommand(world).runCommand();

        while (!world.isGameover()) {
            // one turn
            world.beforeTurn();

            // hero move
            for (Hero hero : world.getHeros()) {
                boolean done = false;
                while (!done && !world.isGameover()) {
                    System.out.println("\n" + hero.getLabel() + "'s turn.");
                    char control = Input.enterChar("wasdkcueotrqimh");
                    KeyboardCommand command = getCommand(hero, control);
                    done = command.runCommand();
                }
            }

            // monster move
            for (Monster monster : world.getMonsters()) {
                if (!world.isGameover()) {
                    KeyboardCommand moveCommand = new MonsterMoveCommand(monster, world, 's');
                    KeyboardCommand attackCommand = new MonsterAttackCommand(monster, world);
                    if (!attackCommand.runCommand()) {
                        // if no attacking, monster move
                        if (!moveCommand.runCommand()) {
                            System.out.println("Monster " + monster.getLabel() + " cannot move down.");
                        } else {
                            System.out.println("Monster " + monster.getLabel() + " move down.");
                        }
                    }
                }
            }

            if (!world.isGameover()) {
                // end turn
                world.endTurn();

                if (round % everyRoundsForMonster == 0) {
                    world.addThreeNewMonsters();
                }
            }

            round++;
        }

        MusicPlayer.stop();

        if (world.isHeroWin()) {
            System.out.println("Heros won!");
        } else if (world.isMonsterWin()) {
            System.out.println("Monsters won!");
        }
    }

    private KeyboardCommand getCommand(Hero hero, char control) {
        if ("wasd".contains("" + control)) {
            return new MoveCommand(hero, world, control);
        } else if (control == 'q') {
            return new QuitCommand(world);
        } else if (control == 'i') {
            return new InfoCommand(world);
        } else if (control == 'm') {
            return new MarketCommand(hero, world.getMarkets()[hero.getSpace().getCol()]);
        } else if (control == 'h') {
            return new HelpCommand();
        } else if (control == 'k') {
            return new AttackCommand(hero, world);
        } else if (control == 'c') {
            return new CastSpellCommand(hero, world);
        } else if (control == 'u') {
            return new UsePotionCommand(hero);
        } else if (control == 'e') {
            return new ChangeWeaponCommand(hero);
        } else if (control == 'o') {
            return new ChangeArmorCommand(hero);
        } else if (control == 't') {
            return new TeleportCommand(hero, world);
        } else if (control == 'r') {
            return new RecallCommand(hero);
        } else {
            System.err.println("Invalid control " + control);
            return null;
        }
    }

    /**
     * Show welcome info.
     */
    public void showGameInfo() {
        new HelpCommand().runCommand();
    }

    @Override
    public void handleMessage(String message) {
        System.out.println(message);
    }
}
