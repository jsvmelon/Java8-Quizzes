package java8.firstTests;

/**
 * Created by jmelon on 15/11/2016.
 */
public class LambdaTests {
    public void PrintDecisionOn2(MyPredicate<Integer> p) {
        if (p.test(2)) System.out.println("Yes");
        else System.out.println("No");
    }
}
