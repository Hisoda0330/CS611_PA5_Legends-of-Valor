package model.hero.item.spell;

import model.user.hero.Hero;
import model.user.monster.Monster;

/**
 * interface for spell.
 */
public interface MagicAttackAble {
    int getMPCost();
    void magicAttack(Hero hero, Monster monster);
}
