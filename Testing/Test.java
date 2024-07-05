import javax.swing.*;

import GUI.Components.Window;

public class Test {
    public static void main(String[] args) {
        int width = 800;
        int height = 800;
        JFrame f = new JFrame();
        Window r = new Window(width, height);
        f.setSize(width, height);
        f.add(r);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.repaint();
    }    
}
