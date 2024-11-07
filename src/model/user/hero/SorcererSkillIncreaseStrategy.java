package model.user.hero;

import model.Constants;

/**
 * The skill increase strategy for Sorcerer.
 */
public class SorcererSkillIncreaseStrategy implements HeroIncreaseStrategy {

    /**
     * Increase the skill of a hero when level up.
     *
     * @param hero the hero to level up.
     */
    @Override
    public void increaseSkill(Hero hero) {
        hero.increaseStrength(Constants.HERO_SKILL_INCREASE_PERCENT);
        hero.increaseAgility(Constants.HERO_SKILL_INCREASE_PERCENT + Constants.HERO_FAVORED_INCREASE_PERCENT);
        hero.increaseDexterity(Constants.HERO_SKILL_INCREASE_PERCENT + Constants.HERO_FAVORED_INCREASE_PERCENT);
    }

}
