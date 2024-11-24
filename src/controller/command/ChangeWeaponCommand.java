package controller.command;

import java.util.List;

import model.hero.item.weapon.Weapon;
import model.user.hero.Hero;

/**
 * The Move command.
 */
public class ChangeWeaponCommand extends KeyboardCommand {
    private Hero hero;

    /**
     * Constructor.
     *
     * @param hero
     */
    public ChangeWeaponCommand(Hero hero) {
        this.hero = hero;
    }

    /**
     * Run command.
     */
    @Override
    public boolean runCommand() {
        return equipWeapon(hero);
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
}
