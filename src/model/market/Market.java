package model.market;

import java.util.ArrayList;
import java.util.List;

import model.hero.item.Item;

/**
 *
 */
public class Market {
    private List<Item> items;

    public Market() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int size() {
        return items.size();
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public Item removeItem(int index) {
        return items.remove(index);
    }

    public void display() {
        System.out.println("\nWelcome to Market.");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).toString());
        }
    }
}
