package model.user.hero;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Constants;
import model.Dice;
import model.FileLoader;
import model.user.User;
import model.user.UserFactory;

/**
 * Factory for hero.
 */
public class HeroFactory implements UserFactory {
    List<Hero> heros = new ArrayList<Hero>();

    public HeroFactory() {
        loadHeros();
    }

    public void loadHeros() {
        // load file
        loadFile("Warrior", "Warriors.txt");
        loadFile("Sorcerer", "Sorcerers.txt");
        loadFile("Paladin", "Paladins.txt");

        // shuffle the list.
        Collections.shuffle(heros);
    }

    /**
     * Load a monster file.
     */
    private void loadFile(String type, String filename) {
        try {
            String pathname = Constants.DATA_PATH + File.separator + filename;
            List<String[]> tokenList = FileLoader.loadFileLines(pathname);
            for(String[] tokens: tokenList) {
                // Name/mana/strength/agility/dexterity/starting money/starting experience
                // Parzival 300 750 650 700 2500 7

                String name = tokens[0];
                int mp = Integer.parseInt(tokens[1]);
                int strength = Integer.parseInt(tokens[2]);
                int agility = Integer.parseInt(tokens[3]);
                int dexterity = Integer.parseInt(tokens[4]);
                int money = Integer.parseInt(tokens[5]);
                int experience = Integer.parseInt(tokens[6]);

                if (type.equals("Warrior")) {
                    heros.add(new Warrior(name, mp, strength, agility, dexterity, money, experience));
                } else if (type.equals("Sorcerer")) {
                    heros.add(new Sorcerer(name, mp, strength, agility, dexterity, money, experience));
                } else {
                    heros.add(new Warrior(name, mp, strength, agility, dexterity, money, experience));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a hero.
     *
     * @return a hero object.
     */
    @Override
    public User createUser() {
        int index = Dice.random.nextInt(heros.size());
        return heros.remove(index);
    }
}
