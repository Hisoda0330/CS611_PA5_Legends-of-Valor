package model.user.hero;

import java.util.ArrayList;
import java.util.List;

import model.hero.item.Item;
import model.hero.item.armor.Armor;
import model.hero.item.potion.Potion;
import model.hero.item.spell.Spell;
import model.hero.item.weapon.Weapon;

/**
 *
 */
public class Inventory {
    private List<Item> items;

    /**
     *
     */
    public Inventory() {
        items = new ArrayList<Item>();
    }

    @Override
    public String toString() {
        String text = "Inventory: " + "\n";
        for (Item item : items) {
            text += item.toString() + "\n";
        }

        if (items.isEmpty()) {
            return "No items in Inventory.";
        }

        return text.trim();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int size() {
        return items.size();
    }

    public Item get(int index) {
        return items.get(index);
    }

    /**
     *
     */
    public void display() {
        System.out.println("\nYour inventory.");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).toString());
        }
    }

    public Item removeItem(int index) {
        return items.remove(index);
    }

    public List<Potion> getPotions() {
        List<Potion> list = new ArrayList<Potion>();
        for (Item item : items) {
            if (item instanceof Potion) {
                list.add((Potion) item);
            }
        }
        return list;
    }

    public List<Spell> getSpells() {
        List<Spell> list = new ArrayList<Spell>();
        for (Item item : items) {
            if (item instanceof Spell) {
                list.add((Spell) item);
            }
        }
        return list;
    }

    public List<Armor> getArmors() {
        List<Armor> list = new ArrayList<Armor>();
        for (Item item : items) {
            if (item instanceof Armor) {
                list.add((Armor) item);
            }
        }
        return list;
    }

    public List<Weapon> getWeapons() {
        List<Weapon> list = new ArrayList<Weapon>();
        for (Item item : items) {
            if (item instanceof Weapon) {
                list.add((Weapon) item);
            }
        }
        return list;
    }

    /**
     * @param selected
     */
    public void removeItem(Item selected) {
        items.remove(selected);
    }
}
