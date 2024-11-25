package model.space;

import model.Coordinate;
import model.ValorWorld;
import model.World;

/**
 *
 */
public class SpaceFactory {
    private World world;
    private ValorWorld ValorWorld;


    public SpaceFactory(World world) {
        this.world = world;
    }

    public Space createSpace(int row, int col, String type) {
        switch (type) {
        case "Nexus":
            return new Space(row, col, type, new NexusSpaceActivity());
        case "Impassible":
            return new Space(row, col, type, new InaccessibleSpaceActivity());
        case "Plain":
            return new Space(row, col, type, new PlainSpaceActivity());
        case "Cave":
            return new Space(row, col, type, new CaveSpaceActivity());
        case "Bush":
            return new Space(row, col, type, new BushSpaceActivity());
        case "Koulou":
            return new Space(row, col, type, new KoulouSpaceActivity());
        case "Obstacle":

            return new Space(row, col, type, new ObstacleSpaceActivity(ValorWorld, new Coordinate(row, col)));
        default:
            System.err.println("Error in SpaceFactory.");
            return null;
        }
    }
}
