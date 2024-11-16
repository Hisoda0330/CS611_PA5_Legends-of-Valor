package model.Cell;
//This is an abstract class that represent the area cannot be assessed.

public class Inaccessible extends Cell {

    public Inaccessible(int [] position) {
        super('X',false,position);
        type="Inaccessible";
    }
}
