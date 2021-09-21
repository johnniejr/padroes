package testejogo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Shoot
{
    private int x;
    private int y;
    private int dy;
    
    private boolean visible;
    
    private static final int heigth = 800;
    private static final int speed = 15;
    
    public Shoot()
    {
        this.x=x;
        this.y=y;
        this.dy=1;
        visible = false;
    }
    
    
    public void Mexer()
    {
        if(dy>0)
            y = y-speed;
        if(dy<0)
            y=y+speed;
        
        if(this.y < 0)
        {
            this.visible = false;
            this.y = 400;
        }
        if(y>450)
        {
            this.visible = false;
            this.y = 0;
        }
    }

    public boolean isVisible() 
    {
        return visible;
    }

    public void setVisible(boolean isVisible) 
    {
        this.visible = isVisible;
    }

    
    public int getX() 
    {
        return x;
    }
    
    public int getY() 
    {
        return y;
    }
     public void setX(int value) 
    {
        this.x=value;
    }
    
    public void setY(int value) 
    {
        this.y=value;
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