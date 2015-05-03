import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class Field
{
    private String image;
    public Field()
    {
        image = "field.png";
    }
    public void draw(Graphics g)
    {
        ImageIcon backIcon = new ImageIcon(image);
        Image sprite = backIcon.getImage();
        g.drawImage(sprite,0,0, null);
    }
}