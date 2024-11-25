package controller.command;

import java.util.List;

import model.hero.item.weapon.Weapon;
import model.user.hero.Hero;

/**
 * The Move command.Class for heroes to equip weapon.Presses "e"
 */
public class ChangeWeaponCommand extends KeyboardCommand {
    private Hero hero;

    public ChangeWeaponCommand(Hero hero) {
        this.hero = hero;
    }

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
