package java8.Hackerrank.Trees.ArraySimpleQuries;

import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * Created by jmelon on 01/01/2017.
 */
public class ArraySimpleQueries {
    int[] a;
    int[] b;

    private ArraySimpleQueries() {
    }

    public ArraySimpleQueries(int capacity) {
        a = new int[capacity+1];
        b = new int[capacity+1];
    }

    public void moveToBeginning(int left, int right) {
        // save the existing beginning numbers:
        for (int i = 1; i < left ; i++) b[i] = a[i];

        // now move the interval to the front:
        for (int i = left ; i <= right ; i++) a[i-left+1] = a[i];

        // and put the stored values afterwards
        for (int i = 1 ; i < left ; i++) {
            a[right - left + 1 + i] = b[i];
        }
    }

    public void moveToEnd(int left, int right) {
        // save the existing ending numbers:
        for (int i = right + 1 ; i < a.length ; i++) b[i] = a[i];

        // now move the interval to the end
        for (int i = right ; i >= left ; i--) a[a.length - (right - i + 1)] = a[i];

        // and put the stored values afterwards
        for (int i = right + 1 ; i < a.length ; i++) {
            a[left + i - right -1] = b[i];
        }

    }

    public void printResult() {
        System.out.println(abs(a[1]-a[a.length-1]));
        for (int i = 1 ; i < a.length ; i++) System.out.print(a[i] + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arraySize = scan.nextInt();
        ArraySimpleQueries asq = new ArraySimpleQueries(arraySize);
        int operations = scan.nextInt();
        for (int i = 0 ; i < arraySize ; i++) {
            int content = scan.nextInt();
            asq.a[i+1] = content;
        }
        for (int i = 0 ; i < operations ; i++) {
            int type = scan.nextInt();
            int left = scan.nextInt();
            int right = scan.nextInt();
            if (type == 1) {
                asq.moveToBeginning(left,right);
            } else if (type == 2) {
                asq.moveToEnd(left,right);
            }
        }
        asq.printResult();
    }


}
