import java.awt.*;
import java.awt.geom.*;

public class Circle {
    private int xPos;
    private int yPos;
    private int height;
    private int width;
    private Color color;
    private boolean isVisible;

    public Circle(int xPos, int yPos, int height, int width, Color color){
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
        this.color = color;
        this.isVisible = true;
    }

    public void drawCircle(Graphics2D g2d){
        if (isVisible){
            Ellipse2D.Double c = new Ellipse2D.Double(xPos, yPos, width, height);
            g2d.setColor(color);
            g2d.fill(c);
        }
    }

    public void removeCircle(){
        isVisible = false;
    }

    public void showCircle(){
        isVisible = true;
    }
}
