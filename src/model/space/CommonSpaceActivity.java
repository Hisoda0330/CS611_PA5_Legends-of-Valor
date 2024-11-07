package model.space;

import java.util.Iterator;
import java.util.List;

import controller.Input;
import model.Dice;
import model.hero.item.armor.Armor;
import model.hero.item.potion.Potion;
import model.hero.item.spell.Spell;
import model.hero.item.weapon.Weapon;
import model.user.hero.Hero;
import model.user.hero.HeroGroup;
import model.user.monster.Monster;
import model.user.monster.MonsterFactory;
import model.user.monster.MonsterGroup;

/**
 * Represents an Activity of CommonSpace.
 */
public class CommonSpaceActivity implements SpaceActivity {

    /**
     * When heros enter the space, some actions are caused.
     *
     * @param heroGroup the group of hero.
     * @param space     the space entered
     */
    public void action(HeroGroup heroGroup, Space space) {
        heroGroup.setSpace(space);
        heroGroup.setAtMarket(false);

        System.out.println("\nYour enter a common space.");
        if (!Dice.battle()) {
            System.out.println("Fortunately, no battle took place.");
        } else {
            System.out.println("Unfortunately, you encountered a group of monsters.");

            MonsterGroup monsterGroup = generateMonsterGroup(heroGroup);

            for (Hero hero : heroGroup) {
                hero.beforeBattle();
            }

            int round = 1;
            while (!heroGroup.allDefeated() && !monsterGroup.allDefeated()) {
                System.out.println("\n------------------Round " + round + ":");
                System.out.println(heroGroup);
                System.out.println();
                System.out.println(monsterGroup);

                battle(heroGroup, monsterGroup);
                round++;
            }

            if (heroGroup.allDefeated()) {
                System.out.println("All heros fained, game is over.");
            } else {

                int monsterLevel = monsterGroup.iterator().next().getLevel();

                // add experience and gold
                Iterator<Hero> iterator = heroGroup.getBattleMembers();
                while (iterator.hasNext()) {
                    Hero notFainedHero = iterator.next();
                    notFainedHero.addGold(monsterLevel * 100);
                    notFainedHero.increaseExprience(monsterGroup.size() * 2);
                }

                for (Hero hero : heroGroup) {
                    hero.afterBattle();
                }
            }
        }
    }

    /**
     * One round of battle.
     */
    private void battle(HeroGroup heroGroup, MonsterGroup monsterGroup) {
        Iterator<Hero> heros = heroGroup.getBattleMembers();
        Iterator<Monster> monsters = monsterGroup.getBattleMembers();

        while (heros.hasNext() && monsters.hasNext()) {
            battle(heros.next(), monsters.next());
        }

        // At the end of each round (after the monsters' turn), heroes that have not
        // fainted regain some of their HP and mana.
        heros = heroGroup.getBattleMembers();
        while (heros.hasNext()) {
            heros.next().regainHPMP();
        }
    }

    private void battle(Hero hero, Monster monster) {
        while (!hero.isDefeated() && !monster.isDefeated()) {
            while (true) {
                System.out.println("\nHero " + hero.getName() + "  vs  " + "Monster " + monster.getName());
                System.out.println("b-battle, i-info");
                char choice = Input.enterChar("bi");
                if (choice == 'b') {
                    System.out.println("a-attack, c-spell, p-potion, w-equip weapon, r-equip armor");
                    choice = Input.enterChar("acpwr");

                    boolean done = false;
                    if (choice == 'a') {
                        done = heroAttack(hero, monster);
                    }
                    if (choice == 'c') {
                        done = castSpell(hero, monster);
                    }
                    if (choice == 'p') {
                        done = usePotion(hero, monster);
                    }
                    if (choice == 'w') {
                        done = equipWeapon(hero);
                    }
                    if (choice == 'r') {
                        done = equipArmor(hero);
                    }

                    if (done) {
                        break;
                    }
                } else {
                    System.out.println(hero.toString());
                    System.out.println(monster.toString());
                }
            }

            // monster attack.
            monsterAttack(hero, monster);
        }
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

    private boolean castSpell(Hero hero, Monster monster) {
        List<Spell> spells = hero.getInventory().getSpells();
        if (spells.isEmpty()) {
            hero.notifyMessage("You have no spell in inventory.");
            return false;
        }

        Spell selected = select(spells);
        if (selected == null) {
            return false;
        }

        selected.magicAttack(hero, monster);
        if (!selected.isUseable()) {
            hero.getInventory().removeItem(selected);
        }

        return true;
    }

    private boolean usePotion(Hero hero, Monster monster) {
        List<Potion> potions = hero.getInventory().getPotions();
        if (potions.isEmpty()) {
            hero.notifyMessage("You have no potion in inventory.");
            return false;
        }

        Potion selected = select(potions);
        if (selected == null) {
            return false;
        }

        selected.enhance(hero);
        if (!selected.isUseable()) {
            hero.getInventory().removeItem(selected);
        }
        return true;
    }

    private boolean equipWeapon(Hero hero) {
        List<Weapon> weapons = hero.getInventory().getWeapons();
        if (weapons.isEmpty()) {
            hero.notifyMessage("You have no weapon in inventory.");
            return false;
        }

        Weapon selected = select(weapons);
        if (selected == null) {
            return false;
        }

        hero.equipWeapon(selected);
        return true;
    }

    private boolean equipArmor(Hero hero) {
        List<Armor> armors = hero.getInventory().getArmors();
        if (armors.isEmpty()) {
            hero.notifyMessage("You have no armor in inventory.");
            return false;
        }

        Armor selected = select(armors);
        if (selected == null) {
            return false;
        }

        hero.equipArmor(selected);
        return true;
    }

    private <T> T select(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).toString());
        }
        System.out.println("0. Cancel");

        int choice = Input.enterInt("Your choice", 0, list.size());
        if (choice == 0) {
            return null;
        }

        return list.get(choice - 1);
    }

    private MonsterGroup generateMonsterGroup(HeroGroup heroGroup) {
        MonsterGroup monsterGroup = new MonsterGroup();

        // get max level of heros.
        int maxLevel = 0;
        for (Hero hero : heroGroup) {
            if (hero.getLevel() > maxLevel) {
                maxLevel = hero.getLevel();
            }
        }
        MonsterFactory monsterFactory = new MonsterFactory(maxLevel);

        for (int i = 0; i < heroGroup.size(); i++) {

            monsterGroup.add((Monster) monsterFactory.createUser());
        }
        return monsterGroup;
    }
}
