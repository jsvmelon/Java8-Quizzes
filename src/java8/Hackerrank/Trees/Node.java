package java8.Hackerrank.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmelon on 19/12/2016.
 */
public class Node {

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    private int data;
    private Node left;
    private Node right;

    public Node(Node left, Node right, int data) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    List<String> orderPerLevel = new ArrayList<>();

    public void levelOrder(Node root) {
        orderPerLevel.clear();

        levelOrder(root, 0);

        for (String s : orderPerLevel) {
            System.out.print(s + " ");
        }
    }

    private void levelOrder(Node root, int height) {
        String s;
        if (orderPerLevel.size() <= height) {
            s = Integer.toString(root.data);
            orderPerLevel.add(s);
        } else {
            s = orderPerLevel.get(height);
            s += " " + Integer.toString(root.data);
            orderPerLevel.set(height, s);
        }

        if (root.left != null) levelOrder(root.left, height + 1);
        if (root.right != null) levelOrder(root.right, height + 1);
    }
}
