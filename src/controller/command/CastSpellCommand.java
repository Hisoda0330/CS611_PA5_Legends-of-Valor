package controller.command;

import java.util.List;

import controller.Input;
import model.World;
import model.hero.item.spell.Spell;
import model.user.hero.Hero;
import model.user.monster.Monster;

/**
 * The Move command.
 */
public class CastSpellCommand extends KeyboardCommand {
    private Hero hero;
    private World world;

    /**
     * Constructor.
     *
     * @param hero
     */
    public CastSpellCommand(Hero hero, World world) {
        this.hero = hero;
        this.world = world;
    }

    /**
     * Run command.
     */
    @Override
    public boolean runCommand() {
        List<Spell> spells = hero.getInventory().getSpells();
        if (spells.isEmpty()) {
            hero.notifyMessage("You have no spell in inventory.");
            return false;
        }

        List<Monster> monsters = world.getMonstersInRange(hero.getSpace().getPosition());

        if (monsters.size() == 0) {
            System.out.println("No monster in range.");
            return false;
        }

        for (int i = 0; i < monsters.size(); i++) {
            System.out.println((i + 1) + ". " + monsters.get(i).toString());
        }
        int index = Input.enterInt("Select a monster to cast", 1, monsters.size());
        Monster monster = monsters.get(index - 1);

        castSpell(hero, monster);

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

}
