package java8.Hackerrank.Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by jmelon on 15/01/2017.
 */
public class Cookies {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numQueries = scan.nextInt();
        int minSweetness = scan.nextInt();
        PriorityQueue<Integer> set = new PriorityQueue<>();
        for (int i = 0 ; i < numQueries ; i++) {
            set.add(scan.nextInt());
        }

        System.out.println(mixit(minSweetness, set));
    }

    static int mixit(int minSweetness, PriorityQueue<Integer> set) {
        int ops = 0;
        while (set.peek() < minSweetness && set.size() >= 2) {
            ops++;
            int a = set.poll();
            int b = set.poll();
            set.add(a+2*b);
        }

        if (set.peek() < minSweetness) return -1;
        else return ops;
    }

}
