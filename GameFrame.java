
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
    


    StartingPanel startingScreen;
    GameItselfPanel game;

   


    public GameFrame(){

        startingScreen = new StartingPanel();
        


        setResizable(false);

        setSize(750,500);
        setTitle("Escape The Bug");

        setLocation(200, 100);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setFocusable(true);
        setVisible(true);

        startingScreen.setActionListenerForButton(new startingButtonListener());
        
        add(startingScreen);

    }



    class startingButtonListener implements ActionListener{

        
        public void actionPerformed(ActionEvent e) {
            ((StartingPanel) startingScreen).setInvisible();
            game = new GameItselfPanel();
            add(game);
        }
        
    }

    public void setPanel(JPanel panel){
        add(panel);
    }



    public static void main(String[] args) {
        

        JFrame frame = new GameFrame();

        

        

    }




}
