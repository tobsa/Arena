package GuiSystem;

import GameSystem.Move;
import SharedSystem.BlockQueue;
import SharedSystem.IGGListener;
import SharedSystem.SharedConstants;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class GameBoard extends JPanel implements IGGListener, SharedConstants {
    private JLabel[][] grid;
    private int imageSize;
    
    public GameBoard(int columns, int rows, int imageSize) {
        grid = new JLabel[rows][columns];
        this.imageSize = imageSize;
        
        setLayout(new GridLayout(columns, rows));
        addMouseListener(new MousePressedListener());
        
        setPreferredSize(new Dimension(columns * imageSize, rows * imageSize));
                
        for(int y = 0; y < rows; y++) {
            for(int x = 0; x < columns; x++) {
                JLabel label = new JLabel();
                grid[y][x] = label;
                add(label);
            }
        }
    }
    
    public void setIcon(int x, int y, ImageIcon image) {
        grid[y][x].setIcon(image);
    }
    
    private class MousePressedListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent event) {
            int x = event.getX() / imageSize;
            int y = event.getY() / imageSize;
            
            BlockQueue.getInstance().add(new Move(x, y));
        }
    }
}
