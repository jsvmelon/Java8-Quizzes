package java8.Hackerrank.algorithms.warmup;

/**
 * Created by jmelon on 07/02/2017.
 */
public class Staircase {

    public static void Staircase(int n) {
        StringBuilder spaces = new StringBuilder(n);
        for (int i = 0 ; i < n ; i++) spaces.append(" ");

        StringBuilder hashes = new StringBuilder(n);
        //hashes.append("#");

        for (int i = 0 ; i < n ; i++) {
            spaces.deleteCharAt(0);
            hashes.append("#");
            System.out.println(spaces.toString() + hashes.toString());
        }
    }
}
