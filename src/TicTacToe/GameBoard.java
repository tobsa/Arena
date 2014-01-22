package TicTacToe;

import SharedSystem.SharedConstants;
import javax.swing.ImageIcon;

public class GameBoard extends GuiSystem.GameBoard implements SharedConstants {
    private ImageIcon empty  = new ImageIcon(TIC_TAC_TOE_IMAGE_EMPTY);
    private ImageIcon cross  = new ImageIcon(TIC_TAC_TOE_IMAGE_CROSS);
    private ImageIcon circle = new ImageIcon(TIC_TAC_TOE_IMAGE_CIRCLE);
    
    public GameBoard() {
        super(TIC_TAC_TOE_GRID_SIZE, TIC_TAC_TOE_GRID_SIZE, TIC_TAC_TOE_IMAGE_SIZE);
    }
    
    @Override
    public void updateMove(int x, int y, int id) {
        switch(id) {
            case PLAYER_EMPTY:
                setIcon(x, y, empty);
                break;
            case PLAYER_1:
                setIcon(x, y, cross);
                break;
            case PLAYER_2:
            setIcon(x, y, circle);
                break;
        }
    }
}
