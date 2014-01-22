package Arena;

import GuiSystem.ArenaFrame;
import javax.swing.JFrame;

public class Arena {
    public static void main(String[] args) {
        ArenaFrame frame = new ArenaFrame();
        frame.setTitle("Arena");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
