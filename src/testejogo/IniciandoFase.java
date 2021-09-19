package testejogo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class IniciandoFase extends JPanel implements KeyListener
{
   
        private Image fundo = null;        
        private Graphics2D grafico;        
        protected static final int heigth = 600;
        protected static final int width = 600;
        private SpaceShip nave;
        private Shoot shoot;
        private Enemy1 enemy, enemy2, enemy3, enemy4,enemy5;
        ImageIcon referencia = new ImageIcon("res/TelaFundo.jpg");
            
           
        private Image imgFundo = null;   
        private Image player = null;
        private Image player2 = null;
        private Image tiro = null;
        
        
        public IniciandoFase()
        {
            setFocusable(true);
            addKeyListener(this);
            nave = new SpaceShip();           
            enemy = new Enemy1();    
            enemy2 = new Enemy1();    
            enemy2.setX(50);
            enemy2.setY(60);
            enemy3 = new Enemy1();    
            enemy3.setX(98);
            enemy3.setY(100);
            
            shoot = new Shoot();
               
                tiro = shoot.getImagem();
            
            
            player = nave.getImagem();
            player2 = enemy.getImagem();
            imgFundo = referencia.getImage();
            
        }
        
        @Override
        public void paintComponent(Graphics g)
        {               
                                   
            grafico = (Graphics2D) g.create();
            grafico.drawImage(imgFundo, 0, 0,this.getWidth(), this.getHeight(),this);                        
            grafico.drawImage(player, nave.getX(), nave.getY(), this);
            grafico.drawImage(player2, enemy.getX(), enemy.getY(), this);
            grafico.drawImage(player2, enemy2.getX(), enemy2.getY(), this);
            grafico.drawImage(player2, enemy3.getX(), enemy3.getY(), this);            
            grafico.drawImage(tiro, shoot.getX(), shoot.getY(), this);            
            
            enemy.mover();
            enemy2.mover();
            enemy3.mover();
            shoot.mover();    
            
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
                    
                                    
                break;
            }
         
        }

        public void keyReleased(KeyEvent e) 
        { 
        }
   }
    

