import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class Crosshair
{
    private String image;
    private int x;
    private int y;
    public Crosshair(int startX,int startY)
    {
        image = "crosshair.png";
        this.x = startX;
        this.y = startY;
    }
    public void draw(Graphics g)
    {
        ImageIcon crossIcon = new ImageIcon(image);
        Image imageThing = crossIcon.getImage();
        g.drawImage(imageThing,x,y, null);
    }
    public void setPos(int mouseX,int mouseY)
    {this.x = mouseX; this.y = mouseY;}
}