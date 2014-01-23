package GameSystem;

public class GameResult {
    public static final int PLAYER_1_WON = 0;
    public static final int PLAYER_2_WON = 1;
    public static final int DRAW = 2;
    public static final int NO_OUTCOME = 3;
    public static final int INVALID = 4;
    
    private int result;
    private String name1 = "";
    private String name2 = "";
        
    public GameResult(int result) {
        this.result = result;
    }
    
    public void setResult(int result) {
        this.result = result;
    }
    
    public void setNames(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }
    
    public String getName1() {
        return name1;
    }
    
    public String getName2() {
        return name2;
    }
        
    public int getResult() {
        return result;
    }
}
