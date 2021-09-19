package testejogo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class JogandoFase implements State
{
   Shoot novo = new Shoot();
    public JogandoFase(Shoot novo)
    {
       this.novo = novo;
    }
    
        private Image fundo;        
        private Graphics2D grafico;        
        protected static final int heigth = 600;
        protected static final int width = 600;
        private Enemy1 nave;
        private Image spaceShip;
        
     
        @Override
        public void paintComponent(Graphics g)
        {   
            
            System.out.println("teste2");
            
            nave = new Enemy1();            
            ImageIcon referencia = new ImageIcon("res/TelaFundo.jpg");
            fundo = referencia.getImage();
            spaceShip = nave.getImagem();
            grafico = (Graphics2D) g;
            grafico.drawImage(fundo, 0, 0, null);                        
            grafico.drawImage(spaceShip, nave.getX(),nave.getY(), null);
            g.dispose();                        
        }
        
        
        public int getWidth()
        {
            return width;
        }
        
        public int getHeigth()
        {
            return heigth;
        }
}
