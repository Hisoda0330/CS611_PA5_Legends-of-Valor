package model.user;

import controller.MessageObserver;
import model.space.Space;

/**
 * The base class of hero and monster.
 */
public class User {
    private Space spawnSpace;

    private Space space;
    private String label;

    private String name;

    private int level;
    private int hp;

    private MessageObserver messageObserver;

    /**
     * Creates a new user.
     *
     * @param name  name of user
     * @param level level of user
     */
    public User(String name) {
        this(name, 1);
    }

    /**
     * Set the space.
     *
     * @param space the space to set
     */
    public void setSpace(Space space) {
        if (this.space == null) {
            spawnSpace = space;
        }

        this.space = space;
    }

    /**
     * Get the spawnSpace.
     *
     * @return the spawnSpace
     */
    public Space getSpawnSpace() {
        return spawnSpace;
    }

    /**
     * Get the space.
     *
     * @return the space
     */
    public Space getSpace() {
        return space;
    }

    /**
     * Set the hp.
     *
     * @param hp the hp to set
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Creates a new user.
     *
     * @param name  name of user
     * @param level level of user
     */
    public User(String name, int level) {
        this.name = name;
        this.level = level;
        hp = level * 100;
    }

    /**
     * Set the label.
     *
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Get the label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    public void levelUp() {
        level++;
        hp = level * 100;
    }

    public void notifyMessage(String message) {
        if (messageObserver != null) {
            messageObserver.handleMessage(message);
        }
    }

    /**
     * @param controller
     */
    public void registerMessageObserver(MessageObserver messageObserver) {
        this.messageObserver = messageObserver;
    }

    public void receiveDamage(int amount) {
        hp -= amount;
        if (hp < 0) {
            hp = 0;
        }
    }

    public void addHp(int amount) {
        hp += amount;
    }

    /**
     * Get the name.
     *
     * @return the name
     */
    public String getName() {
        if (label != null) {
            return label + "(" + name + ")";
        }
        return name;
    }

    /**
     * Get the level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Get the hp.
     *
     * @return the hp
     */
    public int getHp() {
        return hp;
    }

    public boolean isDefeated() {
        return getHp() <= 0;
    }
}
