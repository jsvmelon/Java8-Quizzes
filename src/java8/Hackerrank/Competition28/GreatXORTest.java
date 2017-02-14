package java8.Hackerrank.Competition28;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jmelon on 10/01/2017.
 */
public class GreatXORTest {
    @Test
    public void combinations() throws Exception {
        assertEquals(GreatXOR.combinations(2),1);
        assertEquals(GreatXOR.combinations(10),5);

        // use the naive algorithm to test the better performing one
        int max = (int) Math.pow(10,10);
        for (int i = (int) Math.pow(10,8) ; i < max ; i++) {
            long start = System.currentTimeMillis();
            long a = GreatXOR.combinations(i);
            long middle = System.currentTimeMillis();
            long b = naive(i);
            long end = System.currentTimeMillis();
            if (i % 10 == 0) {
                System.out.println("run " + i);
                System.out.println((middle-start) + " vs. " + (end-middle));
            }
            assertEquals(a,b);
        }
    }

    @Test
    public void speedTest() {
        long max = (long) Math.pow(10,10);
        long maxQ = (long) Math.pow(10,5);
        long iterations = 100;
        long start = System.currentTimeMillis();
        for (int k = 0 ; k < iterations ; k++) {
            for (long i = 0; i < maxQ; i++) {
                GreatXOR.combinations(max - 1);
            }
        }
        System.out.println((System.currentTimeMillis() - start) / iterations);
    }

    private long naive(int x) {
        long res = 0;
        for (int i = 0 ; i < x ; i++) {
            if ((i^x) > x) res++;
        }
        return res;
    }

    @Test
    public void combByBit() throws Exception {
        assertEquals(GreatXOR.combByBit(0),1);
        assertEquals(GreatXOR.combByBit(1),2);
        assertEquals(GreatXOR.combByBit(2),4);
        assertEquals(GreatXOR.combByBit(3),8);
    }

    @Test
    public void fac() throws Exception {
        assertEquals(GreatXOR.fac(0),1);
        assertEquals(GreatXOR.fac(1),1);
        assertEquals(GreatXOR.fac(2),2);
        assertEquals(GreatXOR.fac(3),6);
        assertEquals(GreatXOR.fac(4),24);

        for (int i = 5 ; i < 100 ; i++) assertEquals(GreatXOR.fac(i),GreatXOR.fac(i-1) * i);

    }

}