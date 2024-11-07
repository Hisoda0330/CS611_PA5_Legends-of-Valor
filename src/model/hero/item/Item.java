package model.hero.item;

/**
 * The base class of all items.
 */
public abstract class Item {
    private String name;
    private int price;
    private int level;

    /**
     * Creates a new item.
     *
     * @param name
     * @param price
     * @param level
     */
    public Item(String name, int price, int level) {
        this.name = name;
        this.price = price;
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %d, Level: %d", name, price, level);
    }

    /**
     * Check if this item is useable or not.
     *
     * @return true if this item is useable, false otherwise.
     */
    public abstract boolean isUseable();

    /**
     * Get the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the price.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Get the level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }
}
