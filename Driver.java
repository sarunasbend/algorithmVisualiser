public class Driver 
{
    public static void main(String[] args) {
        GameArena window = new GameArena(800, 1000);
        Background background = new Background(window, 800, 900);

        //if pressed will call a function of BST
        Button addButton = new Button(window, 0, 0, 266, 100, "ADD");
        Button removeButton = new Button(window, 266, 0, 266, 100, "REMOVE");
        Button searchButton = new Button(window,532, 0, 266, 100, "SEARCH");

        BST<Integer> bst = new BST<>();
        Nodes nodes = new Nodes(window);
        
        boolean mouseClicked = false; //used as a flag to indicate whether or not the mouse click has been processed
        while (true){ //main program loop
            window.pause();         
            if ((window.leftMousePressed()) && (!mouseClicked)){
                mouseClicked = true; //indicates that the mouse click is about to be processed 
                int xCoord = window.getMousePositionX();
                int yCoord = window.getMousePositionY();
                if ((xCoord >= 0) && (xCoord <=266) && (yCoord >= 0) && (yCoord <= 100)){
                    TextBox add = new TextBox("ADD", bst, nodes, window);
                } else if ((xCoord >= 266) && (xCoord <= 532) && (yCoord >= 0) && (yCoord <= 100)){
                    TextBox remove = new TextBox("REMOVE", bst, nodes, window);
                } else if ((xCoord >= 532) && (xCoord <= 800) && (yCoord >= 0) && (yCoord <= 100)){
                    nodes.preOrder(window, bst);
                    //TextBox test = new TextBox("PRE-ORDER", bst, nodes, window);
                }
            }
            
            if (!window.leftMousePressed()){ //resets the flag to allow for a new mouse click
                mouseClicked = false;
            }
        }
    }
}
//@debug
//issue of coliding nodes due to the formula i have used
//duplicate edges when removing nodes, meaning that some will remain after
//create unique buttons for pre, in, post orders of the bst
//upload to git hub for others to see and test out ig

//think about future development/future iterations of this project
//red-black trees
//better organised and coordinated code




