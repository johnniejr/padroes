package testejogo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemy3 
{
    private static final int heigth = 30;
    private static final int width = 30;
    
    private int x, y, dx, dy;    
    private final Image enemy3;    
    private boolean visible;        
    
    public Enemy3()
    {
        ImageIcon referencia = new ImageIcon("res/Enemy3.jpg");
        enemy3 = referencia.getImage();        
        this.x=1;
        this.y=10;        
        this.dy = 2;
        this.dx = 15; 
        this.visible = true;
    }
    
    public void mover()
    {
        if(getY()<30)
        {
            this.setDy(5);
        }
                 
        if(getX()>597)
        {
            this.setX(1);
        }

        if(getY()>300)
        {
            this.setDy(-3);            
        }
            
        this.setX(x+dx);
        this.setY(y+dy);
    }
    
    public void setDx(int dx)
    {
        this.dx = dx;
    }
    
    public int getDx()
    {
        return dx;
    }
    
    public void setDy(int dy)
    {
        this.dy = dy;
    }        
     
    public int getDy()
    {
        return dy;
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
         
    public void setVisible(boolean visible)
    {
        visible = visible;
    }  
  
    public boolean visible()
    {
        return visible;
    }
    
    public Image getImagem()
    {
        return enemy3;
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
        this.setX(0);
        this.setY(0);
    }
}
