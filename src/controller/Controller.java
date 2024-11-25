package controller;

import model.World;
import model.space.Space;
import model.space.activity.MarketSpaceActivity;
import model.user.UserFactory;
import model.user.hero.Hero;
import model.user.hero.HeroFactory;
import model.user.hero.HeroGroup;

/**
 *Implement main game controller, manages game world, hero creation, movement controls, and commands of game.
 * Also plays music and observe message for display.
 */
public class Controller implements MessageObserver, IController {

    /** The game world. */
    private World world;
    private static final String RED    = "\u001B[31m";    // RED
    private static final String RESET  = "\u001B[0m";     // Text Reset
    private static final String YELLOW = "\u001B[33m";    // YELLOW

    /**
     * create heros.
     */
    private void createHeroParty() {
        int size = Input.enterInt("Enter the size of hero party", 1, 3);

        UserFactory heroFactory = new HeroFactory();
        HeroGroup heroGroup = new HeroGroup(size, heroFactory);
        for (Hero hero : heroGroup) {
            hero.registerMessageObserver(this);
        }
        world = new World(heroGroup);
    }

    public void play() {
        MusicPlayer.play();

        createHeroParty();

        while (true) {
            System.out.println(world.toString());

            String validCommands = "wasdqi";
            if (world.getHeroGroup().isAtMarket()) {
                validCommands += "m";
            }

            char control = Input.enterChar(validCommands);

            if ("wasd".contains("" + control)) {
                move(control);

                if (world.getHeroGroup().allDefeated()) {
                    break;
                }
            } else if (control == 'q') {
                System.out.println("\nBye!");
                break;
            } else if (control == 'i') {
                System.out.println("\n" + world.getHeroGroup().toString());
            } else if (control == 'm') {
                MarketSpaceActivity marketSpaceActivity = (MarketSpaceActivity) world.getHeroGroup().getSpace()
                        .getActivity();
                marketSpaceActivity.marketMenu(world.getHeroGroup());
            }

            System.out.println();
        }

        MusicPlayer.stop();
    }
    private void move(char control) {
        // move up
        Space space = world.getHeroGroup().getSpace();
        int row = space.getRow();
        int col = space.getCol();

        int nextRow = row;
        int nextCol = col;

        if (control == 'w') {
            nextRow--;
        }
        if (control == 's') {
            nextRow++;
        }
        if (control == 'a') {
            nextCol--;
        }
        if (control == 'd') {
            nextCol++;
        }

        Space nextSpace = world.getSpace(nextRow, nextCol);
        if (nextSpace == null) {
            System.out.println("\nCannot go out of the world!");
        } else {
            nextSpace.action(world.getHeroGroup());
        }
    }

    /**
     * Show welcome info.
     */
    public void showGameInfo() {
        String text = "";
        text += "\n"+ YELLOW+"Welcome to game \"Monsters and Heroes\":"+RESET + "\n";

        text += RED+"In a mystery dungeon where is full of darkness reigns, and monstrous creatures—dragons, armored exoskeletons, and elusive spirits—terrorize.\n" + //
                        "A legendary team of heroes sets forth from all around the league to break the ancient curse, each armed with powers: the Warrior, Sorcerer, and \n" + //
                        "the Paladin comes together with incredible powers.\n" + //
                        "\n" + //
                        "The heroes brave treacherous zones, battling monsters at every turn. Along the way, they find hidden markets to buy potions, weapons, spells, and armor essential" + //
                        "for survival. Each different monster in the evil dungeon tests their skills uniquely—dragons breathe fire, exoskeletons have near-unbreakable armor, and spirits dodge" + //
                        "and disappear, requiring both strategy and courage.\n" + //
                        "\n" + //
                        "With each victory, the heroes grow stronger, preparing for the ultimate confrontation with the dark force behind the evil curse in the dungeon. \n" + //
                        "Together, they strive to defeat it and restore peace to the land.\n" + //
                        "\n"+ RESET
                        ;


        text += "\n"+ YELLOW+"GAME INFO:"+RESET + "\n";
        text += RED + "*"+ RESET + " is the location of hero's party " + "\n";
        text += "$ is the location of shop" + "\n";
        text += "# is not accessible" + "\n";
        text += ". is common area where possibly encounter monster" + "\n";

        text += "\n"+ YELLOW+"HOW TO MOVE:"+RESET + "\n";
        text += "W/w: move up" + "\n";
        text += "A/a: move left" + "\n";
        text += "S/s: move down" + "\n";
        text += "D/d: move right" + "\n";
        text += "Q/q: quit game" + "\n";
        text += "I/i: show information" + "\n";
        text += "M/m: enter market" + "\n";


        System.out.println(text);
    }

    @Override
    public void handleMessage(String message) {
        System.out.println(message);
    }
}
