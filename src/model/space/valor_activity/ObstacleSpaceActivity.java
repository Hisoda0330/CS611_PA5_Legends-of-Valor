package model.space.valor_activity;


import model.Coordinate;
import model.ValorWorld;
import model.space.Space;
import model.space.ValorSpaceActivity;
import model.user.hero.Hero;

/**
 * Represents an Activity of InaccessibleSpace.
 */
public class ObstacleSpaceActivity implements ValorSpaceActivity {
    private ValorWorld world;
    private Coordinate coordinate;

    /**
     * @param world
     * @param coordinate
     */
    public ObstacleSpaceActivity(ValorWorld world, Coordinate coordinate) {
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
