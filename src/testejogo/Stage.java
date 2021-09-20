package testejogo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Stage extends JPanel
{
    
        protected static final int heigth = 300;
        protected static final int width = 600;
    
        @Override
        public void paintComponent(Graphics g)
        {   
           g.clearRect(0, 0, this.getWidth(), this.getHeight());
           g.setColor(Color.gray);
           g.fillRect(0, 0, this.getWidth(), this.getHeight());
            
        }
        
        @Override
        public int getWidth()
        {
            return width;
        }
        
        public int getHeigth()
        {
            return heigth;
        }
    
}
