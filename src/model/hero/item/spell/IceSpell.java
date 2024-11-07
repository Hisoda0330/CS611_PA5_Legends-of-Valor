package model.hero.item.spell;

import model.user.hero.Hero;
import model.user.monster.Monster;

/**
 *
 */
public class IceSpell extends Spell {

    public IceSpell(String name, int price, int level, int damage, int cost) {
        super(name, price, level, damage, cost);
    }

    @Override
    public void magicAttack(Hero hero, Monster monster) {
        super.magicAttack(hero, monster);
        if (monster.isDefeated()) {
            return;
        }

        String text = "Also, the spell reduce the damage of monster by " + monster.decreaseDamage(0.1) + " points!";
        hero.notifyMessage(text.trim());
    }
}
