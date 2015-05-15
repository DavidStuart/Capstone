import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class Tower
{
    private String imagePart1;
    private String imagePart2;
    public Tower()
    {
        imagePart1 = "Tower.png";
        imagePart2 = "Tower_floor.png";
    }
    public void draw(Graphics g)
    {
        ImageIcon towerIcon = new ImageIcon(imagePart2);
        Image sprite = towerIcon.getImage();
        g.drawImage(sprite,180,549, null);
    }
    public void draw2(Graphics g)
    {
        ImageIcon towerIcon = new ImageIcon(imagePart1);
        Image sprite = towerIcon.getImage();
        g.drawImage(sprite,159,531, null);
    }
}