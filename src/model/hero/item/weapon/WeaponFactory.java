package model.hero.item.weapon;

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
public class WeaponFactory implements ItemFactory {
    List<Weapon> weapons = new ArrayList<Weapon>();

    /**
     * Creates a ArmorFactory.
     */
    public WeaponFactory() {
        // load file
        loadFile();
    }

    @Override
    public Item createItem() {
        if (weapons.size() == 0) {
            loadFile();
        }

        return weapons.remove(0);
    }

    /**
     *
     */
    private void loadFile() {
        try {
            String pathname = Constants.DATA_PATH + File.separator + "Weaponry.txt";
            List<String[]> tokenList = FileLoader.loadFileLines(pathname);
            for(String[] tokens: tokenList) {
                //Name/cost/level/damage/required hands
                //Sword           500     1    800    1

                String name = tokens[0];
                int price = Integer.parseInt(tokens[1]);
                int level = Integer.parseInt(tokens[2]);
                int damage = Integer.parseInt(tokens[3]);
                int hands = Integer.parseInt(tokens[4]);

                weapons.add(new Weapon(name, price, level, damage, hands));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
