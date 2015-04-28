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
    private Crosshair target;
    private Timer gameTimer = new Timer(17,this);
    private int loopCounter = 0;
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>(); 
    public BaseDefenseComponent()
    {
        this.target = new Crosshair(600,400);        
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
            if(target.getX() + 12 > enemies.get(i).getX() && target.getX() + 12 < enemies.get(i).getX() + 20)
            {
                if(target.getY() + 12 > enemies.get(i).getY() && target.getY() + 12 < enemies.get(i).getY() + 20)
                {
                    enemies.get(i).killed();
                    enemies.remove(i);
                }
            }
        }
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        if(enemies.size()>0)
        {
            for(int i = 0;
                i<enemies.size();
                i++)
            {enemies.get(i).draw(g2);}
        }
        this.target.draw(g2);
    }
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        loopCounter++;
        if(loopCounter == 80)
        {
            enemies.add(enemies.size(),new Enemy("Trooper"));
            loopCounter = 0;
        }
        for (int i = 0;
            i<enemies.size();
            i++)
        {enemies.get(i).move();}
    }
    class MouseClicker implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {shoot();}
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
