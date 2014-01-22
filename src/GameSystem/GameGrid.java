package GameSystem;

import SharedSystem.IGGListener;
import java.util.ArrayList;
import java.util.List;

public abstract class GameGrid {
    private int[][] grid;
    private int rows;
    private int columns;
    private List<IGGListener> listeners = new ArrayList();
    
    public GameGrid(int columns, int rows) {
        grid = new int[rows][columns];
        this.columns = columns;
        this.rows = rows;
    }
    
    public abstract MoveResult makeMove(Move move);
    public abstract GameResult getResult();
    
    public void setMarker(int x, int y, int id) {
        grid[y][x] = id;
    }
    
    public int getMarker(int x, int y) {
        return grid[y][x];
    }
    
    public int getWidth() {
        return columns;
    }
    
    public int getHeight() {
        return rows;
    }
    
    public void notifyListeners(int x, int y, int id) {
        for(IGGListener listener : listeners)
            listener.updateMove(x, y, id);
    }
    
    public void registerListener(IGGListener listener) {
        listeners.add(listener);
    }
    
    public void unregisterListener(IGGListener listener) {
        listeners.remove(listener);
    }
    
    public void unregisterAllListeners() {
        listeners.clear();
    }
}
