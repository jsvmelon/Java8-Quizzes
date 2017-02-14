package java8.Hackerrank.Stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jmelon on 25/01/2017.
 */
public class SimpleTextEditor {

    private class Operation {}

    private class Append extends Operation {
        String text;

        public Append(String t) {
            text = t;
        }
    }

    private class Delete extends Operation {
        int number;
        String text; // the string that was deleted by this operation
        Delete(int n, String text) {
            number = n;
            this.text = text;
        }
    }

    StringBuilder sb = new StringBuilder();
    Stack<Operation> operations = new Stack<>();

    public void append(String text) {
        operations.push(new Append(text));
        sb.append(text);
    }

    public void delete(int k) {
        String s = sb.substring(sb.length()-k,sb.length());
        operations.push(new Delete(k,s));
        sb.delete(sb.length()-k,sb.length());
    }

    public char print(int index) {
        return sb.charAt(index-1);
    }

    public void undo() {
        Operation o = operations.pop();
        if (o instanceof Append) {
            int l = ((Append) o).text.length();
            sb.delete(sb.length()-l,sb.length());
        } else if (o instanceof Delete) {
            int n = ((Delete) o).number;
            sb.append(((Delete) o).text);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opsnum = scan.nextInt();
        SimpleTextEditor s = new SimpleTextEditor();
        for (int i = 0 ; i < opsnum ; i++) {
            int type = scan.nextInt();
            int n;
            switch (type) {
                case 1 :
                    String t = scan.next();
                    s.append(t);
                    break;
                case 2 :
                    n = scan.nextInt();
                    s.delete(n);
                    break;
                case 3 :
                    n = scan.nextInt();
                    System.out.println(s.print(n));
                    break;
                case 4 :
                    s.undo();
                    break;
            }
        }
    }


}