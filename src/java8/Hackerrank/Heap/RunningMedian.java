package java8.Hackerrank.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jmelon on 16/01/2017.
 */
public class RunningMedian {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    private int leftMax;
    private int rightMin;

    public RunningMedian() {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2) * -1;
            }
        };
        left = new PriorityQueue<>(c); // this means the least element is the biggest
        right = new PriorityQueue<>();
        leftMax = 0;
        rightMin = 100000;
    }

    double insert(int a) {
        // a, ..., b
        // c, ..., d
        // a <= b <= c <= d
        // numberOf(a...b) == numberOf(c...d) +- 1
        if (left.size() <= right.size()) {
            if (right.size() > 0 && a > right.peek()) {
                left.add(right.poll());
                right.add(a);
            } else left.add(a);
        } else if (left.size() > right.size()) {
            if (left.size() > 0 && a < left.peek()) {
                right.add(left.poll());
                left.add(a);
            } else right.add(a);
        }

        return getMedian();
    }

    double getMedian() {
        if (left.size() < right.size()) return right.peek();
        else if (left.size() > right.size()) return left.peek();
        else return (left.peek() + right.peek()) / 2.0;
    }

}
