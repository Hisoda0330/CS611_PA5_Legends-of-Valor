package controller.command;

import java.util.List;

import model.hero.item.armor.Armor;
import model.user.hero.Hero;

/**
 * The Move command.
 */
public class ChangeArmorCommand extends KeyboardCommand {
    private Hero hero;

    /**
     * Constructor.
     *
     * @param hero
     */
    public ChangeArmorCommand(Hero hero) {
        this.hero = hero;
    }

    /**
     * Run command.
     */
    @Override
    public boolean runCommand() {
        return equipArmor(hero);
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

}
