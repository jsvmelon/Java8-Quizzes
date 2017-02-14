package java8.Hackerrank.Trees;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jmelon on 20/12/2016.
 */
public class TenSquareTreeTest {
    @Test
    public void nextIntervalEnd() throws Exception {
        TenSquareTree t = new TenSquareTree();

        assertTrue(t.nextIntervalEnd(BigInteger.valueOf(9),1).compareTo(BigInteger.valueOf(20)) == 0);
        assertTrue(t.nextIntervalEnd(BigInteger.valueOf(9),0).compareTo(BigInteger.valueOf(10)) == 0);
        assertTrue(t.nextIntervalEnd(BigInteger.valueOf(10),1).compareTo(BigInteger.valueOf(20)) == 0);
        assertTrue(t.nextIntervalEnd(new BigInteger("362625152730"),1).compareTo(new BigInteger("362625152740")) == 0);
        assertTrue(t.nextIntervalEnd(BigInteger.valueOf(230),2).compareTo(BigInteger.valueOf(400)) == 0);
    }

    @Test
    public void nextIntervalBeginning() throws Exception {
        TenSquareTree t = new TenSquareTree();

        assertTrue(t.nextIntervalBeginning(BigInteger.valueOf(1),0).compareTo(BigInteger.valueOf(1)) == 0);
        assertTrue(t.nextIntervalBeginning(BigInteger.valueOf(1),1).compareTo(BigInteger.valueOf(1)) == 0);
        assertTrue(t.nextIntervalBeginning(BigInteger.valueOf(1),2).compareTo(BigInteger.valueOf(1)) == 0);
        assertTrue(t.nextIntervalBeginning(BigInteger.valueOf(1),3).compareTo(BigInteger.valueOf(1)) == 0);
        assertTrue(t.nextIntervalBeginning(BigInteger.valueOf(3630),1).compareTo(BigInteger.valueOf(3631)) == 0);
        assertTrue(t.nextIntervalBeginning(BigInteger.valueOf(5),1).compareTo(BigInteger.valueOf(11)) == 0);
        assertTrue(t.nextIntervalBeginning(BigInteger.valueOf(5),3).compareTo(BigInteger.valueOf(10001)) == 0);

    }

    @Test
    public void numberOfKIntervalsToRight() throws Exception {
        TenSquareTree t = new TenSquareTree();

        assertTrue(t.numberOfKIntervalsToRight(BigInteger.ONE,BigInteger.TEN,1).compareTo(BigInteger.ONE) == 0);
        assertEquals(t.numberOfKIntervalsToRight(BigInteger.ONE,BigInteger.valueOf(100),1).longValue(),10);
        assertEquals(t.numberOfKIntervalsToRight(BigInteger.valueOf(5),BigInteger.TEN,1).longValue(),0);
        assertEquals(t.numberOfKIntervalsToRight(BigInteger.valueOf(9),BigInteger.valueOf(18),1).longValue(),0);
        assertEquals(t.numberOfKIntervalsToRight(BigInteger.valueOf(12),BigInteger.valueOf(88),1).longValue(),6);
        assertEquals(t.numberOfKIntervalsToRight(BigInteger.ONE,BigInteger.valueOf(3),0).longValue(),3);
        assertEquals(t.numberOfKIntervalsToRight(BigInteger.valueOf(1089),BigInteger.valueOf(17835),3).longValue(),0);
        assertEquals(t.numberOfKIntervalsToRight(BigInteger.valueOf(1089),BigInteger.valueOf(2530),2).longValue(),14);
    }

    @Test
    public void intervalSize() throws Exception {
        TenSquareTree t = new TenSquareTree();
        assertEquals(t.intervalSize(0).longValue(),1);
        assertEquals(t.intervalSize(1).longValue(),10);
        assertEquals(t.intervalSize(2).longValue(),100);
        assertEquals(t.intervalSize(3).longValue(),10000);
        assertEquals(t.intervalSize(4).longValue(),100000000);
    }

    @Test
    public void areInSameInterval() throws Exception {
        TenSquareTree t = new TenSquareTree();
        assertTrue(t.areInSameInterval(BigInteger.ONE,BigInteger.valueOf(9),1));
        assertTrue(t.areInSameInterval(BigInteger.ONE,BigInteger.valueOf(55),2));
        assertTrue(t.areInSameInterval(BigInteger.ONE,BigInteger.ONE,1));
        assertTrue(t.areInSameInterval(BigInteger.ONE,BigInteger.ONE,2));
        assertTrue(t.areInSameInterval(BigInteger.valueOf(25),BigInteger.valueOf(25),2));
        assertTrue(t.areInSameInterval(BigInteger.valueOf(109),BigInteger.valueOf(809),3));
        assertTrue(t.areInSameInterval(BigInteger.valueOf(1605),BigInteger.valueOf(8732),3));

        assertFalse(t.areInSameInterval(BigInteger.ONE,BigInteger.valueOf(2),0));
        assertFalse(t.areInSameInterval(BigInteger.valueOf(99),BigInteger.valueOf(101),2));
        assertFalse(t.areInSameInterval(BigInteger.valueOf(5),BigInteger.valueOf(12),1));
        assertFalse(t.areInSameInterval(BigInteger.valueOf(10),BigInteger.valueOf(11),1));
        assertFalse(t.areInSameInterval(BigInteger.valueOf(10000),BigInteger.valueOf(10001),3));
    }

