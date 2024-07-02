package Components;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Circle extends JPanel{
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawOval(50, 50, 200, 100);
        g.dispose();
    }
}