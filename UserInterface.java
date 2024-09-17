public class UserInterface {
    private int total = 100;
    private int cps = 1;
    private int upgrade1 = 0;
    private int upgrade2 = 0;
    private int upgrade3 = 0;
    private int upgrade4 = 0;
    
    private Text totalCookiesCounter = new Text(Integer.toString(total), 40, 400, 125, "#000000");
    private Text cpsCounter = new Text(Integer.toString(cps), 30, 400, 195, "#000000");
    private Text upgrade1Counter = new Text("OWNED: " + Integer.toString(upgrade1), 10, 40, 920, "#000000");
    private Text upgrade2Counter= new Text("OWNED: " + Integer.toString(upgrade2), 10, 240, 920, "#000000");
    private Text upgrade3Counter = new Text("OWNED: " + Integer.toString(upgrade3), 10, 440, 920, "#000000");
    private Text upgrade4Counter = new Text("OWNED: " + Integer.toString(upgrade4), 10, 640, 920, "#000000");

    public UserInterface(GameArena arena)
    {
        Text totalCookiesText = new Text("TOTAL COOKIES:" , 50, 175, 75, "#000000");
        arena.addText(totalCookiesText);
        //Text totalCookiesCounter = new Text(Integer.toString(total), 40, 400, 125, "#000000");
        arena.addText(totalCookiesCounter);
        Text cpsText = new Text("COOKIES PER SECOND: ", 30, 220, 160, "#000000");
        arena.addText(cpsText);
        //Text cpsCounter = new Text(Integer.toString(cps), 30, 400, 195, "#000000");
        arena.addText(cpsCounter);

        Rectangle upgrade1Border = new Rectangle(0,850, 200, 150, "#FFFFF0");
        arena.addRectangle(upgrade1Border);
        Rectangle upgrade2Border = new Rectangle(200,850, 200, 150, "#FFFF00");
        arena.addRectangle(upgrade2Border);
        Rectangle upgrade3Border = new Rectangle(400,850, 200, 150, "#FFF000");
        arena.addRectangle(upgrade3Border);
        Rectangle upgrade4Border = new Rectangle(600,850, 200, 150, "#FF0000");
        arena.addRectangle(upgrade4Border);

        Rectangle upgrade1Hitbox = new Rectangle(13, 867, 174, 114, "#FF00FF");
        arena.addRectangle(upgrade1Hitbox);
        Rectangle upgrade2Hitbox = new Rectangle(213, 867, 174, 114, "#FF00FF");
        arena.addRectangle(upgrade2Hitbox);
        Rectangle upgrade3Hitbox = new Rectangle(413, 867, 174, 114, "#FF00FF");
        arena.addRectangle(upgrade3Hitbox);        
        Rectangle upgrade4Hitbox = new Rectangle(613, 867, 174, 114, "#FF00FF");
        arena.addRectangle(upgrade4Hitbox);
        
        
        Text upgrade1Text = new Text("CLICKER", 20, 40, 900, "#000000");
        arena.addText(upgrade1Text);
        Text upgrade2Text = new Text("GRANDMA", 20, 240, 900, "#000000");
        arena.addText(upgrade2Text);
        Text upgrade3Text = new Text("FARM", 20, 440, 900, "#000000");
        arena.addText(upgrade3Text);
        Text upgrade4Text = new Text("FACTORY", 20, 640, 900, "#000000");
        arena.addText(upgrade4Text);

        Text upgrade1TextInfo = new Text("COST: 100", 10, 40, 910, "#000000");
        arena.addText(upgrade1TextInfo);
        Text upgrade2TextInfo = new Text("COST: 1000", 10, 240, 910, "#000000");
        arena.addText(upgrade2TextInfo);
        Text upgrade3TextInfo = new Text("COST: 10000", 10, 440, 910, "#000000");
        arena.addText(upgrade3TextInfo);
        Text upgrade4TextInfo = new Text("COST: 100000", 10, 640, 910, "#000000");
        arena.addText(upgrade4TextInfo);

        //Text upgrade1CounterText = new Text("OWNED: " + Integer.toString(upgrade1), 10, 40, 920, "#000000");
        arena.addText(upgrade1Counter);
        //Text upgrade2CounterText = new Text("OWNED: " + Integer.toString(upgrade2), 10, 240, 920, "#000000");
        arena.addText(upgrade2Counter);
        //Text upgrade3CounterText = new Text("OWNED: " + Integer.toString(upgrade3), 10, 440, 920, "#000000");
        arena.addText(upgrade3Counter);
        //Text upgrade4CounterText = new Text("OWNED: " + Integer.toString(upgrade4), 10, 640, 920, "#000000");
        arena.addText(upgrade4Counter);
    }

    public void upgrade1Pressed(GameArena arena)
    {
        if (total >= 100)
        {
            upgrade1++;
            cps++;
            total = total - 100;
            upgrade1Counter.setText("OWNED: " + Integer.toString(upgrade1));
            cpsCounter.setText(Integer.toString(cps));
            totalCookiesCounter.setText(Integer.toString(total));
        }
    }

    public void upgrade2Pressed(GameArena arena)
    {
        if (total >= 1000)
        {
            upgrade2++;
            cps = cps + 10;
            total = total - 1000;
            upgrade2Counter.setText("OWNED: " + Integer.toString(upgrade2));
            cpsCounter.setText(Integer.toString(cps));
            totalCookiesCounter.setText(Integer.toString(total));
        }
    }

    public void upgrade3Pressed(GameArena arena)
    {
        if (total >= 10000)
        {
            upgrade3++;
            cps = cps + 100;
            total = total - 10000;
            upgrade3Counter.setText("OWNED: " + Integer.toString(upgrade3));
            cpsCounter.setText(Integer.toString(cps));
            totalCookiesCounter.setText(Integer.toString(total));
        }
    }

    public void upgrade4Pressed(GameArena arena)
    {
        if (total >= 100000)
        {
            upgrade4++;
            cps = cps + 1000;
            total = total - 100000;
            upgrade4Counter.setText("OWNED: " + Integer.toString(upgrade4));
            cpsCounter.setText(Integer.toString(cps));
            totalCookiesCounter.setText(Integer.toString(total));
        }
    }

    public void cookieClicked()
    {
        total = total + cps;
        totalCookiesCounter.setText(Integer.toString(total));
    }

    public void cookieGeneration()
    {
        total = total + cps;
        totalCookiesCounter.setText(Integer.toString(total));
    }
}

//change the colours depending on the background input by the user
//or alternatively instead of having two seperate classes i could include the bg info in this class
