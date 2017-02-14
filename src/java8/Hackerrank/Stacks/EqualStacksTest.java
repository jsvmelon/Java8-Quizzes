package java8.Hackerrank.Stacks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jmelon on 20/01/2017.
 */
public class EqualStacksTest {
    @Test
    public void fillStack() throws Exception {
        EqualStacks es = new EqualStacks();
        es.fillStack1("3 2 1 1 1");
        es.fillStack2("4 3 2");
        es.fillStack3("1 1 4 1");

        assertEquals(es.stack1.peek().a.intValue(),3);
        assertEquals(es.stack2.peek().a.intValue(),4);
        assertEquals(es.stack3.peek().a.intValue(),1);

        assertEquals(es.stack1.peek().b.intValue(), 8);
        assertEquals(es.stack2.peek().b.intValue(), 9);
        assertEquals(es.stack3.peek().b.intValue(), 7);
    }

    @Test
    public void equalise() throws Exception {
        EqualStacks es = new EqualStacks();
        es.fillStack1("3 2 1 1 1");
        es.fillStack2("4 3 2");
        es.fillStack3("1 1 4 1");

        assertEquals(es.stack1.peek().b.intValue(), 8);
        assertEquals(es.stack2.peek().b.intValue(), 9);
        assertEquals(es.stack3.peek().b.intValue(), 7);

        assertEquals(es.equalise(),5);
    }

}