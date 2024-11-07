package model.space;

import controller.Input;
import model.hero.item.Item;
import model.market.Market;
import model.user.hero.Hero;
import model.user.hero.HeroGroup;

/**
 *
 */
public class MarketSpaceActivity implements SpaceActivity {
    private Market market;

    /**
     *
     */
    public MarketSpaceActivity(Market market) {
        this.market = market;
    }

    /**
     * When heros enter the space, some actions are caused.
     *
     * @param heroGroup the group of hero.
     * @param space     the space entered
     */
    public void action(HeroGroup heroGroup, Space space) {
        System.out.println("\nHeros enter a market place.");

        heroGroup.setAtMarket(true);
        heroGroup.setSpace(space);
    }

    public void marketMenu(HeroGroup heroGroup) {
        for (Hero hero : heroGroup) {
            marketMenu(hero);
        }
    }

    private void marketMenu(Hero hero) {
        System.out.println("\nHero " + hero.getName() + "'s turn(b-buy, s-sell, q-cancel).");
        char control = Input.enterChar("bsq");
        if (control == 'b') {
            // buy
            buy(hero);
        } else if (control == 's') {
            // sell
            sell(hero);
        }
    }

    /**
     * @param hero
     */
    private void buy(Hero hero) {
        if (market.size() == 0) {
            hero.notifyMessage("The market is empty.");
            return;
        }

        while (true) {
            market.display();
            System.out.println("0. Quit");
            int choice = Input.enterInt("Your choice", 0, market.size());

            if (choice > 0) {
                if (market.getItem(choice - 1).getPrice() <= hero.getGold()) {

                    Item item = market.removeItem(choice - 1);
                    if (item.getLevel() <= hero.getLevel()) {
                        hero.getInventory().addItem(item);
                        hero.reduceGold(item.getPrice());
                        hero.notifyMessage("Hero " + hero.getName() + " bought a " + item.getName());

                        break;
                    } else {
                        System.out.println("Your level is too low.");
                    }
                } else {
                    System.out.println("Your gold is not enough!");
                }
            } else {
                break;
            }
        }
    }

    /**
     * @param hero
     */
    private void sell(Hero hero) {
        if (hero.getInventory().size() == 0) {
            hero.notifyMessage("Your inventory is empty.");
            return;
        }

        while (true) {
            hero.getInventory().display();
            System.out.println("0. Quit");
            int choice = Input.enterInt("Your choice", 0, market.size());

            if (choice > 0) {
                Item item = hero.getInventory().removeItem(choice - 1);
                market.addItem(item);
                hero.addGold(item.getPrice() / 2);
                hero.notifyMessage("Hero " + hero.getName() + " sold a " + item.getName() + " and got "
                        + (item.getPrice() / 2) + " gold.");

                break;
            } else {
                break;
            }
        }
    }
}
