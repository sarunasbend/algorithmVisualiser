public class Cookie {
    private int cookieDiameter = 600;
    private Ball border = new Ball(400, 500, cookieDiameter * 1.05, "#000000");
    private Ball dough = new Ball(400, 500, cookieDiameter, "#99621E");
    private Ball choc = new Ball(450, 700, cookieDiameter * 0.1, "#000000");
    private Ball choc2 = new Ball(600, 500, cookieDiameter * 0.2, "#000000");
    private Ball choc3 = new Ball(300, 550, cookieDiameter * 0.15, "#000000");
    private Ball choc4 = new Ball(200, 400, cookieDiameter * 0.15, "#000000");
    private Ball choc5 = new Ball(420, 315, cookieDiameter * 0.15, "#000000");

    public Cookie(GameArena arena)
    {
        arena.addBall(border);   
        arena.addBall(dough);
        arena.addBall(choc);
        arena.addBall(choc2);
        arena.addBall(choc3);
        arena.addBall(choc4);
        arena.addBall(choc5);
    }

    public void cookieClicked(GameArena arena)
    {
        border.setSize(1.05 * (cookieDiameter * 1.05));
        border.setColour("#00FF00");
        dough.setSize(1.05 * (cookieDiameter));
        choc.setSize(1.05 * (cookieDiameter * 0.1));
        choc2.setSize(1.05 * (cookieDiameter * 0.2));
        choc3.setSize(1.05 * (cookieDiameter * 0.15));
        choc4.setSize(1.05 * (cookieDiameter * 0.15));
        choc5.setSize(1.05 * (cookieDiameter * 0.15));
        
        try {
            Thread.sleep(200);
        } catch (InterruptedException exception)
        {
            System.out.println("PROGRAM END");
        }
        
        border.setSize(cookieDiameter * 1.05);
        border.setColour("#000000");
        dough.setSize(cookieDiameter);
        choc.setSize(cookieDiameter * 0.1);
        choc2.setSize(cookieDiameter * 0.2);
        choc3.setSize(cookieDiameter * 0.15);
        choc4.setSize(cookieDiameter * 0.15);
        choc5.setSize(cookieDiameter * 0.15);
    }
}

/*what does this class need:
1. the cookie
2. cookie after being pressed (animation)
3. 
*/