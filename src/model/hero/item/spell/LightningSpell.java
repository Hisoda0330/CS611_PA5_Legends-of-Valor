package model.hero.item.spell;

import model.user.hero.Hero;
import model.user.monster.Monster;

/**
 *
 */
public class LightningSpell extends Spell {

    public LightningSpell(String name, int price, int level, int damage, int cost) {
        super(name, price, level, damage, cost);
    }

    @Override
    public void magicAttack(Hero hero, Monster monster) {
        super.magicAttack(hero, monster);
        if (monster.isDefeated()) {
            return;
        }

        String text = "Also, the spell reduce the dodge of monster by " + monster.decreaseDodge(0.1) + " points!";
        hero.notifyMessage(text.trim());
    }
}
