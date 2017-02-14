package java8.Hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by jmelon on 07/02/2017.
 */
public class TimeConversion {

    public static String convertDate(Scanner scan) {
        int hours = scan.nextInt();
        scan.skip(":");
        int minutes = scan.nextInt();
        scan.skip(":");
        int seconds = scan.nextInt();
        String s = scan.nextLine();



        if (s.equals("PM")) hours+=12;
        return hours + ":" + minutes + ":" + seconds + ":";
    }
}
