package java8.firstTests;

/**
 * Created by jmelon on 24/11/2016.
 */
public class Triple {
    private long a, b, c;

    public Triple(long first, long second, long third) {
        a = first;
        b = second;
        c = third;
    }

    public String toString() { return a + "," + b + "," + c; }

    public long getA2() { return a*a ;}
    public long getB2() { return b*b ;}
    public long getC2() { return c*c ;}

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

    public long getC() {
        return c;
    }

    public void setC(long c) {
        this.c = c;
    }
}
