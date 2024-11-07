package model.hero.item.spell;

import model.user.hero.Hero;
import model.user.monster.Monster;

/**
 *
 */
public class FireSpell extends Spell {

    public FireSpell(String name, int price, int level, int damage, int cost) {
        super(name, price, level, damage, cost);
    }

    @Override
    public void magicAttack(Hero hero, Monster monster) {
        super.magicAttack(hero, monster);
        if (monster.isDefeated()) {
            return;
        }

        String text = "Also, the spell reduce the defense of monster by " + monster.decreaseDefense(0.1) + " points!";
        hero.notifyMessage(text.trim());
    }
}
