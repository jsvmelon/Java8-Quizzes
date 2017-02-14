package java8.Hackerrank.Trees.ArraySimpleQuries;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by jmelon on 02/01/2017.
 */
public class BinaryLevelNode<T> {

    // height is the distance to the furthest leaf
    int height;
    int numberOfLeftLeaves;
    int numberOfRightLeaves;

    BinaryLevelNode<T> left;

    BinaryLevelNode<T> right;
    BinaryLevelNode<T> parent;
    // a node is balanced if left and right are balanced;
    // a node is not balanced if only one child is empty;
    // a leaf is balanced;
    boolean isComplete;

    T data;

    public void setLeft(BinaryLevelNode left) {
        this.left = left;
        left.parent = this;
        setIsComplete();
    }

    public void setRight(BinaryLevelNode right) {
        this.right = right;
        right.parent = this;
        setIsComplete();
    }

    public void setIsComplete() {
        this.isComplete = this.left != null && this.left.isComplete && this.right != null && this.right.isComplete;
        BinaryLevelNode<T> n = parent;
        while (n != null) {
            boolean before = n.isComplete;
            n.isComplete = n.left != null && n.left.isComplete && n.right != null && n.right.isComplete;
            if (before == n.isComplete) break;
            n = n.parent;
        }
    }

    // inner nodes shouldn't be created by the user
    private BinaryLevelNode() {
        numberOfLeftLeaves = 0;
        numberOfRightLeaves = 0;
        height = 0;
        isComplete = true;
    }

    private BinaryLevelNode(BinaryLevelNode<T> parent) {
        this();
        this.parent = parent;
    }

    @Contract("null, null -> fail")
    private BinaryLevelNode(BinaryLevelNode<T> left, BinaryLevelNode<T> right) {
        this();
        // sanity checks
        if (left == null && right == null) throw new RuntimeException("Not both nodes can be null");
        if (left != null && right != null && (left.height != right.height))
            throw new RuntimeException("Subtree heights must be equal");

        // set the values
        this.setLeft(left);
        this.setRight(right);
        if (left == null || right == null) incomplete();

        if (left != null) left.parent = this;
        if (right != null) right.parent = this;

        this.isComplete = left != null && left.isComplete && right != null && right.isComplete;

        // set the height
        if (left == null) height = right.height + 1;
        else if (right == null) height = left.height + 1;
        else height = left.height > right.height ? left.height + 1 : right.height + 1;
    }

    public BinaryLevelNode(T data) {
        this();
        this.data = data;
    }

    // marks the current node and all parents to the root as incomplete
    private void incomplete() {
        this.isComplete = false;
        BinaryLevelNode<T> p = parent;
        while (p != null) {
            p.isComplete = false;
            p = p.parent;
        }
    }

    public BinaryLevelNode<T> insertLeft(T data) {
        return insertLeft(new BinaryLevelNode(data));
    }

    public BinaryLevelNode<T> insertRight(T data) {
        return insertRight(new BinaryLevelNode());
    }

    // returns the root (which might be changed by this method)
    public BinaryLevelNode<T> insertLeft(BinaryLevelNode<T> node) {
        BinaryLevelNode<T> root = getRoot();

        // a complete tree needs a new root for left insertion (and right as well)
        // a leaf is a complete tree too
        if (root.isComplete) {
            BinaryLevelNode<T> branch;
            if (root.height - node.height > 0) // CAREFUL: the current root height is one less than the new root height!
                branch = createLeftBranch(root.height - node.height, node);
            else
                branch = node;
            root = new BinaryLevelNode<T>(branch, root);
            root.isComplete = root.left.isComplete && root.right.isComplete; // should be false actually
        } else {
            BinaryLevelNode<T> candidate = getLeftorphanNodeAtHeight(node.height + 1,
                    (BinaryLevelNode<T> b) -> {return b.left;});
            if (candidate.parent == null) { // it's the root
                if (candidate.left == null) candidate.setLeft(node);
                else { // a new root needs to be created
                    BinaryLevelNode<T> newRoot = createLeftBranch(root.height - node.height, node);
                    newRoot.setLeft(root);
                    return newRoot;
                }
            } else {
                // left must be null !
                candidate.setLeft(createLeftBranch(candidate.height - node.height - 1, node));
                return root;
            }
        }

        return root;
    }

