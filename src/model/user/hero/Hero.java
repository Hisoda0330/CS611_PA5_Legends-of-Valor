package model.user.hero;

import model.Constants;
import model.hero.item.armor.Armor;
import model.hero.item.weapon.Weapon;
import model.space.Space;
import model.user.User;

/**
 * Represents a hero.
 */
public class Hero extends User {
    private int fullMp;

    private int experience;

    private int mp;
    private int gold;

    private int strength;
    private int dexterity;
    private int agility;
    private Inventory inventory;

    private HeroIncreaseStrategy increaseStrategy;

    private int hpBeforeBattle;
    private int mpBeforeBattle;

    private Weapon weapon1;
    private Weapon weapon2;
    private Armor armor;

    // Name/mana/strength/agility/dexterity/starting money/starting experience
    public Hero(String name, int mp, int strength, int agility, int dexterity, int money, int experience,
            HeroIncreaseStrategy increaseStrategy) {
        super(name);
        this.mp = mp;
        fullMp = mp;

        this.gold = money;

        this.strength = strength;
        this.dexterity = agility;
        this.agility = dexterity;
        this.experience = experience;

        this.increaseStrategy = increaseStrategy;
        inventory = new Inventory();
    }

    public void beforeBattle() {
        hpBeforeBattle = getHp();
        mpBeforeBattle = getMp();
    }

    public void afterBattle() {
        if (isDefeated()) {
            revive();
        }
    }

    public void revive() {
        setHp(hpBeforeBattle / 2);
        mp = mpBeforeBattle / 2;

        notifyMessage("Hero " + getName() + " revived with " + getHp() + " HP and " + mp + " MP.");
    }
    /**
     * respawn.
     */
    public void respawn() {
        System.out.println("Hero " + getName() + " respawn in the nexus space");
        setHp(getLevel() * 100);
        mp = fullMp;

        Space space = getSpawnSpace();

        if (getSpace() != null) {
            getSpace().setHero(null);
        }

        super.setSpace(space);
        space.setHero(this);
    }

    @Override
    public void setSpace(Space space) {
        if (getSpace() != null) {
            getSpace().leftAction(this);
            getSpace().setHero(null);
        }

        super.setSpace(space);
        space.setHero(this);
    }

    /**
     * Get the atMarket.
     *
     * @return the atMarket
     */
    public boolean isAtMarket() {
        return getSpace().getSymbol() == 'N';
    }

    public void regainHPMP() {
        int amount1 = (int) (getHp() * 0.1);
        int amount2 = (int) (mp * 0.1);
        addHp(amount1);
        mp += amount2;
        if (mp > fullMp) {
            fullMp = mp;
        }

        notifyMessage("Hero " + getName() + " regain " + amount1 + " HP and " + amount2 + " MP");
    }

    @Override
    public String toString() {
        String text = "";
        String type = getClass().getSimpleName();
        text += "Hero " + getName() + "(" + type + ")" + "\n";
        if (weapon1 != null) {
            String s = "";
            if (weapon1 != null) {
                s += weapon1.getName();
            }
            if (weapon2 != null) {
                s += ", " + weapon2.getName();
            }
            text += "Weapon: " + s + "\n";
        }
        if (armor != null) {
            text += "Armor: " + armor.getName() + "\n";
        }

        text += String.format("%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n", "Level", "HP", "MP", "Strength",
                "Dexterity", "Agility", "EXP", "Gold");

        text += String.format("%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n", "" + getLevel(), "" + getHp(), "" + mp,
                "" + strength, "" + dexterity, "" + agility, experience + "/" + getLevelUpExperincePoints(), gold);
        text += inventory.toString();
        return text.trim();
    }

    @Override
    public void levelUp() {
        super.levelUp();
        notifyMessage("Hero " + getName() + " level up.");
        increaseMP(Constants.MP_LEVELUP_INCREASE_PERCENT);
        this.increaseStrategy.increaseSkill(this);
    }

    public boolean isFaint() {
        return isDefeated();
    }

