package apps.andorid.sprout.project.Data;

public class CalculationGame {

    private int x;
    private int y;
    private String operator;
    private int answer;
    private int optA;
    private int optB;
    private int optC;
    private int optD;
    private int questionNumber;

    //Constructors
    public CalculationGame() {}

    public CalculationGame(int x, int y, String operator, int answer, int optA, int optB, int optC, int optD, int questionNumber) {
        this.x = x;
        this.y = y;
        this.operator = operator;
        this.answer = answer;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.optD = optD;
        this.questionNumber = questionNumber;
    }

    //Getters and Setters

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getOptA() {
        return optA;
    }

    public void setOptA(int optA) {
        this.optA = optA;
    }

    public int getOptB() {
        return optB;
    }

    public void setOptB(int optB) {
        this.optB = optB;
    }

    public int getOptC() {
        return optC;
    }

    public void setOptC(int optC) {
        this.optC = optC;
    }

    public int getOptD() {
        return optD;
    }

    public void setOptD(int optD) {
        this.optD = optD;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }
}
