package testejogo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemy3 
{
    private int x;
    private int y;
    private int dx;    
    private int dy; 
    private final Image imagem;    
    private boolean visible;
    
    private static final int heigth = 30;
    private static final int width = 30;
    
    public Enemy3()
    {
        ImageIcon referencia = new ImageIcon("res/Enemy2.jpg");
        imagem = referencia.getImage();        
        x=1;
        y=10;
        visible = true;
        dy = 2;
    }
    
    public void mover()
    {
        if(getY()<30)
        {
            this.setDy(5);
        }
                 
        if(getX()>597)
        {
            setX(1);
        }

        if(getY()>300)
        {
            this.setDy(-3);            
        }
            
        setX(x+15);
        setY(y+dy);
    }
    
    public void setDx(int dx)
    {
        this.dx = dx;
    }        
    
     public void setDy(int dy)
    {
        this.dy = dy;
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
