import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

import javax.swing.*;

public class Component extends JComponent {
    private ArrayList<Object> objects;
    private boolean isVisible = true;

    public Component(){
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g; //cast to 2D graphics

        //antialising
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        g2d.setRenderingHints(rh);

    }
}
