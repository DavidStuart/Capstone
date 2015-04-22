import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class BaseDefenseComponent extends JComponent
{
    private Crosshair target;
    public BaseDefenseComponent()
    {
        this.target = new Crosshair(600,400);        
        this.addMouseListener(new MouseClicker());
        this.addMouseMotionListener(new MouseMovementListener());
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        this.target.draw(g2);
    }
    class MouseClicker implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {System.out.print("yes");}
        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
    }
    class MouseMovementListener implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent e){}
        public void mouseMoved(MouseEvent e)
        {target.setPos(e.getX(),e.getY());repaint();}
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
