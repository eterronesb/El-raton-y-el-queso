package sample.model;
import java.util.Scanner;
import java.util.Random;

public class PenaltyCell extends ScoreCell implements sample.model.Questionable {

    public PenaltyCell(int points) {
        super(points);
        this.content = "00";
    }

    @Override
    public String getQuestion() {
        return "Adivina un numero del 1 al 10:";
    }
    @Override
    public boolean submitAnswer(String answer) {
        Random random = new Random();
        int correctNumber = random.nextInt(10) + 1;
        return Integer.parseInt(answer) == correctNumber;
    }
}
