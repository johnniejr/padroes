package testejogo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Shoot
{
    private int x;
    private int y;
    
    
    private boolean visible;
    
    private static final int heigth = 800;
    private static final int speed = 15;
    
    public Shoot()
    {
        this.x=x;
        this.y=y;        
        visible = false;
    }
    
    
    public void Mexer()
    {
        this.y -= speed;
        if(this.y < 0)
        {
            this.visible = false;
            this.y = 400;
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
    
    
    public Rectangle getBounds()
    {
        return new Rectangle(x,y,2,2);
    }
    
}