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

public class IniciandoFase extends JPanel implements KeyListener
{         
        protected static final int heigth = 800;
        protected static final int width = 600;
        private SpaceShip nave; 
        private Enemy1 enemy, enemy2, enemy3, enemy4,enemy5;                             
        private Image player = null;
        private Image player2 = null;
        private Shoot tiro;
        private Graphics2D g;        
        
        private Rectangle formaTiro;
        private Rectangle formaEnemy;
        private Rectangle formaEnemy2;
        private Rectangle formaEnemy3;
        
        private int yellowBarX;
        private int redBarX;
        private int redBarWidth;
        private int pontuacao;
        private int numero;
        
        private String value;
        private Random taxa;
        
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
            
            
            Enemy1[] enemies = new Enemy1[10];
            
            tiro = new Shoot();
            
            setYellowBarX(505);
            setRedBarX(555);
            setRedBarWidth(0);
            
            pontuacao = 0;
            taxa = new Random(1);
            numero = (taxa.nextInt())%10;
            
            tiro.setX(nave.getX()+26);
            tiro.setY(nave.getY());
            player = nave.getImagem();
            player2 = enemy.getImagem();            
            
        }
        
        @Override
        public void paintComponent(Graphics g)
        {               
            
            formaTiro = tiro.getBounds();
            formaEnemy = enemy.getBounds();
            formaEnemy2 = enemy2.getBounds();
            formaEnemy3 = enemy3.getBounds();
            
            
            
            
            if(getYellowBarX()>0)
                setYellowBarX(getYellowBarX()-1);
            if(getRedBarX()>50)
                setRedBarX(getRedBarX()-1);
            if(getRedBarWidth()<505)
                setRedBarWidth(getRedBarWidth()+1);
            
            if(getRedBarX()==50)
            {
                setYellowBarX(505);
                setRedBarX(555);
                setRedBarWidth(0);
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
            
            
            
            for(int i=0; i<10 ; i++)
            {
                g.drawImage(player2, enemy.getX()+(20*numero+i), enemy.getY()+(20*numero), this);                
            }
            
                          
            g.drawImage(player, nave.getX(), nave.getY(), this);
            
            if(enemy.visible())
                g.drawImage(player2, enemy.getX(), enemy.getY(), this);
            if(enemy2.visible())
                g.drawImage(player2, enemy2.getX(), enemy2.getY(), this);
            if(enemy3.visible())
                g.drawImage(player2, enemy3.getX(), enemy3.getY(), this);            

            g.setColor(Color.red);
            
                if(tiro.isVisible())
                {                    
                    g.drawLine(tiro.getX(), tiro.getY(), tiro.getX(), tiro.getY()+10);
                    tiro.Mexer();                    
                    if(formaTiro.intersects(formaEnemy)){
                        enemy.destroy();
                        pontuacao = pontuacao +20;
                        tiro.setVisible(false); }
                    if(formaTiro.intersects(formaEnemy2)){
                        enemy2.destroy();
                        pontuacao = pontuacao +20;
                        tiro.setVisible(false); }
                    if(formaTiro.intersects(formaEnemy3)){
                        enemy3.destroy();
                        pontuacao = pontuacao +20;
                        tiro.setVisible(false); }
                }
                if(!tiro.isVisible())
                {
                    tiro.setX(nave.getX()+26);
                    tiro.setY(nave.getY());
                }
            
            enemy.mover();
            enemy2.mover();
            enemy3.mover();                                    
            
            
            
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
    

