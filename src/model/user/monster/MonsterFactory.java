package model.user.monster;

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
public class MonsterFactory implements UserFactory {
    private int level;

    List<Monster> monsters = new ArrayList<Monster>();

    public MonsterFactory(int level) {
        this.level = level;
        loadMonsters();
    }

    public void loadMonsters() {
        // load file
        loadFile("Dragon", "Dragons.txt");
        loadFile("Exoskeleton", "Exoskeletons.txt");
        loadFile("Spirit", "Spirits.txt");

        // shuffle the list.
        Collections.shuffle(monsters);
    }

    /**
     * Load a monster file.
     */
    private void loadFile(String type, String filename) {
        try {
            String pathname = Constants.DATA_PATH + File.separator + filename;
            List<String[]> tokenList = FileLoader.loadFileLines(pathname);
            for(String[] tokens: tokenList) {
                // Name/level/damage/defense/dodge chance
                // Desghidorrah 3 300 400 35

                String name = tokens[0];
                int level = Integer.parseInt(tokens[1]);
                int damage = Integer.parseInt(tokens[2]);
                int defense = Integer.parseInt(tokens[3]);
                int dodge = Integer.parseInt(tokens[4]);

                if (type.equals("Dragon")) {
                    monsters.add(new Dragon(name, level, damage, defense, dodge));
                } else if (type.equals("Exoskeleton")) {
                    monsters.add(new Exoskeleton(name, level, damage, defense, dodge));
                } else {
                    monsters.add(new Spirit(name, level, damage, defense, dodge));
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
        while (true) {
            int index = Dice.random.nextInt(monsters.size());
            if (monsters.get(index).getLevel() == level) {
                return monsters.remove(index);
            }
        }
    }
}
