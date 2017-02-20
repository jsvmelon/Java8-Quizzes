package java8.Hackerrank.Trees.ArraySimpleQuries;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jmelon on 03/01/2017.
 */
public class BinaryLevelNodeTest {
    @Test
    public void getLeftNodeAtMinHeight() {
        BinaryLevelNode<Integer> root = new BinaryLevelNode<>(1).insertLeft(2);
        assertEquals(root,root.getLeftorphanNodeAtHeight(1,(b) -> {return b.left;},(b) -> {return b.right;}));
        assertEquals(root,root.getLeftorphanNodeAtHeight(0,(b) -> {return b.left;},(b) -> {return b.right;}));

        root = root.insertLeft(3).insertLeft(4).insertLeft(5);
        System.out.println(root);
        assertEquals(5,root.getLeftorphanNodeAtHeight(0,(b) -> {return b.left;},(b) -> {return b.right;}).right.data.intValue());
        assertEquals(5,root.getLeftorphanNodeAtHeight(1,(b) -> {return b.left;},(b) -> {return b.right;}).right.data.intValue());
        assertEquals(2,root.getLeftorphanNodeAtHeight(2,(b) -> {return b.left;},(b) -> {return b.right;}).height);
    }

    @Test
    public void getLeftmostLeaf() throws Exception {
        BinaryLevelNode<Integer> root = new BinaryLevelNode<>(1);
        BinaryLevelNode<Integer> leafOne = root;
        assertEquals(root.getLeftmostLeaf(),root);

        root = root.insertLeft(2);
        assertEquals(root.getLeftmostLeaf().data.intValue() , 2);
        root = root.insertLeft(3).insertLeft(4).insertLeft(5).insertLeft(6);
        System.out.println(root);
        assertEquals(root.getLeftmostLeaf().data.intValue() , 6);

        assertEquals(root.right.getLeftmostLeaf().data.intValue(),4);
        assertEquals(leafOne.getLeftmostLeaf(),leafOne);
    }

    @Test
    public void setLeft() throws Exception {
        BinaryLevelNode<Integer> root = new BinaryLevelNode<>(1).insertLeft(2).insertLeft(3);
        System.out.println(root);
        assertFalse(root.isComplete);
        assertEquals(root.left.left, null);
        root.left.setLeft(new BinaryLevelNode(4));
        System.out.println(root);
        assertTrue(root.isComplete);
    }

    @Test
    public void insertLeftBasic() throws Exception {
        BinaryLevelNode<Integer> root = new BinaryLevelNode<>(1);
        BinaryLevelNode<Integer> resultRoot;

        System.out.println("Case 1");
        resultRoot = root.insertLeft(new BinaryLevelNode<>(2));
        System.out.println(resultRoot.toString());
        assertNotEquals(resultRoot,root);
        assertEquals(resultRoot.height,1);
        assertEquals(resultRoot.right.data.intValue(),1);
        assertEquals(resultRoot.left.data.intValue(), 2);
        assertTrue(resultRoot.isComplete);

        System.out.println("Case 2");
        root = resultRoot;
        resultRoot = root.insertLeft(new BinaryLevelNode<>(3));
        System.out.println(resultRoot.toString());
        assertEquals(resultRoot.height,2);
        assertEquals(resultRoot.isComplete, false);
        assertTrue(resultRoot.left != null);
        assertEquals(resultRoot.left.isComplete, false);
        assertTrue(resultRoot.right != null);
        assertEquals(resultRoot.right.isComplete, true);
        assertEquals(resultRoot.left.right.data.intValue(), 3);
        assertEquals(resultRoot.right.left.data.intValue(), 2);
        assertEquals(resultRoot.right.right.data.intValue(), 1);

        System.out.println("Case 3");
        root = resultRoot;
        resultRoot = root.insertLeft(new BinaryLevelNode<>(4));
        System.out.println(resultRoot.toString());
        assertEquals(resultRoot, root);
        assertEquals(resultRoot.height,2);
        assertEquals(resultRoot.left.left.data.intValue(), 4);
        assertEquals(resultRoot.left.right.data.intValue(), 3);
        assertEquals(resultRoot.right.left.data.intValue(), 2);
        assertEquals(resultRoot.right.right.data.intValue(), 1);
        assertTrue(resultRoot.isComplete);
        assertTrue(resultRoot.left.isComplete);
        assertTrue(resultRoot.right.isComplete);

        System.out.println("Case 4");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) resultRoot = resultRoot.insertLeft(new BinaryLevelNode<Integer>(i));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(resultRoot.getLeaves().toString());
    }

    /*
     * The complex cases are actually inserting subtrees with a height > 0
     */
    @Test
    public void insertLeftComplex() throws Exception {
        BinaryLevelNode<Integer> root = new BinaryLevelNode<Integer>(new Integer(1));
        System.out.println(root);
        for (int i = 2; i < 9; i++) {
            root = root.insertLeft(new BinaryLevelNode<>(i));
            System.out.println(root);
        }

        assertEquals(root.height,3);
        assertTrue(root.isComplete);

        BinaryLevelNode<Integer> subtree = new BinaryLevelNode<>(new Integer(10));
        subtree = subtree.insertLeft(new BinaryLevelNode<>(11));
        root = root.insertLeft(subtree);
        System.out.println(root);

        assertEquals(root.height,4);

        System.out.println("Ripping out test case ...");

        // TODO: rip out a part of the tree and insert it left
        BinaryLevelNode<Integer> rip = root.right;
        root.right = null;
        rip.parent = null;
        root.isComplete = false;
        System.out.println("old tree after ripping:");
        System.out.println(root);
        System.out.println("ripped out tree:");
        System.out.println(rip);
        root = root.insertLeft(rip);
        System.out.println("complete tree after insert:");
        System.out.println(root);

        assertEquals(root.height,4);
        assertFalse(root.isComplete);
        assertTrue(root.left.isComplete);
        assertEquals(root.left.left.left.left.data.intValue(),8);
    }

    @Test
    public void getLeftNode() throws Exception {

    }

    @Test
    public void createLeftBranch() throws Exception {
        BinaryLevelNode<Integer> leaf = new BinaryLevelNode<Integer>(new Integer(1));
        assertTrue(leaf.left == null);
        assertTrue(leaf.right == null);
        assertEquals(leaf.data.intValue(),1);

        BinaryLevelNode<Integer> root = leaf.createLeftBranch(2,leaf);
        System.out.println(root.toString());

        assertTrue(root != null);
        assertEquals(root.height,2);
        assertTrue(root.left == null);
        assertTrue(root.right != null);
        assertTrue(root.right.left == null);
        assertTrue(root.right.right == leaf);

        // edge cases
        leaf = new BinaryLevelNode<Integer>(new Integer(1));
        root = leaf.createLeftBranch(0,leaf);
        assertEquals(root,leaf);
    }

    @Test
    public void getRoot() throws Exception {

    }

}