package java8.Hackerrank.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by jmelon on 13/12/2016.
 */
public class SolutionSparseArrays {

    public static void main(String[] args) throws IOException {
        //directSolution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfStrings = Integer.parseInt(br.readLine());
        String[] strings = new String[numberOfStrings];
        br.lines().limit(numberOfStrings).collect(Collectors.toList()).toArray(strings);
        int numberOfQueries = Integer.parseInt(br.readLine());

        br.lines().limit(numberOfQueries).forEach((String s) -> {
            long count = Arrays.stream(strings).filter((String source) -> source.compareTo(s) == 0).count();
            System.out.println(count);
        });
    }

    private static void directSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> strings = new ArrayList<>();

        int numberOfStrings = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < numberOfStrings ; i++) {
            strings.add(br.readLine());
        }

        int numberOfQueries = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < numberOfQueries ; i++) {
            String query = br.readLine();
            int counter = 0;
            for (int k = 0 ; k < numberOfStrings ; k++) {
                if (strings.get(k).compareTo(query) == 0) counter++;
            }
            System.out.println(String.valueOf(counter));
        }
    }
}
