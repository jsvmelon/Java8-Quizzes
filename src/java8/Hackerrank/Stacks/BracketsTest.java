package java8.Hackerrank.Stacks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jmelon on 20/01/2017.
 */
public class BracketsTest {
    @Test
    public void checkSequence() throws Exception {
        assertTrue(Brackets.checkSequence(""));
        assertTrue(Brackets.checkSequence("()"));
        assertTrue(Brackets.checkSequence("[]"));
        assertTrue(Brackets.checkSequence("{}"));
        assertTrue(Brackets.checkSequence("{()}"));
        assertTrue(Brackets.checkSequence("{([])}"));
        assertTrue(Brackets.checkSequence("[[]]"));
        assertTrue(Brackets.checkSequence("[[([[]])]]"));

        assertFalse(Brackets.checkSequence("["));
        assertFalse(Brackets.checkSequence("("));
        assertFalse(Brackets.checkSequence("{"));
        assertFalse(Brackets.checkSequence("]"));
    }

}