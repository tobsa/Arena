package GuiSystem;

import GameSystem.GameResult;
import SharedSystem.SharedConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ResultDialog extends JDialog implements SharedConstants {
    private JButton okButton = new JButton("OK");
    
    public ResultDialog(JFrame parent, GameResult result) {
        setLayout(new BorderLayout());
        
        okButton.addActionListener(new ButtonOKListener());
        
        String message = "";
        if(result.getResult() == GameResult.PLAYER_1_WON)
            message = result.getName1() + " has won!";
        if(result.getResult() == GameResult.PLAYER_2_WON)
            message = result.getName2() + " has won!";
        if(result.getResult() == GameResult.DRAW)
            message = "A draw between " + result.getName1() + " and " + result.getName2() + "!";
                
        JPanel resultPanel = new JPanel();
        resultPanel.add(new JLabel(message));
        resultPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
        
        add(resultPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        
        pack();
        
        setTitle("Game Result");
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setVisible(true);
    }
    
    private class ButtonOKListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            dispose();
        }
    }
}
