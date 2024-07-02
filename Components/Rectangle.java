package Components;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Rectangle extends JPanel{
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(200, 200, 200, 100);
    }
}
