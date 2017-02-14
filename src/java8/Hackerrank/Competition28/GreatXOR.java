package java8.Hackerrank.Competition28;

import java.util.Scanner;

/**
 * Created by jmelon on 10/01/2017.
 */
public class GreatXOR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            System.out.println(combinations(x));
            // your code goes here
        }
    }

    public static long combinations(long x) {
        if (x <= 1) return 0;

        long res = 0;
        long power;
        for (int bit = 0 ; Math.pow(2,bit) < x ; bit++) {  // bit == 0 is the first bit
            power = (long) Math.pow(2,bit);
            if ((x & power) != power) { // means that bit is not set in x
                res += power;
            }
        }
        return res;
    }

    /*
     * Returns the possible number of combinations of positions to the right of the given bit.
     */
    public static int combByBit(int bit) {

        int result = 0;
        if (bit == 0) return 1;

        // add up all possible m-set iterations
        // n! / 1! * (n-1)! ; n! / 2! * (n-2)! ; ... ; n! / n-1! * 1!
        for (int i = 0 ; i <= bit ; i++) {
            result += fac(bit) / (fac(i) * fac(bit - i));
        }

        // TODO this might just be 2^bit ...

        return result;
    }

    public static int fac(int n) {
        int result = 1;
        if (n == 0 || n == 1) return 1;
        for (int i = 1 ; i <= n ; i++) result = result * i;
        return result;
    }
}
