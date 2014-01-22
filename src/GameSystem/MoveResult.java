package GameSystem;

public class MoveResult {
    public static final int PASS = 0;
    public static final int MOVE = 1;
    
    private int result;
    
    public MoveResult(int result) {
        this.result = result;
    }
    
    public int getResult() {
        return result;
    }
}
