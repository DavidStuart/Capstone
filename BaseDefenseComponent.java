import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class BaseDefenseComponent extends JComponent implements ActionListener
{
    private Timer gameTimer = new Timer(17,this);
    
    private int loopCounter = 0;
    private int shotDelay = 0;
    private int killCount = 0;
    private int damageTaken = 0;
    private int enemySpawnDelay = (int)(Math.random()*100)+1;
    
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private ArrayList<ScoreIcon> scoreIcons = new ArrayList<ScoreIcon>();
    
    private Crosshair target;
    private Field background;
    private HPBar hp;
    private EndGameScreen egs;
    public BaseDefenseComponent()
    {
        this.target = new Crosshair(600,400);
        this.background = new Field();
        this.hp = new HPBar(50,50);
        this.egs = new EndGameScreen();
        
        int placementX = 1130;
        int placementY = 10;

         for(int i = 0;
             i < 4;
             i++)
         {
            for(int j = 0;
                j < 10;
                j++)
            {    
                scoreIcons.add(new ScoreIcon(placementX,placementY));
                placementX-= 25;
            }
            placementX = 1130;
            placementY+= 27;
         }
        
        this.addMouseListener(new MouseClicker());
        this.addMouseMotionListener(new MouseMovementListener());
        
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
        cursorImg, new Point(0, 0), "blank cursor");
        this.setCursor(blankCursor);
        this.gameTimer.start();
    }
    public void shoot()
    {
        for(int i = 0;
            i < enemies.size();
            i++)
        {
            if(target.getX() + 12 > enemies.get(i).getX() && target.getX() + 12 < enemies.get(i).getX() + 40)
            {
                if(target.getY() + 12 > enemies.get(i).getY() && target.getY() + 12 < enemies.get(i).getY() + 22)
                {
                    enemies.get(i).killed();
                    enemies.remove(i);
                    scoreIcons.remove(scoreIcons.size()-1);
                    this.killCount++;
                }
                else if(target.getY() + 12 > enemies.get(i).getY()+22 && target.getY() + 12 < enemies.get(i).getY() + 40)
                {enemies.get(i).wounded();}
            }
        }
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        this.background.draw(g2);
        this.hp.draw(g2);
        for(int kc = 0;
            kc < scoreIcons.size();
            kc++)
        {scoreIcons.get(kc).draw(g2);}
        if(killCount < 40 && damageTaken < 10)
        {
            if(enemies.size()>0)
            {
                for(int i = 0;
                    i<enemies.size();
                    i++)
                {enemies.get(i).draw(g2);}
            }
            this.target.draw(g2);
        }
        else
        {
            if(killCount >= 40)
            {this.egs.endingChange(true);this.egs.draw(g2);}
            if(damageTaken >= 10)
            {this.egs.endingChange(false);this.egs.draw(g2);}
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        if(damageTaken < 10 && killCount < 40)
        {
            loopCounter++;
            shotDelay++;
            if(loopCounter == enemySpawnDelay && enemies.size() < 13)
            {
                enemies.add(enemies.size(),new Enemy("Trooper"));
                loopCounter = 0;
                enemySpawnDelay = (int)(Math.random()*100)+1;
            }
            for (int i = 0;
                i<enemies.size();
                i++)
            {
                enemies.get(i).move();
                if(enemies.get(i).getX() < -40)
                {
                    this.damageTaken++;
                    this.hp.setHPGauge(this.damageTaken);
                    enemies.remove(i);
                    i--;
                }
            }
        }
    }
    class MouseClicker implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
            if(shotDelay > 40)
            {shoot();shotDelay = 0;}
        }
        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
    }
    class MouseMovementListener implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent e){}
        public void mouseMoved(MouseEvent e)
        {target.setPos(e.getX(),e.getY());}
    }
    //class KeyStrokeListener implements KeyListener
    //{
    //    public void keyPressed(KeyEvent event) 
    //    {
    //        String key = KeyStroke.getKeyStrokeForEvent(event).toString().replace("pressed ", ""); 
    //        if (key.equals("LEFT"))
    //        {
    //                      
    //        }
    //        else if (key.equals("RIGHT"))
    //        {
    //            
    //        }
    //    }
    //
    //    public void keyTyped(KeyEvent event) {}
    //
    //    public void keyReleased(KeyEvent event) {}
    //}
}
