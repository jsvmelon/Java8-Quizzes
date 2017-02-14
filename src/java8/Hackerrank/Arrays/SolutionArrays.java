package java8.Hackerrank.Arrays;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by jmelon on 12/12/2016.
 */
public class SolutionArrays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        String secondLine = br.readLine();

        Stream<String> stream = Arrays.stream(secondLine.split(" "));
        String res = stream.reduce("",(a,b) -> b + " " + a);
        System.out.println(res);
    }

}
