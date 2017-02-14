package java8.Hackerrank.LinkedList;

import org.junit.Test;

/**
 * Created by jmelon on 17/12/2016.
 */
public class NodeTest {
    @Test
    public void mergeLists() throws Exception {
        Node a = createNodeChain(1,3,5,6);
        Node b = createNodeChain(2,4,7);
        System.out.println(a);
        System.out.println(b);

        Node result = a.MergeLists(a,b);
        System.out.println(result);

        a = createNodeChain(1,2,3,4,8,12,15);
        b = createNodeChain(0,5,6,7,8,9,11,18);
        result = a.MergeLists(a,b);
        System.out.println(result);

        a = null;
        b = createNodeChain(0,5,6,7,8,9,11,18);
        result = b.MergeLists(a,b);
        System.out.println(result);

        b = null;
        a = createNodeChain(0,5,6,7,8,9,11,18);
        result = a.MergeLists(a,b);
        System.out.println(result);

        a = null;
        b = null;
        Node dummy = new Node();
        result = dummy.MergeLists(a,b);
        System.out.println(result);
    }

    @Test
    public void reverse() throws Exception {
        Node head = createTestNode1();
        System.out.println(head);
        head = head.reverse();
        System.out.println(head);
    }

    private Node createNodeChain(int...numbers) {
        Node head = new Node();
        Node previous = head;

        for (int i : numbers) {
            Node n = new Node();
            n.data = i;
            previous.next = n;
            previous = n;
        }

        return head.next;
    }


    private static Node createTestNode1() {
        Node head = new Node();
        Node a = new Node();
        a.data = 1;
        Node b = new Node();
        b.data = 2;
        Node c = new Node();
        c.data = 3;

        head.next = a;
        a.next = b;
        b.next = c;

        return head;
    }

    @Test
    public void delete() {
        Node head = new Node();

        System.out.println(head.toString());
        head.delete(head,0);
        System.out.println(head.toString());
        head.delete(head,5);
        System.out.println(head.toString());

        head = createTestNode1();

        System.out.println(head.toString());
        head.delete(head,2);
        System.out.println(head.toString());
    }
}
