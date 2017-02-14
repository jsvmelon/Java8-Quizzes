package java8.Hackerrank.Stacks;

import java.util.Stack;

/**
 * Created by jmelon on 20/01/2017.
 */
public class Brackets {

    public static boolean checkSequence(String sequence) {
        Stack<Character> stack = new Stack();
        for (int i = 0 ; i < sequence.length() ; i++) {
            char c = sequence.charAt(i);
            if ((c == ')' || c == ']' || c == '}') && stack.size() == 0) return false;
            switch (c) {
                case ')' :
                    if (stack.peek() == '(') stack.pop();
                    else return false;
                    break;
                case ']' :
                    if (stack.peek() == '[') stack.pop();
                    else return false;
                    break;
                case '}' :
                    if (stack.peek() == '{') stack.pop();
                    else return false;
                    break;
                default:
                    stack.push(c);
            }

        }
        if (stack.size() > 0) return false;
        else return true;
    }
}
