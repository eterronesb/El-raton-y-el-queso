package sample.model;
import java.util.Scanner;

public class BonusCell extends sample.model.GameCell implements sample.model.Questionable {
    private String question;
    private String[] options;
    private int corectAnwer;

    public BonusCell(int points, String question, String[] options, int corectAnwer) {
        super("00");
        this.question = question;
        this.options = options;
        this.corectAnwer = corectAnwer;
        this.content = "00";
    }


    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public boolean submitAnswer(String answer){
        return Integer.parseInt(answer) == corectAnwer;
    }
}
