package model.user.monster;

import model.user.UserGroup;

/**
 *
 */
public class MonsterGroup extends UserGroup<Monster> {

    @Override
    public String toString() {
        String text = "";
        text += "\nMonsters\n";
        for (Monster monster : this) {
            text += "\n" + monster.toString() + "\n";
        }
        return text.trim();
    }

}
