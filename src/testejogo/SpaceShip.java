package testejogo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class SpaceShip 
{
    private static final int heigth = 52;
    private static final int width = 62;
    
    private int x, y, dx;    
    private Image nave;    
    private Image naveLife;
    private boolean visible;
    private int contadorVidas;    
    private int pontuacao;
    
    
    public SpaceShip()
    {
        ImageIcon referencia1 = new ImageIcon("res/SpaceShip.jpg");
        ImageIcon referencia2 = new ImageIcon("res/SpaceShipLife.jpg");
        nave = referencia1.getImage();        
        naveLife = referencia2.getImage();
        
        this.x=250;
        this.y=370;
        this.visible = true;
        this.contadorVidas = 3;
        this.pontuacao = 0;                
    }
    
    public void mover()
    {
        setX(x + dx); //Só se move para os lados
                
        if(this.x<1)
        {
            this.x=1;
        }
        if(this.x>530)
        {
            this.x=530;
        }        
    }
       
    public void setDx(int dx)
    {
        this.dx = dx;
    }        
    
    public int getDx()
    {
        return dx;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public int getX()
    {
        return x;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    public int getY()
    {
        return y;
    }
        
    public void setContadorVidas(int vidas)
    {
        this.contadorVidas = vidas;
    }
    
    public int getContadorVidas()
    {
        return contadorVidas;
    }    
    
    public void setPontuacao(int points)
    {
        this.pontuacao = points;
    }
    
    public int getPontuacao()
    {
        return pontuacao;
    }
 
           
    public void setVisible(boolean Visible)
    {
        visible = Visible;
    }  
    
    public boolean visible()
    {
        return visible;
    }
            
    public Image getImagem()
    {
        return nave;
    }
    
    public Image getImagemLife()
    {
        return naveLife;
    }
    
    public int getHeigth()
    {
        return heigth;
    }
    public int getWidth()
    {
        return width;
    }
    
    public Rectangle getBounds()
    {        
        return new Rectangle(x, y, width, heigth);        
    }
     
    public void destroy()
    {
        this.setVisible(false);
        this.setX(250);
        this.setY(370);         
    }
}
