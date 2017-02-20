package java8.Hackerrank.algorithms.implementation;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by jmelon on 19/02/2017.
 */
class BetweenTest {
    @org.junit.jupiter.api.Test
    void count() {
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{6};
        assertEquals(1, Between.count(a,b));

        a = new int[]{2,4};
        b = new int[]{16,32,96};
        assertEquals(3, Between.count(a,b));

        a = new int[]{2,3,6};
        b = new int[]{42,84};
        assertEquals(2, Between.count(a,b));
    }

}