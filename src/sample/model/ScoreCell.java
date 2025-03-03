package sample.model;

public class ScoreCell extends sample.model.GameCell {
    private int points;

    public ScoreCell(int points){
        super("..");
        this.points=points;
    }
    public int getPoints(){
        return points;
    }
}
