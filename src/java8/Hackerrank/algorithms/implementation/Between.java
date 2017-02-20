package java8.Hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by jmelon on 19/02/2017.
 **/
public class Between {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int maxA = 0;
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            if (a[a_i] > maxA) maxA = a[a_i];
        }
        int[] b = new int[m];
        int minB = Integer.MAX_VALUE;
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
            if (b[b_i] < minB) minB = b[b_i];
        }

        System.out.println(count(a,b));
    }

    static int count(int[] a, int[] b) {
        int num = 0;
        for (int k = 1; k <= 100; k++) {
            // check that all elements in A are factors of k
            boolean afactors = true;
            for (int anA : a) {
                if (k % anA != 0) {
                    afactors = false;
                    break;
                }
            }

            if (!afactors) {
                //System.out.println("continue");
                continue;
            }

            // check that k is a factor of all elements in b
            boolean bfactors = true;
            for (int aB : b) {
                if (aB % k != 0) {
                    bfactors = false;
                    break;
                }
            }
            if (bfactors) {
                System.out.print(k + " ");
                num++;
            }
        }
        return num;
    }


}