    public BinaryLevelNode<T> getLeftmostLeaf() {
        BinaryLevelNode<T> n = this;

        while (n.left != null || n.right != null) {
            if (n.left != null) n = n.left;
            else if (n.right != null) n = n.right;
            else return n;
        }
        return n;
    }


    /*
     * Finds
     * - a node with the requested or higher height
     * - that has no left child
     * - all leafs in the tree are on the right of the node
     *
     * Or the root node.
     */
    public BinaryLevelNode<T> getLeftorphanNodeAtHeight(int height,
                                                        Function<BinaryLevelNode, BinaryLevelNode> target,
                                                        Function<BinaryLevelNode, BinaryLevelNode> opposite) {
        BinaryLevelNode<T> node;

        // should move from the left-most leaf towards the root
        node = this.getRoot().getLeftmostLeaf();
        while (node.parent != null) {
            node = node.parent;
            if (node.height >= height) {
                if (node.left == null) return node;
                else if (node.right == null) { // swap
                    node.right = node.left;
                    node.left = null;
                    return node;
                }
            }
        }
        return node;
    }

    /*
     * Creates sequence of nodes. Each node is a right child of the predecessor.
     * @param length is the number of nodes in the sequence
     * @param node will be inserted at the end of the sequence on the right.
     * @param startHeight is the height of the root
     * @returns The root of the sequence.
     */
    protected BinaryLevelNode<T> createLeftBranch(int length, BinaryLevelNode<T> node) {
        if (length < 0) throw new RuntimeException("height must be >= 0");

        if (length == 0) return node;

        int startHeight = node.height + length;
        int i = 1;
        BinaryLevelNode<T> root = new BinaryLevelNode<T>();
        root.height = startHeight;
        BinaryLevelNode<T> n = root;
        while (i < length) {
            n = new BinaryLevelNode<T>(n);
            n.height = startHeight - i;
            n.parent.setRight(n); // insert right to allow for further left inserts
            n.parent.isComplete = false;
            i++;
        }
        n.setRight(node);
        return root;
    }

    // returns the root (which might be changed by this method)
    public BinaryLevelNode<T> insertRight(BinaryLevelNode<T> node) {
        BinaryLevelNode<T> root = node;
        // TODO
        return root;
    }

    public List<BinaryLevelNode<T>> getNodesForInterval(int left, int right) {
        // TODO

        return null;
    }

    /*
     * @returns the root node (which may be changed by this method)
     */
    public BinaryLevelNode<T> moveNodesLeft(List<BinaryLevelNode<T>> nodes) {
        BinaryLevelNode root = this;
        // TODO
        return root;
    }

    /*
     * @returns the root node (which may be changed by this method)
     */
    public BinaryLevelNode<T> moveNodesRight(List<BinaryLevelNode<T>> nodes) {
        BinaryLevelNode root = this;
        // TODO
        return root;
    }

    public T getData(int index) {
        // TODO
        return null;
    }

    public List<T> getLeaves() {
        List<T> result = new ArrayList<T>();

        if (left == null && right == null) {
            result.add(data);
        } else {
            if (left != null) result.addAll(left.getLeaves());
            if (right != null) result.addAll(right.getLeaves());
        }

        return result;
    }

    public BinaryLevelNode<T> getRoot() {
        BinaryLevelNode<T> n = this;
        while (n.parent != null) n = n.parent;
        return n;
    }

    public String toString() {
        return toString(0);
    }

    private String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent - 1; i++) sb.append("     ");
        if (left == null && right == null) {
            sb.append("+----").append(this.data).append(System.lineSeparator());
            return sb.toString();
        }
        if (indent == 0) {
            if (isComplete) sb.append("C").append(System.lineSeparator());
            else sb.append("I").append(System.lineSeparator());
        }
        else {
            if (isComplete) sb.append("+----C").append(System.lineSeparator());
            else sb.append("+----I").append(System.lineSeparator());
        }
        if (left != null) sb.append(left.toString(indent + 1));
        else {
            for (int i = 0; i < indent; i++) sb.append("     ");
            sb.append("+---- left null").append(System.lineSeparator());
        }
        if (right != null) sb.append(right.toString(indent + 1));
        else {
            for (int i = 0; i < indent; i++) sb.append("     ");
            sb.append("+----right null").append(System.lineSeparator());
        }
        return sb.toString();
    }

}
