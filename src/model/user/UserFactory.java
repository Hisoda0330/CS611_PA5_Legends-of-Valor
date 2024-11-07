package model.user;

/**
 * Factory interface.
 *
 * used for Factory Method Pattern.
 */
public interface UserFactory {

    /**
     * Creates a new user.
     *
     * @return the new user.
     */
    User createUser();
}
