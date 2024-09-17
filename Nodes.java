public class Nodes {
    //max of 63 nodes and 62 keys as it will have 6 layer as nodes will be too small on lower layers
    private Ball nodes[] = new Ball[63]; //nodes == keys
    private Text keys[] = new Text[63];
    private Line edges[] = new Line[62]; //edges = nodes - 1
    private Rectangle output;
    private Text outputText;

    public Nodes(GameArena window){
        output = new Rectangle(0, 800, 800, 200, "NODES");
        window.addRectangle(output);
        outputText = new Text("OUTPUT : ", 30, 20, 900, "BLACK");
        window.addText(outputText);
    }

    public void updateOutputText(String phrase){
        outputText.setText("OUTPUT : " + phrase);
    }

    //clears the window all balls, texts and lines
    public void clearWindow(GameArena window, BST<Integer> bst){
        //iterate through the arrays and clear them
        for (int i = 0; i < 63; i++){
            window.removeBall(nodes[i]);
            nodes[i] = null;
            window.removeText(keys[i]);
            keys[i] = null;
            if (i < 62){
                window.removeLine(edges[i]);
                edges[i] = null;
            }
        }
    }

    //for debugging the y-coords of nodes
    public void Ytemplate(GameArena window){
        Line template[] = new Line[6];

        for (int i = 0; i < 6; i++){
            template[i] = new Line(0, 200 + (i * 100), 800, 200 + (i * 100), 10, "#FF0000");
            window.addLine(template[i]);
        }

        Rectangle output = new Rectangle(0, 800, 800, 300, "#FFFFFF");
        window.addRectangle(output);
    }

    //for debugging the x-coords of nodes
    public void Xtemplate(GameArena window){
        Line template[];
        template = new Line[8];
        for (int i = 1; i < 9; i++){
            template[i - 1] = new Line(i * 100, 150, i * 100, 1000, 10, "#0000FF");
            window.addLine(template[i - 1]);
        }
    }

    //addition of new nodes into the window, relies on the fact that the key has not already been added to bst
    public void addNode(GameArena window, BST<Integer> bst, int keyToAdd){
        if (bst.getRoot() == 0){ //if there is no root node 
            for (int i = 0; 0 < 63; i++){
                if (nodes[i] == null){
                    nodes[i] = new Ball(400, 150, 100, "NODES");
                    window.addBall(nodes[i]); //node inserted into window
                    keys[i] = new Text(Integer.toString(keyToAdd), 10, 400, 150, "#FFFFFF");
                    window.addText(keys[i]); //text inserted into window
                    bst.insert(keyToAdd);
                    break;
                }
            }
        } else { //there is a root node already
            int temp = bst.getRoot();
            int depth = 1; //tracks the layer of the node
            if ((bst.hasLeftChild(temp) == false) && (temp > keyToAdd)){ //there is no left node and key to add is less than root
                for (int i = 0; i < 63; i++){
                    if (nodes[i] == null){
                        nodes[i] = new Ball(200, 250, 75, "NODES");
                        window.addBall(nodes[i]);
                        keys[i] = new Text(Integer.toString(keyToAdd), 10, 200, 250, "#FFFFFF");
                        window.addText(keys[i]);
                        bst.insert(keyToAdd);
                        break;
                    }
                }
            } else if ((bst.hasLeftChild(temp) == true) && (temp > keyToAdd)){ //there is a left node of root and add is less than root
                temp = bst.getLeftChild(temp);
                boolean found = false; //check condition for when location of node has been found
                depth++;
                while (found != true){ //will iterate through the bst until the correct location has been found, inserting after location has been found both into window and bst
                    if ((temp > keyToAdd) && (bst.hasLeftChild(temp) == true)){
                        temp = bst.getLeftChild(temp);
                        depth++;
                    } else if ((temp > keyToAdd) && (bst.hasLeftChild(temp) == false)){
                        for (int i = 0; i < 63; i++){
                            if (nodes[i] == null){
                                bst.insert(keyToAdd);
                                int xCoordTemp = bst.getParentNode(keyToAdd);
                                xCoordTemp = findIndex(xCoordTemp);
                                double xCoord = nodes[xCoordTemp].getXPosition(); //gets the x-coord of the parent node, which will then be used to calculate its position
                                nodes[i] = new Ball((xCoord) - (xCoord / 2), 150 + (100 * depth), (150 / depth), "NODES"); //calculates the position of the node, will be left of root and will depend on the depth
                                window.addBall(nodes[i]);
                                keys[i] = new Text(Integer.toString(keyToAdd), 10, (xCoord) - (xCoord / 2), 150 + (100 * (depth)), "#FFFFFF");
                                window.addText(keys[i]);
                                found = true;
                                break;
                            }
                        }
                    } else if ((temp < keyToAdd) && (bst.hasRightChild(temp) == true)){
                        temp = bst.getRightChild(temp);
                        depth++;
                    } else if ((temp < keyToAdd) && (bst.hasRightChild(temp) == false)){
                        for (int i = 0; i < 63; i++){
                            if (nodes[i] == null){
                                bst.insert(keyToAdd);
                                int xCoordTemp = bst.getParentNode(keyToAdd);
                                xCoordTemp = findIndex(xCoordTemp);
                                double xCoord = nodes[xCoordTemp].getXPosition();
                                nodes[i] = new Ball(((xCoord) + (xCoord / 2)), 150 + (100 * (depth)), (150 / depth), "NODES");
                                window.addBall(nodes[i]);
                                keys[i] = new Text(Integer.toString(keyToAdd), 10, (xCoord) + (xCoord / 2), 150 + (100 * depth), "#FFFFFF");
                                window.addText(keys[i]);
                                found = true;
                                break;
                            }
                        }
                    }
                }
            } else if ((bst.hasRightChild(temp) == false) && (temp < keyToAdd)){
                for (int i = 0; i < 63; i++){
                    if (nodes[i] == null){
                        nodes[i] = new Ball(600, 150 + (100 * (depth)), 75, "NODES");
                        window.addBall(nodes[i]);
                        keys[i] = new Text(Integer.toString(keyToAdd), 10, 600, 150 + (100 * depth), "#FFFFFF");
                        window.addText(keys[i]);
                        bst.insert(keyToAdd);
                        break;
                    }
                }
            } else if ((bst.hasRightChild(temp) == true) && (temp < keyToAdd)){
                temp = bst.getRightChild(temp);
                boolean found = false;
                depth++;
                while (found != true){
                    if ((bst.hasLeftChild(temp) == true) && (temp > keyToAdd)){
                        temp = bst.getLeftChild(temp);
                        depth++;
                    } else if ((bst.hasLeftChild(temp) == false) && (temp > keyToAdd)){
                        for (int i = 0; i < 63; i++){
                            if (nodes[i] == null){
                                bst.insert(keyToAdd);
                                int xCoordTemp = bst.getParentNode(keyToAdd);
                                xCoordTemp = findIndex(xCoordTemp);
                                double xCoord = nodes[xCoordTemp].getXPosition();
                                nodes[i] = new Ball((xCoord + (xCoord / 2)) - 400, 150 + (100 * depth), (150 / depth), "NODES");
                                window.addBall(nodes[i]);
                                keys[i] = new Text(Integer.toString(keyToAdd), 10, (xCoord + (xCoord / 2)) - 400, 150 + (100 * depth), "#FFFFFF");
                                window.addText(keys[i]);
                                found = true;
                                break;
                            }
                        }
                    } else if ((bst.hasRightChild(temp) == true) && (temp < keyToAdd)){
                        temp = bst.getRightChild(temp);
                        depth++;
                    } else if ((bst.hasRightChild(temp) == false) && (temp < keyToAdd)){
                        for (int i = 0; i < 63; i++){
                            if (nodes[i] == null){
                                bst.insert(keyToAdd);
                                int xCoordTemp = bst.getParentNode(keyToAdd);
                                xCoordTemp = findIndex(xCoordTemp);
                                double xCoord = nodes[xCoordTemp].getXPosition();
                                nodes[i] = new Ball((xCoord - (xCoord / 2)) + 400, 150 + (100 * depth), (150 / depth), "NODES");
                                window.addBall(nodes[i]);
                                keys[i] = new Text(Integer.toString(keyToAdd), 10, (xCoord - (xCoord / 2)) + 400, 150 + (100 * depth), "#FFFFFF");
                                window.addText(keys[i]);
                                found = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }


    //method for adding edges, seperate from addNode or removeNode to reduce complexity
    public void addEdges(GameArena window, BST<Integer> bst){
        for (int index = 0; index < 62; index++){
            if (edges[index] != null){window.removeLine(edges[index]);}
        }

        for (int index = 0; index < 62; index++){
            if ((nodes[index] != null) && (bst.hasLeftChild(Integer.parseInt(keys[index].getText())) == true)){
                int childNodeValue = bst.getLeftChild(Integer.parseInt(keys[index].getText()));
                int childNodeIndex = findIndex(childNodeValue);
                edges[index] = new Line(nodes[index].getXPosition(), nodes[index].getYPosition(), nodes[childNodeIndex].getXPosition(), nodes[childNodeIndex].getYPosition(), 10, "EDGES");
                window.addLine(edges[index]);
            }
            if ((nodes[index] != null) && (bst.hasRightChild(Integer.parseInt(keys[index].getText())) == true)){
                int childNodeValue = bst.getRightChild(Integer.parseInt(keys[index].getText()));
                int childNodeIndex = findIndex(childNodeValue);
                edges[index] = new Line(nodes[index].getXPosition(), nodes[index].getYPosition(), nodes[childNodeIndex].getXPosition(), nodes[childNodeIndex].getYPosition(), 10, "EDGES");
                window.addLine(edges[index]);
            }
        }
    }

    //find the corresponding node within the tree, giving index for nodes/keys array
    //this solution assumes that the index of the text and node are the same
    private int findIndex(int valueToFind){
        for (int index = 0; index < 63; index++){
            if (Integer.toString(valueToFind).equals(keys[index].getText())){
                return index;
            }
        }
        return 99;
    }

    //removes the specified node, by clearing the window, and readding all the necessary nodes into the window and bst
    public void removeNode(GameArena window, BST<Integer> bst, int keyToDel){
        bst.delete(keyToDel);
        int preOrderArray[] = bst.preOrder();
        clearWindow(window, bst);
        for (int index = 0; index < preOrderArray.length; index++){
            bst.delete(preOrderArray[index]);
        }

        for (int index = 0; index < preOrderArray.length; index++){
            addNode(window, bst, preOrderArray[index]);
        }

        addEdges(window, bst);
    }

    //debugging method that gets coords of all nodes within the window
    public void getPositionsOfNodes(){
        for (int i = 0; i < 63; i++){
            if (nodes[i] != null){
                System.out.println( keys[i].getText() + " : "+ "("+ nodes[i].getXPosition() + ", " + nodes[i].getYPosition() + ")");
            }
        }
    }

    public void preOrder(GameArena window, BST<Integer> bst){
        int preOrderArray[] = bst.preOrder();
        for (int index = 0; index < bst.countNodes(); index++){
            int nodeIndex = findIndex(preOrderArray[index]);
            nodes[nodeIndex].setColour("RED");
            window.addBall(nodes[nodeIndex]);
            window.addText(keys[nodeIndex]);
            try {
                Thread.sleep(2000);
                nodes[nodeIndex].setColour("NODES");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        updateOutputText("PRE-ORDER " + arrayConcatenation(preOrderArray, bst.countNodes()));
    }

    public void inOrder(GameArena window, BST<Integer> bst){
        int inOrderArray[] = bst.inOrder();
        for (int index = 0; index < bst.countNodes(); index++){
            int nodeIndex = findIndex(inOrderArray[index]);
            nodes[nodeIndex].setColour("RED");
            window.addBall(nodes[nodeIndex]);
            window.addText(keys[nodeIndex]);
            try {
                Thread.sleep(2000);
                nodes[nodeIndex].setColour("NODES");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        updateOutputText("IN-ORDER " + arrayConcatenation(inOrderArray, bst.countNodes()));
    }

    public void postOrder(GameArena window, BST<Integer> bst){
        int postOrderArray[] = bst.postOrder();
        for (int index = 0; index < bst.countNodes(); index++){
            int nodeIndex = findIndex(postOrderArray[index]);
            nodes[nodeIndex].setColour("RED");
            window.addBall(nodes[nodeIndex]);
            window.addText(keys[nodeIndex]);
            try {
                Thread.sleep(2000);
                nodes[nodeIndex].setColour("NODES");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        updateOutputText("POST-ORDER " + arrayConcatenation(postOrderArray, bst.countNodes()));
    }

    private String arrayConcatenation(int[] array, int arraySize){
        String text = "[";
        for (int index = 0; index < arraySize; index++){
            if (index % 6 == 0){
                text = text + "\n";
            }
            text = text + String.valueOf(array[index]) + ", ";
        }
        return (text + "]");
    }

}
