package testejogo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemy1 
{    
    private static final int heigth = 30;
    private static final int width = 30;
        
    private int x, y, dx;    
    private Image enemy1;    
    private boolean visible;
    
    public Enemy1()
    {
        ImageIcon referencia = new ImageIcon("res/Enemy1.jpg");
        this.enemy1 = referencia.getImage();        
        this.x=1;
        this.y=10;
        this.dx=3;
        this.visible = true;
    }
    
    public void mover()
    {
        setX(x+dx);
        
        if(getX()>597)
        {
            this.setX(1);
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
             
    public Image getImagem()
    {
        return enemy1;
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
    
    public void setVisible(boolean visible)
    {
        this.visible = visible;
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
