import javax.swing.JFrame;

public class BaseDefenseViewer
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        
        frame.setSize(1200, 800);
        frame.setTitle("Base Defense");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BaseDefenseComponent component = new BaseDefenseComponent();
        frame.add(component);
        
        
        frame.setVisible(true);
    }
    
    
}
