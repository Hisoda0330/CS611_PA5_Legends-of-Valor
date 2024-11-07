package model.user.hero;

/**
 * The interface for skill increase strategy.
 */
public interface HeroIncreaseStrategy {
    /**
     * Increase the skill of a hero when level up.
     *
     * @param hero the hero to level up.
     */
    void increaseSkill(Hero hero);
}
