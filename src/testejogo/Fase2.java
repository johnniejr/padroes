package testejogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;

public class Fase2 extends JPanel implements KeyListener
{         
        protected static final int heigth = 800;
        protected static final int width = 600;
        private SpaceShip nave;                                 
        private Image player = null;
        private Image player2 = null;
        private Shoot tiro;
        private Graphics2D g;        
        
        private Rectangle formaTiro;

        
        private int yellowBarX;
        private int redBarX;
        private int redBarWidth;
        private int pontuacao;
        private int taxa, taxa2;
        
        private String value;
        
        Enemy2[] enemies = new Enemy2[10];
        Rectangle[] formaEnemies = new Rectangle[10];
        
        public Fase2()
        {
            
            
            setFocusable(true);
            addKeyListener(this);
            nave = new SpaceShip();           
          
            for( int i =0 ; i< 10; i++)
            {
                taxa = (int)(Math.random()*300);
                taxa2 = (int)(Math.random()*600);
                                
                enemies[i] = new Enemy2();
                enemies[i].setX(taxa2);
                enemies[i].setY(taxa+53);                
               
            }

            
            tiro = new Shoot();
            
            setYellowBarX(505);
            setRedBarX(555);
            setRedBarWidth(0);
            
            pontuacao = 0;
         
            
            tiro.setX(nave.getX()+26);
            tiro.setY(nave.getY());
            player = nave.getImagem();
            player2 = enemies[0].getImagem();            
            
        }
        
        @Override
        public void paintComponent(Graphics g)
        {               
            
            formaTiro = tiro.getBounds();           
            for(int i =0; i<10 ; i++)
            {
                formaEnemies[i] = new Rectangle();
                formaEnemies[i]= enemies[i].getBounds();
            }
            
            if(getYellowBarX()>0)
                setYellowBarX(getYellowBarX()-1);
            if(getRedBarX()>50)
                setRedBarX(getRedBarX()-1);
            if(getRedBarWidth()<505)
                setRedBarWidth(getRedBarWidth()+1);
            
            if(getRedBarX()==50)
            {
                
            }
            
            g.clearRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.black);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            
            g.setColor(Color.gray);            
            g.fillRect(0, 450, 600, 150);
            
            
            
            g.setColor(Color.yellow);
            g.fillRect(50, 500, getYellowBarX(), 30);
            
            g.setColor(Color.red);            
            g.fillRect(getRedBarX(), 500, getRedBarWidth(), 30);
            
            value = Integer.toString(pontuacao);
            g.setColor(Color.white);  
            g.setFont(new Font("Times new Roman", Font.BOLD, 20));
            g.drawString(value, 500, 470);
            
            
            
            
            
                          
            g.drawImage(player, nave.getX(), nave.getY(), this);
            
            for(int j =0; j<10 ;j++)
            {
            if(enemies[j].visible())
                g.drawImage(player2, enemies[j].getX(), enemies[j].getY(), this);
            }

            g.setColor(Color.red);
            
                if(tiro.isVisible())
                {                    
                    g.drawLine(tiro.getX(), tiro.getY(), tiro.getX(), tiro.getY()+10);
                    tiro.Mexer();                    
                    
                    for(int q = 0; q<10 ; q++)
                    {
                        if(formaTiro.intersects(formaEnemies[q]))
                        {
                            enemies[q].destroy();
                            pontuacao = pontuacao +20;
                            tiro.setVisible(false); 
                        }
                    }
                }
                if(!tiro.isVisible())
                {
                    tiro.setX(nave.getX()+26);
                    tiro.setY(nave.getY());
                }
            
             for(int w =0; w<10; w++)
             {
                enemies[w].mover();
             }
            
            
            
            g.dispose();                        
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
        
        public void keyTyped(KeyEvent e) 
        { 
        
        }

        public void keyPressed(KeyEvent e) 
        {
            switch (e.getKeyCode()) 
            {
                case KeyEvent.VK_RIGHT:
                nave.setDx(10);
                
                nave.mover();
                break;
                
                case KeyEvent.VK_LEFT:
                nave.setDx(-10);
                
                nave.mover();
                break;
                
                case KeyEvent.VK_SPACE:                                  
                tiro.setVisible(true);                
                   
                    
                                    
                break;
            }
         
        }

        public void keyReleased(KeyEvent e) 
        { 
            
        }
        
        public int getYellowBarX()
        {
            return yellowBarX;
        }
        public int getRedBarX()
        {
            return redBarX;
        }
        public int getRedBarWidth()
        {
            return redBarWidth;
        }
        
        public void setYellowBarX(int value)
        {
            this.yellowBarX = value;
        }
        public void setRedBarX(int value)
        {
            this.redBarX = value;
        }
        public void setRedBarWidth(int value)
        {
            this.redBarWidth = value;
        }
        
   }
    
