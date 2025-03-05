package sample.model;

public class EndGameCell extends GameCell{
    private EndGamecellType type;

    public EndGameCell(EndGamecellType type) {
        super(type.getSymbol());
        this.type = type;
    }

    public EndGamecellType getType() {
        return type;
    }
}