    @Test
    public void isAtBeginning() throws Exception {
        TenSquareTree t = new TenSquareTree();
        assertTrue(t.isAtBeginning(BigInteger.valueOf(11),1));
        assertTrue(t.isAtBeginning(BigInteger.valueOf(101),2));
        assertTrue(t.isAtBeginning(BigInteger.valueOf(1),0));
        assertTrue(t.isAtBeginning(BigInteger.valueOf(5),0));

        assertFalse(t.isAtBeginning(BigInteger.valueOf(5),1));
        assertFalse(t.isAtBeginning(BigInteger.valueOf(15),1));
        assertFalse(t.isAtBeginning(BigInteger.valueOf(100),2));
    }

    @Test
    public void isAtEnd() throws Exception {
        TenSquareTree t = new TenSquareTree();
        assertTrue(t.isAtEnd(BigInteger.valueOf(100), 2));
        assertTrue(t.isAtEnd(BigInteger.valueOf(10), 1));
        assertTrue(t.isAtEnd(BigInteger.valueOf(60), 1));
        assertTrue(t.isAtEnd(BigInteger.valueOf(130), 1));
        assertTrue(t.isAtEnd(BigInteger.valueOf(100), 1));
        assertTrue(t.isAtEnd(BigInteger.valueOf(10000), 3));
        assertTrue(t.isAtEnd(BigInteger.valueOf(150000), 3));
        assertTrue(t.isAtEnd(BigInteger.valueOf(7),0));

        assertFalse(t.isAtEnd(BigInteger.valueOf(99),2));
        assertFalse(t.isAtEnd(BigInteger.valueOf(99),6));
        assertFalse(t.isAtEnd(BigInteger.valueOf(2),2));
        assertFalse(t.isAtEnd(BigInteger.valueOf(9),1));
    }

    @Test
    public void performance() {
        TenSquareTree.Info info;
        BigInteger left;
        BigInteger right;

        long start = System.currentTimeMillis();
        TenSquareTree t = new TenSquareTree();
        File f = new File("C:\\Users\\jmelon.SCOTT\\IdeaProjects\\Java 8 Quizzes\\src\\java8\\Hackerrank\\Trees\\TenSquareTreeCase41.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            left = new BigInteger(br.readLine());
            System.out.println("Reading first number:" + (System.currentTimeMillis() - start));
            right = new BigInteger(br.readLine());
            System.out.println("Reading second number:" + (System.currentTimeMillis() - start));
            info = t.createSequence(left,right);
            System.out.println("Calculation: " + (System.currentTimeMillis() - start));
            info.printSequence();
            System.out.println("Output: " + (System.currentTimeMillis() - start));
        } catch (Exception e) {
            System.out.println(e.toString());
            Assert.fail();
        }

    }

