package model.space;


import model.Coordinate;
import model.World;
import model.user.hero.Hero;

/**
 * Represents an Activity of InaccessibleSpace.
 */
public class ObstacleSpaceActivity implements SpaceActivity {
    private World world;
    private Coordinate coordinate;

    /**
     * @param world
     * @param coordinate
     */
    public ObstacleSpaceActivity(World world, Coordinate coordinate) {
        this.world = world;
        this.coordinate = coordinate;
    }

    @Override
    public boolean enterAction(Hero hero, Space space) {
        System.out.println("\nHero removed an obstacle.");
        world.setPlainSpace(coordinate.getRow(), coordinate.getCol());
        return true;
    }

    @Override
    public void leftAction(Hero hero) {

    }

}