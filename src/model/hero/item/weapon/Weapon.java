package model.hero.item.weapon;

import model.hero.item.Item;

/**
 * Represents a Weapon.
 */
public class Weapon extends Item implements AttackAble {
    /** the damage value of weapon */
    private int damage;

    /** the number of hands required to use it, 1 or 2 */
    private int hands;

    /**
     * Creates a weapon.
     *
     * @param name
     * @param price
     * @param level
     * @param damage
     * @param hands
     */
    public Weapon(String name, int price, int level, int damage, int hands) {
        super(name, price, level);
        this.damage = damage;
        this.hands = hands;
    }

    @Override
    public String toString() {
        return String.format("Weapon, %s, Damage: %d, Hands: %d", super.toString(), damage, hands);
    }

    /**
     * Get the hands.
     *
     * @return the hands
     */
    public int getHands() {
        return hands;
    }

    /**
     * Check if this item is useable or not.
     *
     * @return true if this item is useable, false otherwise.
     */
    public boolean isUseable() {
        return true;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
