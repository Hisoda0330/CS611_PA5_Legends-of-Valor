package model.Cell;

//The abstract class to represent the cell.Superclass of the following classes.
public abstract class Cell {

    protected char Symbol;
    protected boolean reachable;
    protected int [] position;
    protected String type;

    protected Cell(char symbol,boolean reachable,int [] position) {
        this.Symbol = symbol;
        this.reachable = reachable;
        this.position = position;
    }

    public char getSymbol() {
        return Symbol;
    }
    public char getIcon(){
        return Symbol;
    }
    public int[ ] getPosition(){
        return position;
    }

    public String getType(){
        return type;
    }
}
