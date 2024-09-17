public class Button {
    public Button(GameArena window, int xCoord, int yCoord, int xSize, int ySize, String text){
        Rectangle outline = new Rectangle(xCoord, yCoord, xSize, ySize, "WHITE");
        Rectangle button = new Rectangle(xCoord + 5, yCoord + 5, xSize - 5, ySize - 5, "NODES");
        
        int temp = text.length();
        Text buttonText = new Text(text, 32, xCoord + (133 - ((temp / 2) * 32)) , 60, "#000000");

        window.addRectangle(outline);
        window.addRectangle(button);
        window.addText(buttonText);
    }
}
