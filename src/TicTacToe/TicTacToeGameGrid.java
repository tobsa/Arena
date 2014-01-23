package TicTacToe;

import GameSystem.GameResult;
import GameSystem.Move;

public class TicTacToeGameGrid extends GameSystem.GameGrid {
    
    public TicTacToeGameGrid() {
        super(TIC_TAC_TOE_GRID_SIZE, TIC_TAC_TOE_GRID_SIZE);
    }
    
    @Override
    public int makeMove(Move move) {
        setMarker(move.getX(), move.getY(), move.getID());
        
        notifyListeners(move.getX(), move.getY(), move.getID());
        
        return move.getAction();
    }

    @Override
    public GameResult getResult() {
        GameResult result = new GameResult(GameResult.NO_OUTCOME);
        
        if(getMarker(2, 2) == PLAYER_1)
            result.setResult(GameResult.PLAYER_1_WON);
        
        return result;
    }

    @Override
    public void clear() {
        for(int y = 0; y < getHeight(); y++) {
            for(int x = 0; x < getWidth(); x++) {
                setMarker(x, y, PLAYER_EMPTY);
                notifyListeners(x, y, PLAYER_EMPTY);
            }
        }
    }
}
