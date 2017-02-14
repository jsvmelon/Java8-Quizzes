package java8.Hackerrank.algorithms.warmup;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by jmelon on 07/02/2017.
 */
public class TimeConversionTest {
    @Test
    public void convertDate() throws Exception {
        System.out.println(TimeConversion.convertDate(new Scanner("08:11:25AM")));
    }

}