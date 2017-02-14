package java8.Hackerrank.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by jmelon on 13/12/2016.
 */
public class Solution2DArrays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] matrix;

        matrix = br.lines().
                map((String s) -> s.split(" ")).
                flatMap(Arrays::stream).
                mapToInt(Integer::parseInt).toArray();

        int max = Integer.MIN_VALUE;
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 4; i++) {
                int sum = matrix[k * 6 + i] + matrix[k * 6 + i + 1] + matrix[k * 6 + i + 2] +
                        matrix[k * 6 + i + 7] +
                        matrix[k * 6 + i + 12] + matrix[k * 6 + i + 13] + matrix[k * 6 + i + 14];
                if (sum > max) max = sum;
            }
        }

        System.out.println(max);
    }
}
