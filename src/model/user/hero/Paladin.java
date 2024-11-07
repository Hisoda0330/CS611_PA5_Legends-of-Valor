package model.user.hero;

/**
 * Represents a hero.
 */
public class Paladin extends Hero {

    // Name/mana/strength/agility/dexterity/starting money/starting experience
    public Paladin(String name, int mp, int strength, int agility, int dexterity, int money, int experience) {
        super(name, mp, strength, agility, dexterity, money, experience, new PaladinSkillIncreaseStrategy());
    }

}