    public boolean increaseExprience(int amount) {
        notifyMessage("Hero " + getName() + " got " + amount + " experiences.");

        experience += amount;
        if (experience >= getLevelUpExperincePoints()) {
            while (experience >= getLevelUpExperincePoints()) {
                experience -= getLevelUpExperincePoints();
                levelUp();
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the inventory.
     *
     * @return the inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    public int getLevelUpExperincePoints() {
        return getLevel() * 10;
    }

    /**
     * Get the mp.
     *
     * @return the mp
     */
    public int getMp() {
        return mp;
    }

    /**
     * Get the gold.
     *
     * @return the gold
     */
    public int getGold() {
        return gold;
    }

    /**
     * Increase the strength by a given percent.
     *
     * @param percent the percent to increase.
     */
    public void increaseStrength(double percent) {
        int a = (int) (strength * percent);
        notifyMessage("Hero " + getName() + " increased " + a + " strength.");
        strength += a;
    }

    /**
     * Decrease the strength by a given percent.
     *
     * @param percent the percent to decrease.
     */
    public void decreaseStrength(double percent) {
        int a = (int) (strength * percent);
        notifyMessage("Hero " + getName() + " decreased " + a + " strength.");
        strength -= a;
    }

    /**
     * Increase the dexterity by a given percent.
     *
     * @param percent the percent to increase.
     */
    public void increaseDexterity(double percent) {
        int a = (int) (dexterity * percent);
        notifyMessage("Hero " + getName() + " increased " + a + " dexterity.");
        dexterity += a;
    }

    /**
     * Decrease the dexterity by a given percent.
     *
     * @param percent the percent to decrease.
     */
    public void decreaseDexterity(double percent) {
        int a = (int) (dexterity * percent);
        notifyMessage("Hero " + getName() + " decreased " + a + " dexterity.");
        dexterity -= a;
    }

    /**
     * Increase the agility by a given percent.
     *
     * @param percent the percent to increase.
     */
    public void increaseAgility(double percent) {
        int a = (int) (agility * percent);
        notifyMessage("Hero " + getName() + " increased " + a + " agility.");
        agility += a;
    }

    /**
     * Decrease the agility by a given percent.
     *
     * @param percent the percent to decrease.
     */
    public void decreaseAgility(double percent) {
        int a = (int) (agility * percent);
        notifyMessage("Hero " + getName() + " decreased " + a + " agility.");
        agility -= a;
    }

    /**
     * Increase the mp by a given percent.
     *
     * @param percent the percent to increase.
     */
    public void increaseMP(double percent) {
        int a = (int) (mp * percent);
        notifyMessage("Hero " + getName() + " increased " + a + " MP.");
        mp += a;
        if (mp > fullMp) {
            fullMp = mp;
        }

    }

    /**
     * @param effectAmount
     */
    public void potionForHP(int effectAmount) {
        addHp(effectAmount);
        notifyMessage("Hero " + getName() + "'s HP increased " + effectAmount + " by potion");
    }

    /**
     * @param effectAmount
     */
    public void potionForMP(int effectAmount) {
        mp += effectAmount;
        if (mp > fullMp) {
            fullMp = mp;
        }

        notifyMessage("Hero " + getName() + "'s MP increased " + effectAmount + " by potion");
    }

    /**
     * @param effectAmount
     */
    public void potionForStrength(int effectAmount) {
        strength += effectAmount;
        notifyMessage("Hero " + getName() + "'s strength increased " + effectAmount + " by potion");
    }

    /**
     * @param effectAmount
     */
    public void potionForDexterity(int effectAmount) {
        dexterity += effectAmount;
        notifyMessage("Hero " + getName() + "'s dexterity increased " + effectAmount + " by potion");
    }

    /**
     * @param effectAmount
     */
    public void potionForAgility(int effectAmount) {
        agility += effectAmount;
        notifyMessage("Hero " + getName() + "'s agility increased " + effectAmount + " by potion");
    }

    /**
     * Get the dexterity.
     *
     * @return the dexterity
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * Get the agility.
     *
     * @return the agility
     */
    public int getAgility() {
        return agility;
    }

    /**
     * Get the strength.
     *
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * @param price
     */
    public void reduceGold(int amount) {
        gold -= amount;
    }

    /**
     * @param i
     */
    public void addGold(int amount) {
        notifyMessage("Hero " + getName() + " got " + amount + " gold.");
        gold += amount;
    }

    public void equipArmor(Armor newArmor) {
        if (armor != null) {
            inventory.addItem(armor);
            notifyMessage("Hero " + getName() + " removed " + armor.getName());
        }

        this.armor = newArmor;
        notifyMessage("Hero " + getName() + " equipped " + newArmor.getName());
    }

    public void equipWeapon(Weapon newWeapon) {
        int nowHands = 0;
        if (weapon1 != null) {
            nowHands += weapon1.getHands();
        }
        if (weapon2 != null) {
            nowHands += weapon2.getHands();
        }

        if (newWeapon.getHands() == 2) {
            if (weapon1 != null) {
                inventory.addItem(weapon1);
                notifyMessage("Hero " + getName() + " removed " + weapon1.getName());
                weapon1 = null;
            }

            if (weapon2 != null) {
                inventory.addItem(weapon1);
                notifyMessage("Hero " + getName() + " removed " + weapon2.getName());
                weapon2 = null;
            }

            weapon1 = newWeapon;
            notifyMessage("Hero " + getName() + " equipped " + newWeapon.getName());
        } else {
            // new weapon need 1 hand
            if (nowHands == 2) {
                if (weapon1 != null) {
                    inventory.addItem(weapon1);
                    notifyMessage("Hero " + getName() + " removed " + weapon1.getName());
                    weapon1 = null;
                }

                if (weapon2 != null) {
                    inventory.addItem(weapon1);
                    notifyMessage("Hero " + getName() + " removed " + weapon2.getName());
                    weapon2 = null;
                }

                weapon1 = newWeapon;
                notifyMessage("Hero " + getName() + " equipped " + newWeapon.getName());
            } else if (nowHands == 1) {
                weapon2 = newWeapon;
                notifyMessage("Hero " + getName() + " equipped " + newWeapon.getName());
            } else {
                weapon1 = newWeapon;
                notifyMessage("Hero " + getName() + " equipped " + newWeapon.getName());
            }
        }

    }

    public int getWeaponDamage() {
        int sum = 0;

        if (weapon1 != null) {
            sum += weapon1.getDamage();
        }

        if (weapon2 != null) {
            sum += weapon2.getDamage();
        }

        return sum;
    }

    public int getDefense() {
        if (armor == null) {
            return 0;
        }
        return armor.getDamageReduction();
    }

}
