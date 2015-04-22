import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class Enemy
{
    private String soldierName;
    private int health;
    private int accurateRange;
    private int mobilityLevel;
    private int damageLevel;
    private String unitImage;
    private String type;
    public Enemy(String eType)
    {
        if (eType.equals("Trooper") || eType.equals("Paratrooper"))
        {
            this.type = "Foot Unit";
            this.health = 3;
            this.accurateRange = 50;
            this.mobilityLevel = 1;
            this.damageLevel = 1;
            this.unitImage = "Soldier.png";
        }
        else if (eType.equals("Armored"))
        {
            this.type = "Foot Unit";
            this.health = 12;
            this.accurateRange = 25;
            this.mobilityLevel = 1;
            this.damageLevel = 2;
        }
        else if (eType.equals("High accuracy Distance take out"))
        {
            this.type = "Stationary Unit";
            this.health = 1;
            this.accurateRange = 500;
            this.mobilityLevel = 0;
            this.damageLevel = 8;
            int maxDamageLevel = 15;
        }
    }
    public void baseAttack(){}
    public void draw(Graphics g)
    {
        ImageIcon enemyImage = new ImageIcon(unitImage);
        Image sprite = enemyImage.getImage();
        g.drawImage(sprite,x,y, null);
    }
}
