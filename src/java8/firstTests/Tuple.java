package java8.firstTests;

/**
 * Created by jmelon on 24/11/2016.
 */
public class Tuple {
    private long a;
    private long b;

    public Tuple(long first, long second) {
        a = first;
        b = second;
    }

    public long getA() {
        return a;
    }

    public void setA(long a) {
        this.a = a;
    }

    public long getB() {
        return b;
    }

    public void setB(long b) {
        this.b = b;
    }

    public String toString() {
        return "(" + a + "," + b + ")";
    }
}
