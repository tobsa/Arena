package GameSystem;

import SharedSystem.SharedConstants;

public class Move implements SharedConstants {
    public static final int PASS = 0;
    public static final int MOVE = 1;
    public static final int INVALID = 2;
    
    private int x;
    private int y;
    private int id;
    private int action;
    
    public Move(int action) {
        this.action = action;
    }
    
    public Move(int x, int y) {
        this.x = x;
        this.y = y;
        this.action = MOVE;
    }
     
    public Move(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
        action = MOVE;
    }
    
    public void setID(int id) {
        this.id = id;
    }
            
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getID() {
        return id;
    }
    
    public int getAction() {
        return action;
    }
}
