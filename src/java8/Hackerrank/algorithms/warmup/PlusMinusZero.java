package java8.Hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by jmelon on 07/02/2017.
 */
public class PlusMinusZero {

    public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int countPositive = 0;
        int countNegative = 0;
        int countZero = 0;

        for (int i = 0 ; i < n ; i++) {
            int k = scan.nextInt();
            if (k > 0) countPositive++;
            else if (k == 0) countZero++;
            else countNegative++;
        }

        double posFraction = (double) countPositive / (double) n;
        double negFraction = (double) countNegative / (double) n;
        double zeroFraction = (double) countZero / (double) n;

        String res = String.format("%.6f %.6f %.6f",posFraction,negFraction,zeroFraction);

        System.out.println(res);
    }
}
