package java8.Hackerrank.Heap;

import java.util.*;

/**
 * Created by jmelon on 15/01/2017.
 */
public class QHeap1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numQueries = scan.nextInt();
        SortedSet<Integer> set = new TreeSet();
        for (int i = 0 ; i < numQueries ; i++) {
            int command = scan.nextInt();
            int value = scan.nextInt();
            switch  (command) {
            case 1 :  set.add(value);
                break ;
            case 2 :  set.remove(value);
                break;
            case 3 : System.out.println(set.first());
                break;
            }
        }
    }


}
