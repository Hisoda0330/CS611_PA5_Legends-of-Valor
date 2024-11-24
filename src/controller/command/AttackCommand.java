package controller.command;

import java.util.List;

import controller.Input;
import model.Dice;
import model.World;
import model.user.hero.Hero;
import model.user.monster.Monster;

/**
 * The Move command. Class to represent the attack.
 */
public class AttackCommand extends KeyboardCommand {
    private Hero hero;

    private World world;

    public AttackCommand(Hero hero, World world) {
        this.hero = hero;

        this.world = world;
    }

    /**
     * Run command.
     */
    @Override
    public boolean runCommand() {
        List<Monster> monsters = world.getMonstersInRange(hero.getSpace().getPosition());

        if (monsters.isEmpty()) {
            System.out.println("No monster in range.");
            return false;
        }

        for (int i = 0; i < monsters.size(); i++) {
            System.out.println((i + 1) + ". " + monsters.get(i).toString());
        }
        int index = Input.enterInt("Select a monster to attack", 1, monsters.size());
        Monster monster = monsters.get(index - 1);


        System.out.println("\nHero " + hero.getName() + "  vs  " + "Monster " + monster.getName());
        System.out.println(hero.toString());
        System.out.println(monster.toString());

        heroAttack(hero, monster);

        if (monster.isDefeated()) {
            world.monsterDead(monster);
        }

        return true;
    }

    private boolean heroAttack(Hero hero, Monster monster) {
        double dodgeChange = monster.getDodge() / 100.0;
        if (!Dice.occur(dodgeChange)) {
            int attackDamage = (int) ((hero.getStrength() + hero.getWeaponDamage()) * 0.05);
            hero.notifyMessage("Hero " + hero.getName() + "'s attack damage is " + attackDamage);
            hero.notifyMessage("Monster " + monster.getName() + "'s defense is " + monster.getDefense());

            int realDamage = attackDamage - monster.getDefense();
            if (realDamage < 0) {
                realDamage = 0;
            }

            monster.receiveDamage(realDamage);
            hero.notifyMessage("Hero " + hero.getName() + " attacked Monster " + monster.getName() + " for "
                    + realDamage + " damage!");
            if (monster.isDefeated()) {
                hero.notifyMessage("Monster " + monster.getName() + " was defeated.");
            }
        } else {
            hero.notifyMessage("Monster " + monster.getName() + " dodged Hero " + hero.getName() + "'s attack.");
        }

        return true;
    }

}