    @Test
    public void findLowerRight() {
        TenSquareTree t = new TenSquareTree();
        TenSquareTree.Info info = t.createSequence(BigInteger.valueOf(1),BigInteger.valueOf(10));
        System.out.println("Test 0: " + Arrays.toString(info.levels));
        assertEquals(info.levels[0],BigInteger.ZERO);
        assertEquals(info.levels[1],BigInteger.ONE);
        info.printSequence();

        info = t.createSequence(BigInteger.valueOf(3),BigInteger.valueOf(6));
        System.out.println("Test 1: " + Arrays.toString(info.levels));
        info.printSequence();
        assertEquals(info.levels[0],BigInteger.valueOf(4));
        assertEquals(info.levels[1],BigInteger.ZERO);

        info = t.createSequence(BigInteger.valueOf(62),BigInteger.valueOf(105));
        System.out.println("Test 2: " + Arrays.toString(info.levels));
        info.printSequence();
        assertEquals(info.levels[0],BigInteger.valueOf(14));
        assertEquals(info.levels[1],BigInteger.valueOf(3));

        info = t.createSequence(BigInteger.valueOf(88),BigInteger.valueOf(117));
        System.out.println("Test 3: " + Arrays.toString(info.levels));
        info.printSequence();
        assertEquals(info.levels[0],BigInteger.valueOf(10));
        assertEquals(info.levels[1],BigInteger.valueOf(2));

        info = t.createSequence(BigInteger.valueOf(55),BigInteger.valueOf(1003));
        System.out.println("Test 4: " + Arrays.toString(info.levels));
        info.printSequence();
        assertEquals(info.levels[0],BigInteger.valueOf(9));
        assertEquals(info.levels[1],BigInteger.valueOf(4));
        assertEquals(info.levels[2],BigInteger.valueOf(9));

        info = t.createSequence(BigInteger.valueOf(1),BigInteger.valueOf(1));
        System.out.println("Test 5: " + Arrays.toString(info.levels));
        info.printSequence();
        assertEquals(info.levels[0],BigInteger.valueOf(1));
        assertEquals(info.levels[1],BigInteger.valueOf(0));
        assertEquals(info.levels[2],BigInteger.valueOf(0));

        info = t.createSequence(BigInteger.valueOf(101),BigInteger.valueOf(300));
        System.out.println("Test 6: " + Arrays.toString(info.levels));
        info.printSequence();
        assertEquals(info.levels[0],BigInteger.valueOf(0));
        assertEquals(info.levels[1],BigInteger.valueOf(0));
        assertEquals(info.levels[2],BigInteger.valueOf(2));

        info = t.createSequence(BigInteger.valueOf(42),BigInteger.valueOf(1024));
        System.out.println("Test 7: ");
        info.printSequence();
        assertEquals(info.levels[0],BigInteger.valueOf(13));
        assertEquals(info.levels[1],BigInteger.valueOf(7));
        assertEquals(info.levels[2],BigInteger.valueOf(9));

        info = t.createSequence(BigInteger.valueOf(9439590),BigInteger.valueOf(9825173));
        assertTrue(info.levels[0].compareTo(BigInteger.valueOf(4)) == 0);
        assertTrue(info.levels[1].compareTo(BigInteger.valueOf(8)) == 0);
        assertTrue(info.levels[2].compareTo(BigInteger.valueOf(55)) == 0);
        assertTrue(info.levels[3].compareTo(BigInteger.valueOf(38)) == 0);

        assertTrue(info.sequence.size() == 7);
        assertTrue(info.sequence.get(0)[1].compareTo(BigInteger.ONE) == 0);
        assertTrue(info.sequence.get(1)[1].compareTo(BigInteger.ONE) == 0);
        assertTrue(info.sequence.get(2)[1].compareTo(BigInteger.valueOf(4)) == 0);
        assertTrue(info.sequence.get(3)[1].compareTo(BigInteger.valueOf(38)) == 0);
        assertTrue(info.sequence.get(4)[1].compareTo(BigInteger.valueOf(51)) == 0);
        assertTrue(info.sequence.get(5)[1].compareTo(BigInteger.valueOf(7)) == 0);
        assertTrue(info.sequence.get(6)[1].compareTo(BigInteger.valueOf(3)) == 0);


        /*9439590
        9825173

        7
        0 1
        1 1
        2 4
        3 38
        2 51
        1 7
        0 3
*/
/*
        System.out.println("Test 8 start ...");
        info = t.createSequence(BigInteger.valueOf(42),BigInteger.valueOf(10).pow(1000000));
        System.out.println("... finished ");
        info.printSequence();
*/

        info = t.createSequence(BigInteger.valueOf(11790),BigInteger.valueOf(713302));
        System.out.println("Test 9 : " + Arrays.toString(info.levels));
        info.printSequence();

        assertTrue(info.sequence.size() == 6);
        assertTrue(info.sequence.get(0)[1].compareTo(BigInteger.valueOf(1)) == 0);
        assertTrue(info.sequence.get(1)[1].compareTo(BigInteger.valueOf(1)) == 0);
        assertTrue(info.sequence.get(2)[1].compareTo(BigInteger.valueOf(82)) == 0);
        assertTrue(info.sequence.get(3)[1].compareTo(BigInteger.valueOf(69)) == 0);
        assertTrue(info.sequence.get(4)[1].compareTo(BigInteger.valueOf(33)) == 0);
        assertTrue(info.sequence.get(5)[1].compareTo(BigInteger.valueOf(2)) == 0);
/*
        11790
        713302

        6
0 1
1 1
2 82
3 69
2 33
0 2
*/
        BigInteger left;
        BigInteger right;
        long start = System.currentTimeMillis();
        File f = new File("C:\\Users\\jmelon.SCOTT\\IdeaProjects\\Java 8 Quizzes\\src\\java8\\Hackerrank\\Trees\\TenSquareTreeCase41.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            left = new BigInteger(br.readLine());
            System.out.println("Reading first number:" + (System.currentTimeMillis() - start));
            right = new BigInteger(br.readLine());
            System.out.println("Reading second number:" + (System.currentTimeMillis() - start));
            info = t.createSequence(left,right);
            System.out.println("Calculation: " + (System.currentTimeMillis() - start));
            info.printSequence();
            System.out.println("Output: " + (System.currentTimeMillis() - start));
        } catch (Exception e) {
            System.out.println(e.toString());
            Assert.fail();
        }
    }


}
