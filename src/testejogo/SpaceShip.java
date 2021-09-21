package testejogo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class SpaceShip 
{
    private int x;
    private int y;
    private int dx;    
    private Image imagem;    
    private Image life;
    private boolean visible;
    private int contadorVidas;
     private boolean ganhouVida;
     private int pontuacao;
    
    
    private static final int heigth =   52;
    private static final int width = 62;
    
    public SpaceShip()
    {
        ImageIcon referencia = new ImageIcon("res/SpaceShip.jpg");
        ImageIcon referencia2 = new ImageIcon("res/SpaceShipLife.jpg");
        imagem = referencia.getImage();        
        life = referencia2.getImage();
        x=250;
        y=370;
        visible = true;
        this.contadorVidas = 3;
        this.pontuacao = 0;
        this.ganhouVida = false;
        
    }
    
    public void mover()
    {
        setX(x + dx);
        
        
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
    
    public void setX(int x)
    {
        this.x = x;
    }
    public void setContadorVidas(int vidas)
    {
        this.contadorVidas = vidas;
    }
    public int getContadorVidas()
    {
        return contadorVidas;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
 
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
     public int getDx()
    {
        return dx;
    }

    
    public Image getImagem()
    {
        return imagem;
    }
    
    public Image getImagemLife()
    {
        return life;
    }
    
    public int getHeigth()
    {
        return heigth;
    }
    public int getWidth()
    {
        return width;
    }
    
    public boolean visible()
    {
        return visible;
    }
    
    public void setVisible(boolean Visible)
    {
        visible = Visible;
    }  
    
     public Rectangle getBounds()
    {        
        return new Rectangle(x, y, width, heigth);        
    }
     
     public void destroy()
     {
         visible = false;
         x=250;
         y=370;         
     }
     
     public void setPontuacao(int points)
    {
        this.pontuacao = points;
    }
 
    
    public int getPontuacao()
    {
        return pontuacao;
    }
    
    public void setGanhouVida(boolean value)
    {
        this.ganhouVida = value;
    }
 
    
    public boolean getGanhouVida()
    {
        return ganhouVida;
    }
}
