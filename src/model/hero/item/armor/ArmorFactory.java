package model.hero.item.armor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import model.Constants;
import model.FileLoader;
import model.hero.item.Item;
import model.hero.item.ItemFactory;

/**
 * Factory of Weapon.
 */
public class ArmorFactory implements ItemFactory {
    List<Armor> armors = new ArrayList<Armor>();

    /**
     * Creates a ArmorFactory.
     */
    public ArmorFactory() {
        // load file
        loadFile();
    }

    private void loadFile() {
        try {
            String pathname = Constants.DATA_PATH + File.separator + "Armory.txt";
            List<String[]> tokenList = FileLoader.loadFileLines(pathname);
            for (String[] tokens : tokenList) {
                // Name/cost/required level/damage reduction
                // Platinum_Shield 150 1 200
                String name = tokens[0];
                int price = Integer.parseInt(tokens[1]);
                int level = Integer.parseInt(tokens[2]);
                int damageReduction = Integer.parseInt(tokens[3]);

                armors.add(new Armor(name, price, level, damageReduction));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Item createItem() {
        if (armors.size() == 0) {
            loadFile();
        }

        return armors.remove(0);
    }

}
