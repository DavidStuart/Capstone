import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class Crosshair
{
    String image;
    public void crosshair()
    {
        image = "crosshair.png";
    }
    public void draw(Graphics g)
    {
        ImageIcon crossIcon = new ImageIcon(image);
        Image imageThing = crossIcon.getImage();
        g.drawImage(imageThing,600,400, null);
    }
    public void moveLeft()
    {
        
    }
}