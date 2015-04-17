public class Sniper extends Soldier
{
    private String sniperName;
    private int health = 1;
    private int accurateRange = 500;
    private int mobilityLevel = 0;
    private int damageLevel = 8;
    private int MaxDamageLevel = 15;
    public void Sniper(String name)
    {
        sniperName = name;
    }
}