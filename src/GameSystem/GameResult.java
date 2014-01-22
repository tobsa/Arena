package GameSystem;

public class GameResult {
    public static final int WINNER = 0;
    public static final int DRAW = 1;
    public static final int NO_OUTCOME = 2;
    
    private int result;
    private int winnerID;
    
    public GameResult() {
        result = NO_OUTCOME;
    }
    
    public GameResult(int result) {
        this.result = result;
    }
    
    public GameResult(int result, int winnerID) {
        this.result = result;
        this.winnerID = winnerID;
    }
    
    public int getResult() {
        return result;
    }
    
    public int getWinner() {
        return winnerID;
    }
    
    public void setResult(int result) {
        this.result = result;
    }
    
    public void setWinner(int winnerID) {
        this.winnerID = winnerID;
    }
}
