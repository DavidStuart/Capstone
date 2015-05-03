import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class EndGameScreen
{
    private String image;
    private int x = 0;
    private int y = 0;
    public EndGameScreen()
    {
        this.image = "";
    }
    public void draw(Graphics g)
    {
        ImageIcon endGameIcon = new ImageIcon(image);
        Image sprite = endGameIcon.getImage();
        g.drawImage(sprite,x,y, null);
    }
    public void endingChange(boolean win)
    {
        if(win == false)
        {this.image = "lose.png";}
        else if(win == true)
        {this.image = "win.png";}
    }
}