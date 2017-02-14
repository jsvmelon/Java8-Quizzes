package java8.Hackerrank.Stacks;

import java.util.Scanner;

/**
 * Created by jmelon on 23/01/2017.
 */
public class EqualStacksFaster {

     static int h1[];
     static int h2[];
     static int h3[];
     static int header1;
     static int header2;
     static int header3;
     static int height1;
     static int height2;
     static int height3;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        h1 = new int[n1];
        header1 = 0;
        height1 = 0;
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
            height1 += h1[h1_i];
        }
        h2 = new int[n2];
        header2 = 0;
        height2 = 0;
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
            height2 += h2[h2_i];
        }
        h3 = new int[n3];
        header3 = 0;
        height3 = 0;
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
            height3 += h3[h3_i];
        }

        System.out.println(equalise());
    }

    public static int equalise() {

        while (height1 != height2 || height2 != height3) {
            if (height1 >= height2 && height1 >= height3) {
                height1 -= h1[header1];
                header1++;
            }
            else if (height2 >= height1 && height2 >= height3) {
                height2 -= h2[header2];
                header2++;
            }
            else if (height3 >= height1 && height3 >= height2) {
                height3 -= h3[header3];
                header3++;
            }
            // otherwise they are all the same and we will pop out via the while condition
        }
        return height1; // it doesn't matter which height to return as they are all the same
    }

}
