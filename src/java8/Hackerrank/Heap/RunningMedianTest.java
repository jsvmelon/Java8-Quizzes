package java8.Hackerrank.Heap;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jmelon on 16/01/2017.
 */
public class RunningMedianTest {
    @Test
    public void insert() throws Exception {
        RunningMedian rm = new RunningMedian();
        assertEquals(rm.insert(12),12,0.01);
        assertEquals(rm.insert(4),8,0.01);
        assertEquals(rm.insert(5),5,0.01);
        assertEquals(rm.insert(3),4.5,0.01);
        assertEquals(rm.insert(8),5,0.01);
        assertEquals(rm.insert(7),6,0.01);

    }

    @Test
    public void getMedian() throws Exception {
        RunningMedian rm = new RunningMedian();
        rm.insert(12);

    }

}