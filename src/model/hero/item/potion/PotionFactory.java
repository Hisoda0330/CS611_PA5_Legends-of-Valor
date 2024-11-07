package model.hero.item.potion;

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
public class PotionFactory implements ItemFactory {

    List<Potion> potions = new ArrayList<Potion>();

    /**
     * Creates a ArmorFactory.
     */
    public PotionFactory() {
        // load file
        loadFile();
    }

    @Override
    public Item createItem() {
        if (potions.size() == 0) {
            loadFile();
        }

        return potions.remove(0);
    }

    /**
     *
     */
    private void loadFile() {
        try {
            String pathname = Constants.DATA_PATH + File.separator + "Potions.txt";
            List<String[]> tokenList = FileLoader.loadFileLines(pathname);
            for (String[] tokens : tokenList) {
                // Name/cost/required level/attribute increase/attribute affected
                // Healing_Potion 250 1 100 Health
                // Strength_Potion 200 1 75 Strength
                // Magic_Potion 350 2 100 Mana
                // Luck_Elixir 500 4 65 Agility
                // Mermaid_Tears 850 5 100 Health/Mana/Strength/Agility
                // Ambrosia 1000 8 150 All Health/Mana/Strength/Dexterity/Defense/Agility

                String name = tokens[0];
                int price = Integer.parseInt(tokens[1]);
                int level = Integer.parseInt(tokens[2]);
                int increase = Integer.parseInt(tokens[3]);
                String affected = tokens[4];

                List<Integer> types = new ArrayList<Integer>();
                if (affected.contains("Health") || affected.contains("All")) {
                    types.add(Potion.HP);
                }
                if (affected.contains("Mana") || affected.contains("All")) {
                    types.add(Potion.MP);
                }
                if (affected.contains("Strength") || affected.contains("All")) {
                    types.add(Potion.STRENGTH);
                }
                if (affected.contains("Dexterity") || affected.contains("All")) {
                    types.add(Potion.DEXTERITY);
                }
                if (affected.contains("Agility") || affected.contains("All")) {
                    types.add(Potion.AGILITY);
                }

                int[] array = new int[types.size()];
                for (int i = 0; i < array.length; i++) {
                    array[i] = types.get(i);
                }
                potions.add(new Potion(name, price, level, array, increase));
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
