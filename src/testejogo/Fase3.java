package testejogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;

public class Fase3 extends JPanel implements KeyListener
{         
    protected static final int heigth = 800;
    protected static final int width = 600;

    private Image player = null;
    private Image player2 = null;
    private Image life = null;
    private Graphics2D g;                
    private Rectangle formaTiro;
    private Rectangle formaTiroInimigo;
    private Rectangle formaNave;                

    private SpaceShip nave;                                 
    private Shoot tiro;
    private Shoot tiroInimigo;

    private int level=15;        
    private boolean terminouFase;

    private int yellowBarX;
    private int redBarX;
    private int redBarWidth;        
    private int taxa, taxa2, atirador, count, qtd;

    private String value;

    Enemy3[] enemies = new Enemy3[level];
    Rectangle[] formaEnemies = new Rectangle[level];

    public Fase3()
    {        
        setFocusable(true);
        addKeyListener(this);
        
        nave = new SpaceShip();    
        tiro = new Shoot();
        tiroInimigo = new Shoot();
        tiroInimigo.setDirection(-1);
        
        this.qtd = 1;

        for( int i = 0 ; i < level; i++)
        {
            taxa = (int)(Math.random()*300);
            taxa2 = (int)(Math.random()*600);

            enemies[i] = new Enemy3();
            enemies[i].setY(taxa+53);     
            enemies[i].setX(taxa2);                       
        }

        this.setYellowBarX(505);
        this.setRedBarX(555);
        this.setRedBarWidth(0);

        player = nave.getImagem();
        player2 = enemies[0].getImagem();            
        life = nave.getImagemLife();
    }

    @Override
    public void paintComponent(Graphics g)
    {               
        formaNave = nave.getBounds();
        formaTiro = tiro.getBounds();
        formaTiroInimigo = tiroInimigo.getBounds();
        
        for(int i = 0; i < level ; i++)
        {
            formaEnemies[i] = new Rectangle();
            formaEnemies[i]= enemies[i].getBounds();
        }

        //Barra de Energia / Valores --------------------------------------------
        if(getYellowBarX()>0)
            setYellowBarX(getYellowBarX()-1);
        if(getRedBarX()>50)
            setRedBarX(getRedBarX()-1);
        if(getRedBarWidth()<505)
            setRedBarWidth(getRedBarWidth()+1);

        if(getRedBarX()==50) //Zerou energia
        {
            setYellowBarX(505);
            setRedBarX(555);
            setRedBarWidth(0);
            nave.setContadorVidas(nave.getContadorVidas()-1);
        }
        //-------------------------------------------------------------

        //Fundo-----------------------------------------------------------
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        //--------------------------------------------------------------
        
        //Barra inferior----------------------------------------------------
        g.setColor(Color.gray);            
        g.fillRect(0, 450, 600, 150);


        for(int i = 0; i < nave.getContadorVidas(); i++)//Vidas
        {
            g.drawImage(life,50+40*i,470,this);
        }

        g.setColor(Color.yellow);//Barra de energia
        g.fillRect(50, 500, getYellowBarX(), 30);

        g.setColor(Color.red);//Consumo da barra de energia
        g.fillRect(getRedBarX(), 500, getRedBarWidth(), 30);

        value = Integer.toString(nave.getPontuacao());//Pontuação
        g.setColor(Color.white);  
        g.setFont(new Font("Times new Roman", Font.BOLD, 20));
        g.drawString(value, 500, 470);

        //---------------------------------------------------------------

        //JOGO-----------------------------------------------------------

        atirador = new Random().nextInt()%level;   

        if(atirador<0)
            atirador = atirador*(-1);

        tiroInimigo.visible(true); //Tiro inimigo aleatório

        g.drawImage(player, nave.getX(), nave.getY(), this);

        for(int i = 0; i < level; i++)
        {
            if(enemies[i].visible())
                g.drawImage(player2, enemies[i].getX(), enemies[i].getY(), this);
        }

        g.setColor(Color.red);//TIRO

        if(tiro.visible())
        {                    
            g.drawLine(tiro.getX(), tiro.getY(), tiro.getX(), tiro.getY()+10);
            tiro.Mexer();                    

            for(int i = 0; i <level; i++)
            {
                if(formaTiro.intersects(formaEnemies[i]))
                {
                    enemies[i].destroy();
                    nave.setPontuacao(nave.getPontuacao()+40);
                    tiro.visible(false); 
                }
            }
        }
        
        if(!tiro.visible())
        {
            tiro.setX(nave.getX()+26);
            tiro.setY(nave.getY());
        }

        for(int i = 0; i < level; i++)
        {
            enemies[i].mover();
        }                 

        if(tiroInimigo.visible()) //TIRO INIMIGO
        {                    
            g.setColor(Color.green);
            g.drawLine(tiroInimigo.getX(), tiroInimigo.getY(), tiroInimigo.getX(), tiroInimigo.getY()+10);                    
            tiroInimigo.Mexer();                    

            if(formaTiroInimigo.intersects(formaNave))
            {
                nave.destroy();
                nave.setContadorVidas(nave.getContadorVidas()-1);
                tiroInimigo.visible(false); 
                setYellowBarX(505);
                setRedBarX(555);
                setRedBarWidth(0);
            }
        }
        
        if(!tiroInimigo.visible())
        {
            tiroInimigo.setX(enemies[atirador].getX()+15);
            tiroInimigo.setY(enemies[atirador].getY());
        }

        //PONTUAÇÃO E GANHO DE VIDAS E PARTIDA -------------------------------
        
        if(nave.getPontuacao() >= 1000*qtd)
        {
            nave.setContadorVidas(nave.getContadorVidas()+1);
            qtd = qtd+1;
        }

        for(int i = 0; i < level; i++)
        {
        
            if(!enemies[i].visible() && terminouFase==false)
            {
                count++;
                
                if(count==level)
                {
                    nave.setPontuacao(nave.getPontuacao()+getYellowBarX()*2);
                    terminouFase=true;
                    //Código para mudar o estado para próxima fase.
                }                   
            }
        }
        
        count=0;// Enquanto ainda não destruiu todos os inimigos

        //Código para derrota ---------------------------------------------
        
/*      if(nave.getContadorVidas()==0)
        {
            //Game Over
        }
*/           
      //-----------------------------------------------------------------------  
        
        g.dispose();                        
    }

    @Override
    public int getWidth()
    {
        return width;
    }

    public int getHeigth()
    {
        return heigth;
    }

    public void keyTyped(KeyEvent e) 
    { 

    }

    public void keyPressed(KeyEvent e) 
    {
        switch (e.getKeyCode()) 
        {
            case KeyEvent.VK_RIGHT:
            nave.setDx(10);
            nave.mover();
            break;

            case KeyEvent.VK_LEFT:
            nave.setDx(-10);
            nave.mover();
            break;

            case KeyEvent.VK_SPACE:                                  
            tiro.visible(true);                
            break;
        }
    }

    public void keyReleased(KeyEvent e) 
    { 

    }

    public int getYellowBarX()
    {
        return yellowBarX;
    }
    public int getRedBarX()
    {
        return redBarX;
    }
    public int getRedBarWidth()
    {
        return redBarWidth;
    }

    public void setYellowBarX(int value)
    {
        this.yellowBarX = value;
    }
    public void setRedBarX(int value)
    {
        this.redBarX = value;
    }
    public void setRedBarWidth(int value)
    {
        this.redBarWidth = value;
    }
}


