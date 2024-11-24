package controller.command;

import java.util.List;

import model.hero.item.potion.Potion;
import model.user.hero.Hero;

/**
 * The Move command.
 */
public class UsePotionCommand extends KeyboardCommand {
    private Hero hero;

    /**
     * Constructor.
     *
     * @param hero
     */
    public UsePotionCommand(Hero hero) {
        this.hero = hero;
    }

    /**
     * Run command.
     */
    @Override
    public boolean runCommand() {
        List<Potion> potions = hero.getInventory().getPotions();
        if (potions.isEmpty()) {
            hero.notifyMessage("You have no potion in inventory.");
            return false;
        }

        usePotion(hero);
        return true;
    }

    private boolean usePotion(Hero hero) {
        List<Potion> potions = hero.getInventory().getPotions();

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

}
