package java8.Hackerrank.Stacks;

import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jmelon on 20/01/2017.
 */
public class MaxElement {

    public static class IntegerTuple {
        Integer a;
        Integer b;

        public Integer getA() {
            return a;
        }

        public Integer getB() {
            return b;
        }

        public IntegerTuple(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numOps = scan.nextInt();
        Stack<IntegerTuple> stack = new Stack<>();
        for (int i = 0 ; i < numOps ; i++) {
            int command = scan.nextInt();
            if (command == 1) {
                int value = scan.nextInt();
                int max = value;
                if (stack.size() > 0) {
                    max = value > stack.peek().getB() ? value : stack.peek().getB();
                }
                stack.push(new IntegerTuple(value,max));
            } else if (command == 2) {
                stack.pop();
            } else if (command == 3) {
                System.out.println(stack.peek().getB());
            }
        }
    }

}
