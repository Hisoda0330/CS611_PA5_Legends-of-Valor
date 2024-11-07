package controller;

import model.World;
import model.space.MarketSpaceActivity;
import model.space.Space;
import model.user.UserFactory;
import model.user.hero.Hero;
import model.user.hero.HeroFactory;
import model.user.hero.HeroGroup;

/**
 *
 */
public class Controller implements MessageObserver {

    /** The game world. */
    private World world;

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

    /**
     * @param control
     *
     */
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
        text += "Welcome to game \"Monsters and Heroes\"." + "\n";
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
