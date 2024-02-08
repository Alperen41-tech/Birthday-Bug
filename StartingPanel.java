import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;




public class StartingPanel extends JPanel {
    


    JButton startButton;


    public StartingPanel(){

        setLayout(new BorderLayout());

        JLabel label = new JLabel("Welcome to 'Escape the Bug Game' ");

        //((JComponent) label).setFont(new Font("Arial", Font.BOLD, 20)); // Example custom font and size
        label.setHorizontalAlignment(SwingConstants.CENTER);

        startButton = new JButton("Click to start the game");
        

        add(label, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);

    }


    public void setActionListenerForButton(ActionListener listener){
        startButton.addActionListener(listener);
    }


    public void setInvisible(){
        setVisible(false);
    }

}
