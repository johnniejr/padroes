package testejogo;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends JFrame implements KeyListener
{        
    private Fase1 fase1;    
    private Fase2 fase2;    
    private Fase3 fase3;    
    private Timer timer;
        
    public Game() 
    {
        super("Megamania");
                
        fase1 = new Fase1();
        //fase2 = new Fase2();
        //fase3 = new Fase3();
        addKeyListener(this);
        component();               
    }     
    
    public void component()
    {              
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        add(fase1, BorderLayout.CENTER);
        //add(fase2, BorderLayout.CENTER);
        //add(fase3, BorderLayout.CENTER);
           inicialize();
    }
    
    public void inicialize()
    {                        
        timer = new Timer(50, ae->fase1.repaint());
        //timer = new Timer(50, ae->fase2.repaint());
        //timer = new Timer(50, ae->fase3.repaint());
        timer.setRepeats(true);
        timer.start();
    }
    
    @Override
    public void keyPressed(KeyEvent e) 
    {
        
    }
    @Override
    public void keyReleased(KeyEvent e) 
    { 
        
    }
           
    public static void main(String [] args)
    {
        new Game();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
