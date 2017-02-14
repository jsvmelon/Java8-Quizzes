package java8.Hackerrank.Stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jmelon on 20/01/2017.
 */
public class EqualStacks {
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

    Stack<IntegerTuple> stack1 = new Stack();
    Stack<IntegerTuple> stack2 = new Stack();
    Stack<IntegerTuple> stack3 = new Stack();

    public static void main(String[] args) {
        EqualStacks es = new EqualStacks();

        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();

        String line1 = in.nextLine();
        es.fillStack1(line1);
        String line2 = in.nextLine();
        es.fillStack2(line2);
        String line3 = in.nextLine();
        es.fillStack3(line3);

        System.out.println(es.equalise());
    }

    public void fillStack1(String s) {fillStack(s, stack1);}
    public void fillStack2(String s) {fillStack(s, stack2);}
    public void fillStack3(String s) {fillStack(s, stack3);}
    public void fillStack(String s, Stack<IntegerTuple> stack) {
        String[] sa = s.split(" ");
        for (int i = sa.length-1 ; i >=0 ; i--) {
            int value = Integer.parseInt(sa[i]);
            if (stack.size() > 0) stack.push(new IntegerTuple(value, stack.peek().b + value));
            else stack.push(new IntegerTuple(value, value));
        }
    }

    public void push1(int value) { push(value, stack1); }
    public void push2(int value) { push(value, stack2); }
    public void push3(int value) { push(value, stack3); }

    private void push(int value, Stack<IntegerTuple> s) {
        if (s.size() == 0) s.push(new IntegerTuple(value , value));
        else s.push(new IntegerTuple(value , s.peek().b + value));
    }

    public int equalise() {
        int h1 = stack1.peek().b;
        int h2 = stack2.peek().b;
        int h3 = stack3.peek().b;

        while (h1 != h2 || h2 != h3) {
            if (h1 > h2 && h1 > h3) {
                stack1.pop();
                h1 = stack1.size() > 0 ? stack1.peek().b : 0;
            }
            else if (h2 > h1 && h2 > h3) {
                stack2.pop();
                h2 = stack2.size() > 0 ? stack2.peek().b : 0;
            }
            else if (h3 > h1 && h3 > h2) {
                stack3.pop();
                h3 = stack3.size() > 0 ? stack3.peek().b : 0;
            }
            // otherwise they are all the same
        }
        return h1;
    }

}
