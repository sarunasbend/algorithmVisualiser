import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class BST<Key extends Comparable<Key>>{
    private Node root;

    private class Node{
        private Key key;
        private Node leftChild, rightChild;

        public Node(Key key){
            this.key = key;
        }
    }

    //calculate the number of right nodes from root
    public int treeRightSize(){
        return treeRightSize(root, 0); 
    }

    private int treeRightSize(Node x, int count){
        if (x == null){return count;}
        if (x.rightChild != null){
            return treeRightSize(x.rightChild, ++count);
        }
        return count;
    }

    //calculate the number of left nodes from root
    public int treeLeftSize(){
        return treeLeftSize(root, 0);
    }

    private int treeLeftSize(Node x, int count){
        if (x == null){return count;}
        if (x.leftChild != null){
            return treeLeftSize(x.leftChild, ++count);
        }
        return count;
    }

    //insert node function, setting first inserted as root
    public void insert(Key key){
        root = insert(root, key);
    }

    private Node insert(Node x, Key key){
        if (x == null){return new Node(key);}
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            x.leftChild = insert(x.leftChild, key);
        } else if (cmp > 0){
            x.rightChild = insert(x.rightChild, key);
        } 
        return x;
    }

    //finds the node with the least significant key
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.leftChild == null) return x.rightChild;
        else {
            x.leftChild = deleteMin(x.leftChild);
            return x;
        }
    }

    //finds the parent node of the child node
    private Node successor(Node x) {
        if (x == null || x.rightChild == null) return null;
        else {
            x = x.rightChild;
            while (x.leftChild != null) x = x.leftChild;
            return x; 
        }
    }

    //deletes node from tree
    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.leftChild = delete(x.leftChild, key);
        else if (cmp > 0) x.rightChild = delete(x.rightChild, key);
        else {
            if (x.rightChild == null) return x.leftChild;
            else if (x.leftChild == null) return x.rightChild;
            else {
                Node t = x;
                x = successor(t);
                x.rightChild = deleteMin(t.rightChild);
                x.leftChild = t.leftChild; 
            }
        }
        return x;
    }

    //inorder serach - returns an array of all the key values within the BST in order
    public int[] inOrder() {
        List<Integer> nodesList = new ArrayList<>();
        inOrder(root, nodesList);
        int[] nodesArray = new int[nodesList.size()];
        for (int i = 0; i < nodesList.size(); i++){
            nodesArray[i] = nodesList.get(i);
        }
        return nodesArray;
    }

    //pain in my asshole - Borat (and also me, cuz fuck this jesus)
    private void inOrder(Node x, List<Integer> nodes) {
        if (x != null)
        {
            inOrder(x.leftChild, nodes);
            int temp = x.key.hashCode();
            nodes.add(temp);
            inOrder(x.rightChild, nodes); 
        }
    }

    //preoder search - returns an int array of the keys in preorder
    public int[] preOrder() {
        List<Integer> nodesList = new ArrayList<>();
        preOrder(root, nodesList);
        int[] nodesArray = new int[nodesList.size()];
        for (int i = 0; i < nodesList.size(); i++){
            nodesArray[i] = nodesList.get(i);
        }
        return nodesArray;
    }

    private void preOrder(Node x, List<Integer> nodes) {
        if (x != null)
        {
            int temp = x.key.hashCode();
            nodes.add(temp);
            preOrder(x.leftChild, nodes);
            preOrder(x.rightChild, nodes); 
        }
    }

    //postorder search - returns an int array of the keys in postorder
    public int[] postOrder(){
        List<Integer> nodeList = new ArrayList<>();
        postOrder(root, nodeList);
        int[] nodesArray = new int[nodeList.size()];
        for (int i = 0; i <  nodeList.size(); i++){
            nodesArray[i] = nodeList.get(i);
        }
        return nodesArray;
    }

    private void postOrder(Node x, List<Integer> nodes){
        if (x != null){
            preOrder(x.leftChild, nodes);
            preOrder(x.rightChild, nodes);
            int temp = x.key.hashCode();
            nodes.add(temp);
        }
    }

    //gets the total number of nodes within the BST
    public int countNodes(){
        return countNodes(root, 0);
    }

    private int countNodes(Node x, int count){
        if (x != null){count++;} 
        if (x.rightChild != null){count = countNodes(x.rightChild, count);}
        if (x.leftChild != null){count = countNodes(x.leftChild, count);}
        return count;
    }

    //checks to see whether or not the node with inputted key has a right child
    public boolean hasRightChild(Key key){
        Node x = root;
        while (x != null){
            if (x.key.equals(key)){
                if (x.rightChild != null){
                    return true;
                }
                break;
            }
            int cmp = key.compareTo(x.key);
            if (cmp > 0){
                x = x.rightChild;
            } else if (cmp < 0){
                x = x.leftChild;
            }
        }
        return false;
    }

    //checks to see whether or not the node with the inpuuted key has a left child
    public boolean hasLeftChild(Key key){
        Node x = root;
        while (x != null){
            if (x.key.equals(key)){
                if (x.leftChild != null){
                    return true;
                }
                break;
            }
            int cmp = key.compareTo(x.key);
            if (cmp > 0){
                x = x.rightChild;
            } else if (cmp < 0){
                x = x.leftChild;
            }
        }
        return false;
    }

    //returns the integer value of the left child node of given node
    public int getLeftChild(Key key){
        Node x = root;
        while (x != null){
            if (x.key.equals(key)){
                if (x.leftChild != null){
                    return x.leftChild.key.hashCode();
                }
                break;
            }
            int cmp = key.compareTo(x.key);
            if (cmp > 0){ 
                x = x.rightChild;
            } else if (cmp < 0){
                x = x.leftChild;
            }
        }
        return 0;
    }

    //returns the integer value of the right child node of given node
    public int getRightChild(Key key){
        Node x = root;
        while (x != null){
            if (x.key.equals(key)){
                if (x.rightChild != null){
                    return x.rightChild.key.hashCode();
                }
                break;
            }
            int cmp = key.compareTo(x.key);
            if (cmp > 0){ 
                x = x.rightChild;
            } else if (cmp < 0){ 
                x = x.leftChild;
            }
        }
        return 0;
    }

    public int getRoot(){
        if (root != null){return root.key.hashCode();}
        return 0;
    }

    public Key getParentNode(Key key){
        return getParentNode(key, root);
    }
    
    private Key getParentNode(Key key, Node root){
        Node currentNode = root;
        Node previousNode = null;

        while (currentNode != null){
            int cmp = key.compareTo(currentNode.key);
            if (cmp > 0){
                previousNode = currentNode;
                currentNode = currentNode.rightChild;
            } else if (cmp < 0){
                previousNode = currentNode;
                currentNode = currentNode.leftChild;
            } else {
                return previousNode != null ? previousNode.key : null; //i have no idea what this line of code does but it makes it work lmao
            }
        }
        return null;
    }

    //find whether or not the node exists by traversing the bst, true if yes
    public boolean nodeExists(Key key){
        return nodeExists(root, key);
    }

    private boolean nodeExists(Node current, Key key){
        Node x = current;
        while (x != null){
            int cmp = key.compareTo(x.key);
            if (cmp < 0){x = x.leftChild;}
            else if (cmp > 0){x = x.rightChild;}
            else {return true;}
        }
        return false;
    }
}