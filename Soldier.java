import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class Soldier
{
    private String soldierName;
    private int health = 3;
    private int accurateRange = 50;
    private int mobilityLevel = 2;
    private int damageLevel = 1;
    private String pngFileName = "soldier.png";
    public Soldier(String name)
    {
        soldierName = name;
    }
    public int getDamage(){return this.damageLevel;}
    public void draw(Graphics g)
    {
        ImageIcon soldierIcon = new ImageIcon(pngFileName);
        Image image = soldierIcon.getImage();
        g.drawImage(image,600,400, null);
    }
}
