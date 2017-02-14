package java8.Hackerrank.Stacks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jmelon on 25/01/2017.
 */
public class SimpleTextEditorTest {
    @Test
    public void append() throws Exception {
        SimpleTextEditor ste = new SimpleTextEditor();
        ste.append("1234");
        assertEquals(ste.sb.length(),4);
        ste.append("567");
        assertEquals(ste.sb.length(),7);
        ste.append("");
        assertEquals(ste.sb.length(),7);
        assertEquals(ste.operations.size(),3);
    }

    @Test
    public void delete() throws Exception {
        SimpleTextEditor ste = new SimpleTextEditor();
        ste.append("123456789");
        ste.delete(0);
        assertEquals(ste.sb.length(),9);
        ste.delete(1);
        assertEquals(ste.sb.length(),8);
        assertEquals(ste.sb.toString(),"12345678");
        ste.delete(4);
        assertEquals(ste.sb.toString(),"1234");
        assertEquals(ste.operations.size(),4);
    }

    @Test
    public void print() throws Exception {
        SimpleTextEditor ste = new SimpleTextEditor();
        ste.append("123456789");
        assertEquals(ste.print(1),'1');
        assertEquals(ste.print(4),'4');
        assertEquals(ste.print(9),'9');
    }

    @Test
    public void undo() throws Exception {
        SimpleTextEditor ste = new SimpleTextEditor();
        ste.append("123456789");
        ste.delete(0);
        ste.delete(1);
        ste.delete(4);
        assertEquals(ste.sb.toString(),"1234");
        ste.undo();
        assertEquals(ste.sb.toString(),"12345678");
        ste.undo();
        assertEquals(ste.sb.toString(),"123456789");
        ste.undo();
        assertEquals(ste.sb.toString(),"123456789");
        ste.undo();
        assertEquals(ste.sb.length(),0);
    }

}