package java8.firstTests;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by jmelon on 25/11/2016.
 */
public class MathGenerator {
    public static List<Tuple> generateFibonacciTuples(int n) {
        return Stream.iterate(new Tuple(0,1), t -> new Tuple(t.getB(),t.getA()+t.getB())).
                limit(n).
                collect(toList());
    }

    public static List<Triple> generatePythTriples(int n) {
        return Stream.iterate(new Triple(1,1,1),t -> {
            if (t.getA2() + t.getB2() < t.getC2()) return new Triple(t.getA(),t.getB()+1,t.getC());
            if (t.getA2() + t.getB2() == t.getC2()) return new Triple(1,1,t.getC()+1);
            if (t.getA2() + t.getB2() > t.getC2() && t.getA() == t.getB()) return new Triple(1,1,t.getC()+1);
            return new Triple(t.getA()+1,t.getA()+1,t.getC());
        }).parallel().filter(t -> t.getA2() + t.getB2() == t.getC2()).limit(n).collect(toList());
    }

    public static ArrayList<Long> generatePrimes(long n) {
        ArrayList<Long> primes = new ArrayList<>();
        LongStream.rangeClosed(1,n).filter(k -> MathChecks.isPrimeEff(primes,k)).forEach(k -> primes.add(k));
        return primes;
    }
}
