package java8.firstTests;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by jmelon on 15/11/2016.
 */
public class MathChecks {
    public static boolean isPowerOfTwo(double n) {
        while (n >= 1 && n % 2 == 0) {
            n = n / 2;
        }
        if (n == 1) return true;
        else return false;
    }

    public static boolean isPrimeBruteForceTest(long n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrimeEratosthenes(int n) {
        if (n == 1) return true;

        // default boolean is 'false' which makes the code a bit unreadable due to negations
        boolean[] isPrime = new boolean[n+1];
        for (int p = 1; p <= n ; p++) isPrime[p] = true;

        for (int k = 2 ; k <= n/2 ; k++) {
            if (isPrime[k]) { // we go through the multiplication only if the number is found to be a prime
                for (int f = 2; f * k <= n; f++) isPrime[f*k] = false;
            }
        }

        return isPrime[n];
    }

    public static boolean isPrimeUsingSream(long n) {
        if (n == 2) return true;
        return Stream.iterate(2,k -> k + 1).limit(n/2).anyMatch(x -> n%x == 0) == false;
    }

    public static boolean isPrimeEff(ArrayList<Long> primes, long n) {
        return primes.stream().filter(k -> k*k <= n).filter(k -> k > 1).noneMatch(k -> n%k == 0);
    }

    /**
     * This function is O(n) instead of O(log n)
     * @param n
     * @return true if n is a power of two
     */
    public static boolean isPowerOfTwoStreams(double n) {
        return Stream.iterate(2,k -> k * 2).limit((long) n).anyMatch(x -> x == n);
    }

}