import java.awt.*;
import java.awt.geom.*;

public class Rectangle {
    private int xPos;
    private int yPos;
    private int height;
    private int width;
    private Color color;
    
    public Rectangle(int xPos, int yPos, int height, int width, Color color){
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
        this.color = color;
    }

    public void drawRectangle(Graphics2D g2d){
        Rectangle2D.Double r = new Rectangle2D.Double(xPos, yPos, width, height);
        g2d.setColor(color);
        g2d.fill(r);
    }

    public int getXPos(){return this.xPos;}

    public int getYPos(){return this.yPos;}

    public int getHeight(){return this.height;}

    public int getWidth(){return this.width;}

    public Color getColor(){return this.color;}
}
