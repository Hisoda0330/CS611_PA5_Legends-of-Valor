package model;

import static controller.Color.BLACK;
import static controller.Color.BLUE;
import static controller.Color.CYAN;
import static controller.Color.GREEN;
import static controller.Color.PURPLE;
import static controller.Color.RED;
import static controller.Color.RESET;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.market.Market;
import model.space.PlainSpaceActivity;
import model.space.Space;
import model.space.SpaceFactory;
import model.user.hero.Hero;
import model.user.hero.HeroFactory;
import model.user.monster.Monster;
import model.user.monster.MonsterFactory;

import controller.Color.*;
/**
 * Represents the game model.
 */
public class World {
    private int nextMonsterId = 1;

    private Space[][] map; // 8*8 20% inaccessible spaces, 30% market spaces, and 50% common spaces.
    private Market[] markets; // 8 markets, every nexus has one market

    private List<Hero> heros;
    private List<Monster> monsters;
    private boolean heroWin;
    private boolean monsterWin;
    private boolean gameover;

    /**
     * Creates a new game model.
     */
    public World() {

        // set map
        map = new Space[8][8];

        SpaceFactory factory = new SpaceFactory(this);

        // add nexus
        map[0][0] = factory.createSpace(0, 0, "Nexus");
        map[0][1] = factory.createSpace(0, 1, "Nexus");
        map[0][3] = factory.createSpace(0, 3, "Nexus");
        map[0][4] = factory.createSpace(0, 4, "Nexus");
        map[0][6] = factory.createSpace(0, 6, "Nexus");
        map[0][7] = factory.createSpace(0, 7, "Nexus");

        map[7][0] = factory.createSpace(7, 0, "Nexus");
        map[7][1] = factory.createSpace(7, 1, "Nexus");
        map[7][3] = factory.createSpace(7, 3, "Nexus");
        map[7][4] = factory.createSpace(7, 4, "Nexus");
        map[7][6] = factory.createSpace(7, 6, "Nexus");
        map[7][7] = factory.createSpace(7, 7, "Nexus");

        // add impassible
        for (int i = 0; i < 8; i++) {
            map[i][2] = factory.createSpace(i, 2, "Impassible");
            map[i][5] = factory.createSpace(i, 5, "Impassible");
        }

        // randomly generate spaces
        List<int[]> positions = new ArrayList<int[]>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == null) {
                    positions.add(new int[] { i, j });
                }
            }
        }

        // shuffle the positions
        Collections.shuffle(positions);

        int numSpecial = (int) (positions.size() * 0.2);

        // add obstacle
        for (int i = 0; i < 3; i++) {
            int[] position = positions.remove(0);
            map[position[0]][position[1]] = factory.createSpace(position[0], position[1], "Obstacle");
        }

        // add bush
        for (int i = 0; i < numSpecial; i++) {
            int[] position = positions.remove(0);
            map[position[0]][position[1]] = factory.createSpace(position[0], position[1], "Bush");
        }

        // add cave
        for (int i = 0; i < numSpecial; i++) {
            int[] position = positions.remove(0);
            map[position[0]][position[1]] = factory.createSpace(position[0], position[1], "Cave");
        }

        // add koulou
        for (int i = 0; i < numSpecial; i++) {
            int[] position = positions.remove(0);
            map[position[0]][position[1]] = factory.createSpace(position[0], position[1], "Koulou");
        }

        // add plain
        while (positions.size() > 0) {
            int[] position = positions.remove(0);
            map[position[0]][position[1]] = factory.createSpace(position[0], position[1], "Plain");
        }

        // setup markets
        markets = new Market[] { new Market(), new Market(), new Market(), new Market(), new Market(), new Market(),
                new Market(), new Market() };

        // set heros
        heros = new ArrayList<Hero>();
        heros.add((Hero) new HeroFactory().createUser());
        heros.add((Hero) new HeroFactory().createUser());
        heros.add((Hero) new HeroFactory().createUser());
        heros.get(0).setSpace(map[7][0]);
        heros.get(1).setSpace(map[7][3]);
        heros.get(2).setSpace(map[7][6]);
        heros.get(0).setLabel(GREEN + "H1"+ RESET);
        heros.get(1).setLabel(CYAN + "H2"+ RESET); 
        heros.get(2).setLabel(PURPLE + "H3" + RESET);

        // set monsters
        monsters = new ArrayList<Monster>();
        monsters.add((Monster) new MonsterFactory(1).createUser());
        monsters.add((Monster) new MonsterFactory(1).createUser());
        monsters.add((Monster) new MonsterFactory(1).createUser());
        monsters.get(0).setSpace(map[0][1]);
        monsters.get(1).setSpace(map[0][4]);
        monsters.get(2).setSpace(map[0][7]);
        monsters.get(0).setLabel(RED+"M1"+RESET);
        monsters.get(1).setLabel(RED+"M2"+RESET);
        monsters.get(2).setLabel(RED+"M3"+RESET);
        nextMonsterId = 4;
    }

    public void addThreeNewMonsters() {
        int level = getMaxLevelOfHeros();

        if (map[0][1].getMonster() == null) {
            Monster monster = (Monster) new MonsterFactory(level).createUser();
            monsters.add(monster);
            monster.setSpace(map[0][1]);
            monster.setLabel("M" + (nextMonsterId++));

            System.out.println("Monster " + monster.getLabel() + " is spawned");
        }

        if (map[0][4].getMonster() == null) {
            Monster monster = (Monster) new MonsterFactory(level).createUser();
            monsters.add(monster);
            monster.setSpace(map[0][4]);
            monster.setLabel("M" + (nextMonsterId++));

            System.out.println("Monster " + monster.getLabel() + " is spawned");
        }

        if (map[0][7].getMonster() == null) {
            Monster monster = (Monster) new MonsterFactory(level).createUser();
            monsters.add(monster);
            monster.setSpace(map[0][7]);
            monster.setLabel("M" + (nextMonsterId++));

            System.out.println("Monster " + monster.getLabel() + " is spawned");
        }
    }

    /**
     * Set the gameover.
     *
     * @param gameover the gameover to set
     */
    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }

    /**
     * Get the gameover.
     *
     * @return the gameover
     */
    public boolean isGameover() {
        return gameover;
    }

    /**
     * Get the heros.
     *
     * @return the heros
     */
    public List<Hero> getHeros() {
        return new ArrayList<Hero>(heros);
    }

    /**
     * Get the monsters.
     *
     * @return the monsters
     */
    public List<Monster> getMonsters() {
        return new ArrayList<Monster>(monsters);
    }

    /**
     *
     */
    public void beforeTurn() {
        System.out.println();

        for (Hero hero : heros) {
            if (hero.getHp() <= 0) {
                hero.respawn();
            }
        }
    }

    /**
     *
     */
    public void endTurn() {
        System.out.println();

        for (Hero hero : heros) {
            if (hero.getHp() > 0) {
                hero.regainHPMP();

                if (hero.getSpace().getRow() == 0) {
                    setHeroWin();
                }
            }
        }

        for (Monster monster : monsters) {
            if (monster.getSpace().getRow() == 7) {
                setMonsterWin();
            }
        }
    }

    /**
     * Get the markets.
     *
     * @return the markets
     */
    public Market[] getMarkets() {
        return markets;
    }

    public int getMaxLevelOfHeros() {
        int maxLevel = 0;
        for (Hero hero : heros) {
            if (hero.getLevel() > maxLevel) {
                maxLevel = hero.getLevel();
            }
        }
        return maxLevel;
    }

    @Override
    public String toString() {

        String str = "";

        for (int i = 0; i < 8; i++) {
            String s1 = "";
            String s2 = "";

            for (int j = 0; j < 8; j++) {
                Space space = map[i][j];
                char symbol = space.getSymbol();
                s1 += symbol + " - " + symbol + " - " + symbol + "   ";
                s2 += "| ";

                if (symbol == 'I') {
                    s2 += BLACK+"X X X "+RESET;
                } else {
                    if (space.getHero() != null) {
                        s2 += space.getHero().getLabel();
                    } else {
                        s2 += "  ";
                    }

                    s2 += " ";
                    if (space.getMonster() != null) {
                        s2 += space.getMonster().getLabel();
                        if (space.getMonster().getLabel().length() < 3) {
                            s2 += " ";
                        }
                    } else {
                        s2 += "   ";
                    }
                }

                s2 += "|   ";
            }
            str += s1 + "\n" + s2 + "\n" + s1 + "\n\n";
        }
        return str.trim();
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

    /**
     * @param monster
     */
    public void monsterDead(Monster monster) {
        monsters.remove(monster);
        monster.getSpace().setMonster(null);

        int monsterLevel = monster.getLevel();
        for (Hero hero : heros) {
            hero.addGold(monsterLevel * 500);
            hero.increaseExprience(2 * monsterLevel);
        }
    }

    /**
     * Get the monsters in range.
     *
     * @param position the hero's position
     * @return monsters in range.
     */
    public List<Monster> getMonstersInRange(Coordinate position) {
        List<Monster> monsters = new ArrayList<Monster>();

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                Space space = getSpace(position.getRow() + dr, position.getCol() + dc);
                if (space != null && space.getMonster() != null) {
                    monsters.add(space.getMonster());
                }
            }
        }
        return monsters;
    }

    /**
     * Get the heros in range.
     *
     * @param position the monster's position
     * @return heros in range.
     */
    public List<Hero> getHerosInRange(Coordinate position) {
        List<Hero> heros = new ArrayList<Hero>();
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                Space space = getSpace(position.getRow() + dr, position.getCol() + dc);
                if (space != null && space.getHero() != null) {
                    heros.add(space.getHero());
                }
            }
        }
        return heros;
    }

    /**
     * Set the heroWin.
     *
     * @param heroWin the heroWin to set
     */
    public void setHeroWin() {
        this.heroWin = true;
        gameover = true;
    }

    /**
     * Set the monsterWin.
     *
     * @param monsterWin the monsterWin to set
     */
    public void setMonsterWin() {
        this.monsterWin = true;
        gameover = true;
    }

    /**
     * Get the heroWin.
     *
     * @return the heroWin
     */
    public boolean isHeroWin() {
        return heroWin;
    }

    /**
     * Get the monsterWin.
     *
     * @return the monsterWin
     */
    public boolean isMonsterWin() {
        return monsterWin;
    }

    /**
     * @param row
     * @param col
     */
    public void setPlainSpace(int row, int col) {
        map[row][col] = new Space(row, col, "Plain", new PlainSpaceActivity());
    }

    public boolean hasMonsterInSameRow(int row, int col) {
        // set col as the left column of lane
        col = col / 3;
        col = col * 3;

        int col2 = col + 1;

        return getSpace(row, col).getMonster() != null || getSpace(row, col2).getMonster() != null;
    }

    public boolean hasHeroInSameRow(int row, int col) {
        // set col as the left column of lane
        col = col / 3;
        col = col * 3;

        int col2 = col + 1;

        return getSpace(row, col).getHero() != null || getSpace(row, col2).getHero() != null;
    }

}
