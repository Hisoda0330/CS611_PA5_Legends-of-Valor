package model.user.monster;

import model.space.Space;
import model.user.User;

/**
 *
 */
public class Monster extends User {
    private int damage;
    private int defense;
    private int dodge;

    public Monster(String name, int level, int damage, int defense, int dodge) {
        super(name, level);

        this.damage = damage;
        this.defense = defense;
        this.dodge = dodge;
    }

    @Override
    public String toString() {
        String text = "";
        text += "Monster " + getName() + "\n";
        text += String.format("%-12s%-12s%-12s%-12s%-12s\n", "Level", "HP", "Damage", "Defense", "Dodge");

        text += String.format("%-12s%-12s%-12s%-12s%-12s\n", "" + getLevel(), "" + getHp(), "" + getDamage(),
                "" + getDefense(), String.format("%d%%", dodge));
        return text.trim();
    }

    @Override
    public void setSpace(Space space) {
        if (getSpace() != null) {
            getSpace().setMonster(null);
        }
        super.setSpace(space);
        space.setMonster(this);
    }

    /**
     * Get the damage.
     *
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Get the defense.
     *
     * @return the defense
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Get the dodge.
     *
     * @return the dodge
     */
    public int getDodge() {
        return dodge;
    }

    public int decreaseDamage(double percent) {
        int amount = (int) (damage * percent);
        damage -= amount;

        if (damage < 0) {
            damage = 0;
        }
        return amount;
    }

    public int decreaseDefense(double percent) {
        int amount = (int) (defense * percent);
        defense -= amount;

        if (defense < 0) {
            defense = 0;
        }
        return amount;
    }

    public int decreaseDodge(double percent) {
        int amount = (int) (dodge * percent);
        dodge -= amount;

        if (dodge < 0) {
            dodge = 0;
        }
        return amount;
    }
}
