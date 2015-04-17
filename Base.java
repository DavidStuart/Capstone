import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Base
{
    private boolean baseDestroyed;
    public void Base()
    {
        baseDestroyed = false;
    }
    private void destroyBase()
    {
        baseDestroyed = true;
    }
}