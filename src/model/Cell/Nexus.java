package model.Cell;

import java.io.IOException;

//Nexus is a cell as the start place of heroes and monsters, also the market place for heroes.
//When a heroes or monsters reach the cells by another side, they are the winner.
public class Nexus extends Accessible{
    public Nexus( int[] position) throws IOException {

        super('N', position, "Nexus");
    }
}
