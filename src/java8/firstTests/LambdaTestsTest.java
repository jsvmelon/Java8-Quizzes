package java8.firstTests;

/**
 * Created by jmelon on 15/11/2016.
 */
public class LambdaTestsTest {
    @org.junit.Test
    public void printDecisionOn2() throws Exception {
        LambdaTests lt = new LambdaTests();
        lt.PrintDecisionOn2((Integer i) -> i%2 == 0);
        lt.PrintDecisionOn2((Integer i) -> i%3 == 0);
        lt.PrintDecisionOn2((Integer i) -> i%4 == 0);
    }

}