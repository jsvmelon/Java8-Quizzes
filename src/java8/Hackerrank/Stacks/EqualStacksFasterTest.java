package java8.Hackerrank.Stacks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jmelon on 23/01/2017.
 */
public class EqualStacksFasterTest {
    @Test
    public void equalise() throws Exception {
        EqualStacksFaster.h1 = new int[] {1,1,1,1,2};
        EqualStacksFaster.h2 = new int[] {3,7};
        EqualStacksFaster.h3 = new int[] {1,3,1};
        EqualStacksFaster.header1 = 0;
        EqualStacksFaster.header2 = 0;
        EqualStacksFaster.header3 = 0;
        EqualStacksFaster.height1 = 6;
        EqualStacksFaster.height2 = 10;
        EqualStacksFaster.height3 = 5;

        assertEquals(EqualStacksFaster.equalise(),0);

        /*
Input
5 2 3
1 1 1 1 2
3 7
1 3 1

Expected output
0
 */
    }

}