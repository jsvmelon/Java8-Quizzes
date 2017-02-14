package java8.Hackerrank.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jmelon on 13/12/2016.
 */
public class SolutionLeftRotation {

    private static int arraySize = 0;
    private static int leftShifts = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        getArraySize(br.readLine());
        leftShift(br.readLine());
    }

    private static void leftShift(String input) {
        String[] numberLine = input.split(" ");
        for (int i = 0 ; i < arraySize ; i++) System.out.print(numberLine[((i+leftShifts) % arraySize)] + " ");
        System.out.println("");
    }

    private static void getArraySize(String input) {
        String[] firstline = input.split(" ");
        arraySize = Integer.parseInt(firstline[0]);
        leftShifts = Integer.parseInt(firstline[1]);
    }

}
