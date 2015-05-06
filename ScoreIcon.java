import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class ScoreIcon
{
    private String image;
    private int x = 0;
    private int y = 0;
    public ScoreIcon(int startX, int startY)
    {
        this.image = "enemyIcon.png";
        
        this.x = startX;
        this.y = startY;
    }
    public void draw(Graphics g)
    {
        ImageIcon scoreIcon = new ImageIcon(image);
        Image sprite = scoreIcon.getImage();
        g.drawImage(sprite,x,y, null);
    }
}