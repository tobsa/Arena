package Othello;

import javax.swing.ImageIcon;

public class OthelloGameBoard extends GuiSystem.GameBoard {
    private ImageIcon empty = new ImageIcon(OTHELLO_IMAGE_EMPTY);
    private ImageIcon black = new ImageIcon(OTHELLO_IMAGE_BLACK);
    private ImageIcon white = new ImageIcon(OTHELLO_IMAGE_WHITE);
    
    public OthelloGameBoard() {
        super(OTHELLO_GRID_SIZE, OTHELLO_GRID_SIZE, OTHELLO_IMAGE_SIZE);
    }
    
    @Override
    public void updateMove(int x, int y, int id) {
        switch(id) {
            case PLAYER_EMPTY:
                setIcon(x, y, empty);
                break;
            case PLAYER_1:
                setIcon(x, y, black);
                break;
            case PLAYER_2:
            setIcon(x, y, white);
                break;
        }
    }
}
