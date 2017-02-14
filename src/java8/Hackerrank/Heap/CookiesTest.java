package java8.Hackerrank.Heap;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * Created by jmelon on 15/01/2017.
 */
public class CookiesTest {
    @Test
    public void mixit() throws Exception {
        PriorityQueue<Integer> set = new PriorityQueue<>();

        set.add(1);
        assertEquals(Cookies.mixit(1,set),0);
        assertEquals(Cookies.mixit(2,set),-1);

        set.clear();
        set.add(1);
        set.add(2);
        assertEquals(Cookies.mixit(1,set),0);
        assertEquals(Cookies.mixit(2,set),1);

        //3,4,5,5,6,7,8
        //5,5,6,7,8,11
        //6,7,8,11,15
        //8,11,15,20
        // 15,20,30
        // 30,55
        // 140

        set = setupSet();
        assertEquals(Cookies.mixit(1,set),0);
        System.out.println(set);
        set = setupSet();
        assertEquals(Cookies.mixit(2,set),1);
        System.out.println(set);
        set = setupSet();
        assertEquals(Cookies.mixit(3,set),1);
        System.out.println(set);
        set = setupSet();
        assertEquals(Cookies.mixit(5,set),2);
        System.out.println(set);
        set = setupSet();
        assertEquals(Cookies.mixit(4,set),2);
        System.out.println(set);
        set = setupSet();
        assertEquals(Cookies.mixit(6,set),3);
        System.out.println(set);
        set = setupSet();
        assertEquals(Cookies.mixit(7,set),4);
        System.out.println(set);
        set = setupSet();
        assertEquals(Cookies.mixit(8,set),4);
        System.out.println(set);
        set = setupSet();
        assertEquals(Cookies.mixit(9,set),5);
        System.out.println(set);
        set = setupSet();
        assertEquals(Cookies.mixit(15,set),5);
        System.out.println(set);
        set = setupSet();
        assertEquals(Cookies.mixit(16,set),6);
        System.out.println(set);
        set = setupSet();
        assertEquals(Cookies.mixit(30,set),6);
        System.out.println(set);
        set = setupSet();
        assertEquals(Cookies.mixit(31,set),7);
        System.out.println(set);
        set = setupSet();
        assertEquals(Cookies.mixit(140,set),7);
        System.out.println(set);
        set = setupSet();
        assertEquals(Cookies.mixit(141,set),-1);
        System.out.println(set);
    }

    private PriorityQueue<Integer> setupSet() {
        PriorityQueue<Integer> set = new PriorityQueue<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        return set;
    }

}