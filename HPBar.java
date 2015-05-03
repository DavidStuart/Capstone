import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class HPBar
{
    private String image;
    private int x;
    private int y;
    public HPBar(int startX,int startY)
    {
        image = "HP0hit.png";
        this.x = startX;
        this.y = startY;
    }
    public void draw(Graphics g)
    {
        ImageIcon hpIcon = new ImageIcon(image);
        Image sprite = hpIcon.getImage();
        g.drawImage(sprite,x,y, null);
    }
    public void setHPGauge(int hitsTaken)
    {this.image = "HP"+hitsTaken+"hit.png";}
}