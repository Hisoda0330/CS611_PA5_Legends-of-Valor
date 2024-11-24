package controller.command;

import java.util.List;

import model.Dice;
import model.World;
import model.user.hero.Hero;
import model.user.monster.Monster;

/**
 * The Move command.The class related to attack.
 */
public class MonsterAttackCommand extends KeyboardCommand {
    private Monster monster;
    private World world;

    public MonsterAttackCommand(Monster monster, World world) {
        this.monster = monster;
        this.world = world;
    }

    /**
     * Run command.
     */
    @Override
    public boolean runCommand() {
        List<Hero> heros = world.getHerosInRange(monster.getSpace().getPosition());
        if (heros.isEmpty()) {
            return false;
        }

        Hero hero = heros.get((int) (Math.random() * heros.size()));

        System.out.println("\nMonster " + monster.getName() + "  vs  " + "Hero " + hero.getName());
        System.out.println(monster.toString());
        System.out.println(hero.toString());

        monsterAttack(hero, monster);
        return true;
    }

    /**
     * @param hero
     * @param monster
     */
    private boolean monsterAttack(Hero hero, Monster monster) {
        double dodgeChange = hero.getAgility() * 0.002 / 100.0;

        if (!Dice.occur(dodgeChange)) {
            int attackDamage = monster.getDamage();

            hero.notifyMessage("Monster " + monster.getName() + "'s attack damage is " + attackDamage);
            hero.notifyMessage("Hero " + hero.getName() + "'s defense is " + hero.getDefense());

            int realDamage = attackDamage - hero.getDefense();
            if (realDamage < 0) {
                realDamage = 0;
            }

            hero.receiveDamage(realDamage);
            hero.notifyMessage("Monster " + monster.getName() + " attacked Hero " + hero.getName() + " for "
                    + realDamage + " damage!");
            if (hero.isDefeated()) {
                System.out.println("Hero " + hero.getName() + " was defeated.");
            }
        } else {
            System.out.println("Hero " + hero.getName() + " dodged Monster " + monster.getName() + "'s attack.");
        }

        return true;
    }
}
