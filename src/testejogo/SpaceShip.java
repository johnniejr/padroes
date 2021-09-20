package testejogo;

import java.awt.Image;
import javax.swing.ImageIcon;

public class SpaceShip 
{
    private int x;
    private int y;
    private int dx;    
    private Image imagem;    
    private boolean visible;
    
    private static final int heigth =   52;
    private static final int width = 62;
    
    public SpaceShip()
    {
        ImageIcon referencia = new ImageIcon("res/SpaceShip.jpg");
        imagem = referencia.getImage();        
        x=250;
        y=370;
        visible = true;
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
    
}
