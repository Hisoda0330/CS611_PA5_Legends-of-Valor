package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.market.MarketFactory;
import model.market.RandomMarketFactory;
import model.space.CommonSpaceActivity;
import model.space.InaccessibleSpaceActivity;
import model.space.MarketSpaceActivity;
import model.space.Space;
import model.user.hero.HeroGroup;

/**
 * Represents the game model.
 */
public class World {
    private static final String RED    = "\u001B[31m";    // RED
    private static final String RESET  = "\u001B[0m";     // Text Reset

    private Space[][] map; // 8*8 20% inaccessible spaces, 30% market spaces, and 50% common spaces.
    private HeroGroup heroGroup;

    /**
     * Creates a new game model.
     */
    public World(HeroGroup heroGroup) {
        map = new Space[8][8];
        this.heroGroup = heroGroup;

        // randomly generate spaces
        List<int[]> positions = new ArrayList<int[]>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                positions.add(new int[] { i, j });
            }
        }

        // shuffle the positions
        Collections.shuffle(positions);
        int numInaccessibles = (int) (64 * 0.2);
        int numMarkets = (int) (64 * 0.3);
        int numCommons = 64 - numInaccessibles - numMarkets;

        for (int i = 0; i < numInaccessibles; i++) {
            int[] position = positions.remove(0);
            map[position[0]][position[1]] = new Space(position[0], position[1], "Inaccessible",
                    new InaccessibleSpaceActivity());
        }


        for (int i = 0; i < numMarkets; i++) {
            int[] position = positions.remove(0);

            MarketFactory marketFactory = new RandomMarketFactory();
            map[position[0]][position[1]] = new Space(position[0], position[1], "Market",
                    new MarketSpaceActivity(marketFactory.createMarket()));
        }

        for (int i = 0; i < numCommons; i++) {
            int[] position = positions.remove(0);
            map[position[0]][position[1]] = new Space(position[0], position[1], "Common", new CommonSpaceActivity());
        }

        heroGroup.setSpace(map[0][0]);
        if (map[0][0].getType().equalsIgnoreCase("market")) {
            heroGroup.setAtMarket(true);
        }
    }

    @Override
    public String toString() {

        String str = "";
        for (int j = 0; j < getWidth(); j++) {
            str += "----";
        }
        str += "-\n";

        for (int i = 0; i < getHeight(); i++) {
            str += '|';
            for (int j = 0; j < getWidth(); j++) {
                char sign = '.';
                if (map[i][j].getType().equals("Inaccessible")) {
                    sign = '#';
                }
                if (map[i][j].getType().equals("Market")) {
                    sign = '$';
                }

                str += " " + sign;
                if (heroGroup.getSpace() == map[i][j]) {
                    str += RED +'*'+ RESET;
                } else {
                    str += ' ';
                }

                str += '|';
            }
            str += "\n";

            for (int j = 0; j < getWidth(); j++) {
                str += "----";
            }
            str += "-\n";
        }

        return str;
    }

    /**
     * Get the heroGroup.
     *
     * @return the heroGroup
     */
    public HeroGroup getHeroGroup() {
        return heroGroup;
    }

    public Space getSpace(int row, int col) {
        if (!(row >= 0 && row < getHeight() && col >= 0 && col < getWidth())) {
            return null;
        }

        return map[row][col];
    }

    public int getWidth() {
        return map[0].length;
    }

    public int getHeight() {
        return map.length;
    }
}
