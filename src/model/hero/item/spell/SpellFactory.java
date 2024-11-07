package model.hero.item.spell;

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
public class SpellFactory implements ItemFactory {

    List<Spell> spells = new ArrayList<Spell>();

    public SpellFactory() {
        loadFiles();
    }

    private void loadFiles() {
        // load file
        List<Spell> list1 = loadFile("IceSpell", "IceSpells.txt");
        List<Spell> list2 = loadFile("FireSpell", "FireSpells.txt");
        List<Spell> list3 = loadFile("LightningSpell", "LightningSpells.txt");

        while (list1.size() > 0 || list2.size() > 0 || list3.size() > 0) {
            if (list1.size() > 0) {
                spells.add(list1.remove(0));
            }
            if (list2.size() > 0) {
                spells.add(list2.remove(0));
            }
            if (list3.size() > 0) {
                spells.add(list3.remove(0));
            }
        }
    }

    /**
     * Load a monster file.
     */
    private List<Spell> loadFile(String type, String filename) {
        List<Spell> list = new ArrayList<Spell>();

        try {
            String pathname = Constants.DATA_PATH + File.separator + filename;
            List<String[]> tokenList = FileLoader.loadFileLines(pathname);
            for (String[] tokens : tokenList) {
                // Name/cost/required level/damage/mana cost
                // Flame_Tornado 700 4 850 300

                String name = tokens[0];
                int price = Integer.parseInt(tokens[1]);
                int level = Integer.parseInt(tokens[2]);
                int damage = Integer.parseInt(tokens[3]);
                int cost = Integer.parseInt(tokens[4]);

                if (type.equals("IceSpell")) {
                    list.add(new IceSpell(name, price, level, damage, cost));
                } else if (type.equals("FireSpell")) {
                    list.add(new FireSpell(name, price, level, damage, cost));
                } else {
                    list.add(new LightningSpell(name, price, level, damage, cost));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public Item createItem() {
        if (spells.size() == 0) {
            loadFiles();
        }

        return spells.remove(0);
    }

}
