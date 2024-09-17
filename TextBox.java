import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextBox {
    private String function;

    public TextBox(String text, BST<Integer> bst, Nodes nodes, GameArena window){
        this.function = text;
        JFrame x = new JFrame();
        JTextField input = new JTextField();
        JButton button = new JButton(this.function);
        button.setBounds(200, 0, 100, 50);
        x.add(button);
        input.setBounds(0, 0, 200, 50);
        x.add(input);
        x.setSize(300, 100);
        x.setLayout(null);
        x.setVisible(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (function.equals("ADD")){
                    int temp = Integer.parseInt(input.getText());
                    if (!bst.nodeExists(temp)){
                        nodes.addNode(window, bst, temp);
                        nodes.addEdges(window, bst); //testing
                        nodes.updateOutputText(text + "ED" + " " + String.valueOf(temp));
                        x.dispose();
                    }
                } else if (function.equals("REMOVE")){
                    int temp = Integer.parseInt(input.getText());
                    if (bst.nodeExists(temp)){
                        nodes.removeNode(window, bst, temp);
                        nodes.addEdges(window, bst); //testing
                        nodes.updateOutputText(text + "D" + " " + String.valueOf(temp));
                        x.dispose();
                    }
                /*} else if (function.equals("PRE-ORDER")){
                    nodes.preOrder(window, bst);
                    nodes.updateOutputText(text + " " + arrayConcatenation(bst.preOrder(), bst.countNodes()));
                    x.dispose();

                } else if (function.equals("IN-ORDER")){
                    nodes.inOrder(window, bst);
                    nodes.updateOutputText(text + " " + arrayConcatenation(bst.inOrder(), bst.countNodes()));
                    x.dispose();
                } else if (function.equals("POST-ORDER")){
                    nodes.postOrder(window, bst);
                    nodes.updateOutputText(text + " " + arrayConcatenation(bst.postOrder(), bst.countNodes()));
                    x.dispose();
                }*/
                }
            }
        });
    }
}
