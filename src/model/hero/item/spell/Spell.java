package model.hero.item.spell;

import model.hero.item.Item;
import model.user.hero.Hero;
import model.user.monster.Monster;

/**
 * Represents a spell.
 */
public abstract class Spell extends Item implements MagicAttackAble {

    private int damage;
    private int cost;

    private boolean used;

    public Spell(String name, int price, int level, int damage, int cost) {
        super(name, price, level);

        this.damage = damage;
        this.cost = cost;
    }

    @Override
    public String toString() {
        String typeStr = getClass().getSimpleName();
        return String.format("%s, %s, Damage: %d, MP Cost: %d", typeStr, super.toString(), damage, cost, typeStr);
    }

    @Override
    public void magicAttack(Hero hero, Monster monster) {
        int spellDamage = (int) (damage + (hero.getDexterity() / 10000.0) * damage);

        monster.receiveDamage(spellDamage);

        String text = "Hero " + hero.getName() + " used " + getName() + " and the monster " + monster.getName()
                + "received " + spellDamage + " damage!" + "\n";

        if (monster.isDefeated()) {
            text += "Monster " + monster.getName() + " is defeated!\n";
        }
        hero.notifyMessage("\n" + text.trim());
    }

    @Override
    public boolean isUseable() {
        return !used;
    }

    /**
     * Get the cost.
     *
     * @return the cost
     */
    public int getMPCost() {
        return cost;
    }
}
