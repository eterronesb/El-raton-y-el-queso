package sample.model;

public class ScoreCell extends GameCell {
    private int points;

    public ScoreCell(int points){
        super("00");
        this.points=points;
    }
    public int getPoints(){
        return points;
    }
}
