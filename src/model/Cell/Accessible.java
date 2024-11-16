package model.Cell;

public class Accessible extends Cell {
    protected boolean isHero;
    protected boolean isMonster;


    protected Accessible(char Symbol, int[] position, String type) {
        super(Symbol, true, position);
        this.isHero = false;
        this.isMonster = false;
    }

    @Override
    public char getSymbol() {
        if(isHero){
            return 'H';
        }
        if(isMonster){
            return 'M';
        }
        return Symbol;
    }

    public boolean setHeroSquadHere() {
        this.isHero = true;
        return this.isHero;
    }

    public boolean removeHeroSquadHere() {
        this.isHero = false;
        return this.isHero;
    }

    public boolean setMonsterSquadHere() {
        this.isMonster = true;
        return this.isHero;
    }

    public boolean removeMonsterSquadHere() {
        this.isMonster = false;
        return this.isHero;
    }

}
