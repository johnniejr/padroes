package testejogo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TelaInicial extends JPanel 
{    
        private Image fundo;        
        private Graphics2D grafico;        
        protected static final int heigth = 600;
        protected static final int width = 600;        
        
        @Override
        public void paintComponent(Graphics g)
        {                       
            ImageIcon referencia = new ImageIcon("res/TelaFundo.jpg");
            fundo = referencia.getImage();            
            grafico = (Graphics2D) g;
            grafico.drawImage(fundo, 0, 0, null);                                    
            grafico.drawString("Pressione F2 para iniciar", 250, 300);
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
