package GUI;

import GUI.Components.Circle;
import GUI.Components.Text;
import GUI.Components.Rectangle;
import GUI.Components.Line;
import GUI.Components.Window;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class Home {
    public Home() {
        Window temp = new Window(800, 800, true);
        temp.add(new JLabel("boobs"));
        Text text = new Text("FUCK", 0, 0, 0, "#00FF00");
        temp.addText(text);
    }
}
