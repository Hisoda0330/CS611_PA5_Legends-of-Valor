package model.Cell;

public class Cave extends IncreaseCell{
    public Cave( int[] position) {
        super('C', position, "agility");
        type="Cave";
    }
}

