package java8.Hackerrank.Trees.ArraySimpleQuries;

import org.junit.Test;

/**
 * Created by jmelon on 01/01/2017.
 */
public class ArraySimpleQueriesTest {

    @Test
    public void moveToBeginning() throws Exception {
        ArraySimpleQueries a;
        a = new ArraySimpleQueries(10);
        for (int i = 1 ; i <= 10 ; i++) a.a[i] = i;

        System.out.println("5,10:");
        a.printResult();
        a.moveToBeginning(5,10);
        a.printResult();

        System.out.println("1,10:");
        a.moveToBeginning(1,10);
        a.printResult();

        System.out.println("2,3:");
        a.moveToBeginning(2,3);
        a.printResult();
    }

    @Test
    public void moveToEnd() throws Exception {
        ArraySimpleQueries a;

        a = new ArraySimpleQueries(100);
        for (int i = 1 ; i <= 100 ; i++) a.a[i] = i;
        System.out.println("Test 1 (5,7)");
        a.moveToEnd(5,7);
        a.printResult();

        a = new ArraySimpleQueries(100);
        for (int i = 1 ; i <= 100 ; i++) a.a[i] = i;
        System.out.println("Test 2 (1,50)");
        a.moveToEnd(1,50);
        a.printResult();

        a = new ArraySimpleQueries(100);
        for (int i = 1 ; i <= 100 ; i++) a.a[i] = i;
        System.out.println("Test 3 (1,100)");
        a.moveToEnd(1,100);
        a.printResult();

        a = new ArraySimpleQueries(100);
        for (int i = 1 ; i <= 100 ; i++) a.a[i] = i;
        System.out.println("Test 4 (1,1)");
        a.moveToEnd(1,1);
        a.printResult();
    }

}