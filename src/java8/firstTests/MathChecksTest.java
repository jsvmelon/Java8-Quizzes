package java8.firstTests;

import java8.firstTests.MathChecks;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.LongPredicate;

import static java.lang.Math.toIntExact;
import static org.junit.Assert.*;

/**
 * Created by jmelon on 15/11/2016.
 */
public class MathChecksTest {
    @Test
    public void isPrimeEff() throws Exception {
        long[] primesA = {1,2,3,5,7,11,17};
        long[] nonPrimesA = {4,6,9,21};

        ArrayList<Long> primes = new ArrayList<>();
        ArrayList<Long> nonPrimes = new ArrayList<>();

        Arrays.stream(primesA).forEach(k -> primes.add(k));
        Arrays.stream(nonPrimesA).forEach(k -> nonPrimes.add(k));

        assertTrue(primes.stream().allMatch(k -> MathChecks.isPrimeEff(primes,k)));
        assertTrue(nonPrimes.stream().noneMatch(k -> MathChecks.isPrimeEff(primes,k)));
    }

    @Test
    public void isPowerOfTwoStreams() throws Exception {

    }

    @Test
    public void isPrimeUsingSream() throws Exception {
        isPrime(MathChecks::isPrimeUsingSream);
    }

    @Test
    public void isPrimeEratosthenes() {
        isPrime((long l) -> MathChecks.isPrimeEratosthenes(toIntExact(l)));
    }

    @Test
    public void isPrimeBruteForceTest() {
        isPrime(MathChecks::isPrimeBruteForceTest);
    }

    /*
     * This method applies the test given in the argument to a number of primes and non-primes.
     */
    private void isPrime(LongPredicate p) {
        long[] primes = {1,2,3,5,7,11,17};
        long[] nonPrimes = {4,6,9,21};

        Arrays.stream(primes).forEach(n -> System.out.println(n + " -> " + p.test(n)));
        Arrays.stream(nonPrimes).forEach(n -> System.out.println(n + " -> " + p.test(n)));

        assertTrue(Arrays.stream(primes).allMatch(p));
        assertTrue(Arrays.stream(nonPrimes).noneMatch(p));
    }

    @Test
    public void isPowerOfTwo() {
        double[] powersOfTwo = {1,2,4,16};
        assertTrue(Arrays.stream(powersOfTwo).allMatch(MathChecks::isPowerOfTwo));

        double[] nonPowers = {1.2,0,0.5,6,7,20,-4};
        assertTrue(Arrays.stream(nonPowers).noneMatch(MathChecks::isPowerOfTwo));
    }

}