package GameSystem;

import SharedSystem.SharedConstants;

public class Move implements SharedConstants {
    private int x;
    private int y;
    private int id;
    private int action;
    
    public Move() {
        action = ACTION_PASS;
    }
     
    public Move(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
        action = ACTION_MOVE;
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
