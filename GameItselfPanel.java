import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameItselfPanel extends JPanel{
    



    Component cars_and_obstacles;

    Timer timer = new Timer(100, new timer_listener());
    JLabel counter;

    JLabel label = new JLabel("Tebrikler kazandınız, sonuçlarınızı görmek için tıklayın");
    JButton button = new JButton("Tıkla!");

    public GameItselfPanel(){

        counter = new JLabel();

        
        add(counter, BorderLayout.NORTH);



        cars_and_obstacles = new Component();

        add(cars_and_obstacles, BorderLayout.CENTER);

        timer.start();

        label.setVisible(false);
        button.setVisible(false);
    
        setFocusable(true);

        


    }

    


    /**
     * InnerGameItselfPanel
     */
    public class timer_listener implements ActionListener {

        private double count_down;

        public timer_listener(){
            count_down = 16;
        }
        
        public void actionPerformed(ActionEvent e) {
            cars_and_obstacles.moveTo();
            
            

            if (!cars_and_obstacles.isAlive()){
                timer.stop();
                cars_and_obstacles.setVisible(false);

                JButton button = new JButton("You lost, try again?");
                count_down = 15;
                add(button, BorderLayout.CENTER);
                button.addActionListener(new button_list(button));
                
            }

            counter.setText((int) count_down +"");
            count_down -= 0.1;



            if ((int)count_down == 0){
                timer.stop();
                cars_and_obstacles.setVisible(false);

                counter.setVisible(false);
                label.setVisible(true);
                button.setVisible(true);
                
                button.addActionListener(new button_list2());
                //setLayout(new GridLayout(1,3));
                add(label);
                add(button);

            }
            

        }

        public double getSecond(){
            return count_down;
        }
    }


    public class button_list implements ActionListener {

        JButton button;

        public button_list(JButton button){
            this.button = button;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            timer.start();
            cars_and_obstacles.setVisible(true);
            button.setVisible(false);
        }
    
        
    }


    public class button_list2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("clicked");
            label.setVisible(false);
            button.setVisible(false);


            JLabel label_2 = new JLabel("Yeni Yaşın Hayırlı Olsun Elif,");
            JLabel label_3 = new JLabel("Nice Mutlu Yıllara");
            JLabel label_4 = new JLabel("Doğum Günün Kutlu Olsun :))");
            JLabel label_5 = new JLabel("İnşallah hep mutlu olursun... :)");


            Font font = new Font("Comic Sans MS", Font.BOLD, 30); // You can change "Arial" to any font you prefer
            label_2.setFont(font);
            label_3.setFont(font);
            label_4.setFont(font);
            label_5.setFont(font);
            add(label_2);
            add(label_3);
            add(label_4);
            add(label_5);
        }
        
    }









}
