package model.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class UserGroup<T extends User> implements Iterable<T> {
    private List<T> users;

    public UserGroup() {
        users = new ArrayList<>();
    }

    public int size() {
        return users.size();
    }

    public boolean add(T t) {
        return users.add(t);
    }

    public boolean allDefeated() {
        return !getBattleMembers().hasNext();
    }

    public Iterator<T> getBattleMembers() {
        List<T> battleHeros = new ArrayList<T>();
        for (T t : users) {
            if (!t.isDefeated()) {
                battleHeros.add(t);
            }
        }
        return battleHeros.iterator();
    }

    @Override
    public Iterator<T> iterator() {
        return users.iterator();
    }
}
