package java8.Hackerrank.Trees;

import org.junit.Test;

/**
 * Created by jmelon on 19/12/2016.
 */
public class NodeTest {

    @Test
    public void levelOrderTest() {
        Node root = createTree(2);
        printTree(root);
        System.out.println("");
        root.levelOrder(root);
    }

    // creates a full tree
    private Node createTree(int levels) {
        Node n;
        if (levels == 0){
            n = new Node(null, null, levels);
            return n;
        }

        n = new Node(createTree(levels - 1),createTree(levels - 1),levels);
        return n;
    }

    private void printTree(Node root) {
        if (root.getLeft() != null) {
            printTree(root.getLeft());
            System.out.print(" ");
        }
        System.out.print(root.getData());
        if (root.getRight() != null) {
            System.out.print(" ");
            printTree(root.getRight());
        }
    }
}
