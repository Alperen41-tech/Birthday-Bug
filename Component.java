import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Component extends JComponent{




    private int[] coordinates_ofCar = {0,275};
    private int[][] coordinates_ofObstacles;
   
    public Component(){

        


        coordinates_ofObstacles = new int[20][2];
        createCoordinates();

        addMouseMotionListener(new mouse_listener());

        
        setPreferredSize(new Dimension(750,500));
    }



    private void createCoordinates(){

        

        for (int[] c : coordinates_ofObstacles){
            c[0] = (int)(Math.random()*350) + 300;
            c[1] = (int)(Math.random()*500);
        }
    }

    

    public void moveTo(){
        for (int[] c: coordinates_ofObstacles){
            c[0] -= 5;

            if (c[0] <= 0){
                c[0] = (int)(Math.random()*100) + 550;
            }
        }
        repaint();
    }



    public void paintComponent(Graphics g){


        for (int[] c: coordinates_ofObstacles){
            g.fillRect(c[0], c[1], 10, 20);
        }


        g.setColor(Color.RED);
        g.fillRect(coordinates_ofCar[0], coordinates_ofCar[1], 30, 15);
        g.fillOval(coordinates_ofCar[0], coordinates_ofCar[1] + 15, 7, 7);
        g.fillOval(coordinates_ofCar[0] + 30, coordinates_ofCar[1] - 7, 7, 7);
        g.fillOval(coordinates_ofCar[0], coordinates_ofCar[1] - 7, 7, 7);
        g.fillOval(coordinates_ofCar[0] + 30 , coordinates_ofCar[1] + 15, 7, 7);
        

    }

    public boolean isAlive() {
        int carLeft = coordinates_ofCar[0];
        int carTop = coordinates_ofCar[1];
        int carRight = carLeft + 30;
        int carBottom = carTop + 15;
    
        for (int[] obstacle : coordinates_ofObstacles) {
            int obsLeft = obstacle[0];
            int obsTop = obstacle[1];
            int obsRight = obsLeft + 10;
            int obsBottom = obsTop + 20;
    
            if (carRight > obsLeft && carLeft < obsRight && carBottom > obsTop && carTop < obsBottom) {
                createCoordinates();
                coordinates_ofCar[0] = 0;
                coordinates_ofCar[1] = 275;
                return false; // Collision detected, car is not alive
            }
        }
    
        return true; // No collision detected, car is still alive
    }


    /**
     * InnerComponent
     */
    public class mouse_listener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            coordinates_ofCar[0] = e.getX()-30;
            coordinates_ofCar[1] = e.getY()-7;




            //System.out.println(isAlive());
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            
        }
    
        
    }








    
}
