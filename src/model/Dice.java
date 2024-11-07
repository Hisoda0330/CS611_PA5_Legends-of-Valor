package model;

import java.util.Random;

/**
 * The dice object for various probabilities.
 */
public class Dice {
    public static Random random = new Random();

    /**
     * Rolling the dice and check if a event happens or not.
     *
     * @param probability the probability of event
     * @return true if the event happens, otherwise returns false.
     */
    public static boolean occur(double probability) {
        return random.nextDouble() < probability;
    }

    /**
     * Return true if battle occurs.
     *
     * @return true if battle occurs, false otherwise.
     */
    public static boolean battle() {
        return occur(Constants.BATTLE_PROB);
    }
}
