package model.hero.item.potion;

import model.hero.item.Item;
import model.user.hero.Hero;

/**
 * Represents a potion.
 */
public class Potion extends Item implements EnhanceAble {
    public static final int HP = 0;
    public static final int MP = 2;
    public static final int STRENGTH = 4;
    public static final int DEXTERITY = 8;
    public static final int AGILITY = 16;

    private int[] types;
    private int effectAmount;
    private boolean used;

    public Potion(String name, int price, int level, int[] types, int effectAmount) {
        super(name, price, level);
        this.types = types;
        this.effectAmount = effectAmount;
    }

    // Health/Mana/Strength/Dexterity/Defense/Agility
    @Override
    public String toString() {
        String attributes = "";
        for (int type : types) {
            if (type == HP) {
                attributes += "Health" + "/";
            }
            if (type == MP) {
                attributes += "Mana" + "/";
            }
            if (type == STRENGTH) {
                attributes += "Strength" + "/";
            }
            if (type == DEXTERITY) {
                attributes += "Dexterity" + "/";
            }
            if (type == AGILITY) {
                attributes += "Agility" + "/";
            }
        }

        attributes = attributes.substring(0, attributes.length() - 1);
        return String.format("Potion, %s, Effective Amount: %d, Attribute Affected: %s", super.toString(), effectAmount,
                attributes);
    }

    @Override
    public boolean isUseable() {
        return !used;
    }

    @Override
    public void enhance(Hero hero) {
        used = true;

        for (int type : types) {
            switch (type) {
            case HP:
                hero.potionForHP(effectAmount);
                break;
            case MP:
                hero.potionForMP(effectAmount);
                break;
            case STRENGTH:
                hero.potionForStrength(effectAmount);
                break;
            case DEXTERITY:
                hero.potionForDexterity(effectAmount);
                break;
            case AGILITY:
                hero.potionForAgility(effectAmount);
                break;
            default:
                break;
            }
        }
    }
}
