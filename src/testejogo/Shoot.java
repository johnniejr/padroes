package testejogo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Shoot
{
    private static final int heigth = 800;
    private static final int speed = 15;
    
    private int x, y, dy;        
    private boolean visible;
      
    public Shoot()
    {        
        this.dy = 1;
        this.visible = false;
    }    
    
    public void Mexer()
    {
        if(dy>0)
            y = y-speed;
        if(dy<0)
            y = y+speed;
        
        if(y < 0)
        {
            this.visible = false;
            this.y = 0;
        }
        if(y>450)
        {
            this.visible = false;
            this.y = 0;
        }
    }
    
    public void setX(int value) 
    {
        this.x = value;
    }
    
    public int getX() 
    {
        return x;
    }
    
    public void setY(int value) 
    {
        this.y = value;
    }
    
    public int getY() 
    {
        return y;
    }          
    
    public void visible(boolean visible) 
    {
        this.visible = visible;
    }
        
    public boolean visible() 
    {
        return visible;
    }
        
    public void setDirection(int value)
    {
        this.dy = value;
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(x,y,2,2);
    }    
}