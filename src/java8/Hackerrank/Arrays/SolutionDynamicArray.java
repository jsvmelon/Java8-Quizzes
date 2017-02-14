package java8.Hackerrank.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by jmelon on 13/12/2016.
 */
public class SolutionDynamicArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstline = br.readLine().split(" ");
        int numberOfSequences = Integer.parseInt(firstline[0]);
        int numberOfQueries = Integer.parseInt(firstline[1]);

        ArrayList<ArrayList<Integer>> seqList = new ArrayList<>(numberOfSequences);
        for (int i = 0 ; i < numberOfSequences ; i++) seqList.add(new ArrayList<>());

        int lastAns = 0;

        for (int i = 0 ; i < numberOfQueries ; i++) {
            String[] line = br.readLine().split(" ");
            int queryType = Integer.parseInt(line[0]);
            int x = Integer.parseInt(line[1]);
            int y = Integer.parseInt(line[2]);

            switch (queryType) {
                case 1:
                    seqList.get((x^lastAns)%numberOfSequences).add(y);
                    break;
                case 2:
                    ArrayList<Integer> seq = seqList.get((x^lastAns)%numberOfSequences);
                    lastAns = seq.get(y%seq.size());
                    System.out.println(lastAns);
                    break;
            }
        }
    }
}
