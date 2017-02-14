package java8.firstTests;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jmelon on 25/11/2016.
 */
public class MathGeneratorTest {
    @Test
    public void generatePrimes() throws Exception {
        int runs = 50;
        long start, finish, avg = 0, fastest = Long.MAX_VALUE;
        for (int i = 1; i <= runs; i++) {
            start = System.nanoTime();
            MathGenerator.generatePrimes(10000);
            finish = System.nanoTime();
            fastest = (finish - start) < fastest ? finish - start : fastest;
            avg = avg + fastest / runs;
        }
        System.out.println("Average: " + avg / 1_000_000);
        System.out.println("Fastest: " + fastest / 1_000_000);
    }

    @Test
    public void generateFibonacciTuples() throws Exception {
        List<Tuple> l = MathGenerator.generateFibonacciTuples(100);
        assertTrue(l.get(0).getA()==0 && l.get(0).getB()==1);
        if (l.size() == 1) return;

        for (int i = 1 ; i < l.size() ; i++) {
            assertTrue(l.get(i).getA() == l.get(i-1).getB());
            assertTrue(l.get(i).getB() == l.get(i-1).getA() + l.get(i-1).getB());
        }
    }

    @Test
    public void generatePythTriples() throws Exception {
        int number = 500;
        List<Triple> l = MathGenerator.generatePythTriples(number);
        assertTrue(l.size() == number);
        for (Triple t:l) assertTrue(t.getA() * t.getA() + t.getB() * t.getB() == t.getC() * t.getC());
        System.out.println(l);
    }

}