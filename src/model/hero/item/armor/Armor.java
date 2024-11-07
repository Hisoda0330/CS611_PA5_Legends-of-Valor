package model.hero.item.armor;

import model.hero.item.Item;

/**
 * Represents an armor.
 */
public class Armor extends Item implements DefenseAble {
    private int damageReduction;

    /**
     * @param name
     * @param price
     * @param level
     */
    public Armor(String name, int price, int level, int damageReduction) {
        super(name, price, level);
        this.damageReduction = damageReduction;
    }

    @Override
    public String toString() {
        return String.format("Armor, %s, Damage Reduction: %d", super.toString(), damageReduction);
    }

    @Override
    public int getDamageReduction() {
        return damageReduction;
    }

    @Override
    public boolean isUseable() {
        return true;
    }

}
