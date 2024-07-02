package GUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Components.Circle;
import Components.Rectangle;

public class Home {
    public Home() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(new Rectangle());
        frame.add(new Circle());
        frame.setVisible(true);
    }
}
