package model.market;

import model.Dice;
import model.hero.item.ItemFactory;
import model.hero.item.armor.ArmorFactory;
import model.hero.item.potion.PotionFactory;
import model.hero.item.spell.SpellFactory;
import model.hero.item.weapon.WeaponFactory;

/**
 *
 */
public class RandomMarketFactory implements MarketFactory {
    ItemFactory[] factories = { new WeaponFactory(), new ArmorFactory(), new PotionFactory(),
            new SpellFactory() };

    @Override
    public Market createMarket() {
        Market market = new Market();
        for (int i = 0; i < 10; i++) {

            int index = Dice.random.nextInt(factories.length);
            market.addItem(factories[index].createItem());
        }
        return market;
    }

}
