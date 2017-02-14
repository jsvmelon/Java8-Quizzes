package java8.Hackerrank.LinkedList;

/**
 * Created by jmelon on 16/12/2016.
 */
public class Node {
    public int data;
    public Node next;

    public Node delete(Node head, int position) {
        // Complete this method
        if (head == null) return null;
        if (position == 0) return head.next;

        Node node = head;
        int k = 1;

        // the position given could be after the last node
        while(k < position && node.next != null) {
            node = node.next;
            k++;
        }

        // strange case: trying to delete the node after the last non-null node - which is null itself
        if (node.next == null) return head;

        node.next = node.next.next;

        return head;
    }

    public Node reverse() {
        if (this == null) return this;
        if (this.next == null) return this;

        Node previous = null;
        Node after;
        Node node = this;

        while (node.next != null) {
            after = node.next;      // save the next node for moving forward
            node.next = previous;   // set the next link to the predecessor
            previous = node;        // set previous to the current node
            node = after;           // use after to move forward
        }

        node.next = previous;

        return node;
    }

    public Node MergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method

        Node newHead;
        Node runner;
        Node other;

        if (headA == null) return headB;
        if (headB == null) return headA;

        if (headA.data <= headB.data) {
            runner = headA;
            other = headB;
            newHead = headA;
        } else  {
            runner = headB;
            other = headA;
            newHead = headB;
        }

        while (runner.next != null || other != null) {
            if (runner.next == null) {
                runner.next = other;
                return newHead;
            }
            if (other == null) return newHead;

            if (runner.next.data <= other.data) {
                runner = runner.next;
            } else {
                Node tmp = runner.next;
                runner.next = other;
                runner = runner.next;
                other = tmp;
            }
        }

        return newHead;
    }

    @Override
    public String toString() {
        String result = Integer.toString(data);

        if (next != null) {
            result += " -> " + next.toString();
        } else result += "-> NULL";

        return result;
    }

}
