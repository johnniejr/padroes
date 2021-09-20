package testejogo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemy1 
{
    private int x;
    private int y;
    private int dx;    
    private Image imagem;    
    private boolean visible;
    
    private static final int heigth = 20;
    private static final int width = 20;
    
    public Enemy1()
    {
        ImageIcon referencia = new ImageIcon("res/Enemy.jpg");
        imagem = referencia.getImage();        
        x=1;
        y=10;
        visible = true;
    }
    
    public void mover()
    {
        setX(x+5);
        if(getX()>597)
        {
            setX(1);
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
    
     public Rectangle getBounds()
    {        
        return new Rectangle(x, y, width, heigth);        
    }
     
     public void destroy()
     {
         setVisible(false);
         setX(0);
         setY(0);
     }
    
}
