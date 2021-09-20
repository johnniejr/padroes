package testejogo;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends JFrame implements KeyListener
{
    
    private IniciandoFase novo2;
    private TelaInicial novo1;
    private Timer timer;
        
    public Game() 
    {
        
        super("Megamania");
        novo1 = new TelaInicial();
        novo2 = new IniciandoFase();
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
        
        add(novo2, BorderLayout.CENTER);
           inicialize();
    }
    
    public void inicialize()
    {        
        
        add(novo2);
        timer = new Timer(50, ae->novo2.repaint());
        timer.setRepeats(true);
        timer.start();
    }
    
    @Override
     public void keyPressed(KeyEvent e) 
        {
            switch (e.getKeyCode()) 
            {
                case KeyEvent.VK_F2:
                 
                break;
            }         
        }
    @Override
        public void keyReleased(KeyEvent e) 
        { }
    
       
    public static void main(String [] args)
    {
        new Game();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
