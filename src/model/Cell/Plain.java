package model.Cell;

public class Plain extends Accessible{

    public Plain(int[] position) {
        super('P', position, "Plain");
        type="Plain";
    }
}
