package java8.Hackerrank.Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by jmelon on 20/12/2016.
 */
public class TenSquareTree {

    private static final BigInteger two = BigInteger.valueOf(2);
    private static final BigInteger[] intervalSizes = new BigInteger[21];

    class Info {
        int k;
        final BigInteger[] levels = new BigInteger[21];
        // --Commented out by Inspection (01/01/2017 18:55):BigInteger modifiedLeft;
        final List<BigInteger[]> sequence = new ArrayList<>();
        Info() {
            Arrays.fill(levels,BigInteger.ZERO);
        }

        void addToSequence(int level, BigInteger numberOfKLevels) {
            if (numberOfKLevels.compareTo(BigInteger.ZERO) == 0) return;

            BigInteger[] newElement = new BigInteger[2];
            newElement[0] = BigInteger.valueOf(level);
            newElement[1] = numberOfKLevels;
            if (sequence.isEmpty()) sequence.add(newElement);
            else {
                BigInteger[] last = sequence.get(sequence.size()-1);
                if (last[0].compareTo(BigInteger.valueOf(level)) == 0) {
                    last[1] = last[1].add(numberOfKLevels);
                    sequence.set(sequence.size()-1, last);
                } else sequence.add(newElement);
            }
        }

        void printSequence() {
            System.out.println(sequence.size());
            sequence.forEach((BigInteger[] a) -> {
                System.out.println(a[0] + " " + a[1]);
            });
        }
    }

    public TenSquareTree() {
        intervalSizes[0] = BigInteger.ONE;
        for (int k = 1 ; k < 21 ; k++) {
            intervalSizes[k] = BigInteger.TEN.pow((int) Math.pow(2, k-1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger left = new BigInteger(br.readLine());
        BigInteger right = new BigInteger(br.readLine());
        Info result = new TenSquareTree().createSequence(left, right);

        result.printSequence();
    }

    // the lower bound (left) needs to be filled up to ever higher ten-square levels until
    // either right is reached or overshot
    // that results in a right threshold for level k after which
    // smaller levels need to be used to fill up until right is reached

    /*
     * Starting from left fill up
      * Level k = 0 consists of the simple positive integer series 1, 2, 3, ...
     */
    public Info createSequence(BigInteger left, BigInteger right) {
        Info info = new Info();
        BigInteger modifiedLeft = left;

        // this loop is for moving up in the interval levels
        for (int k = 0 ; k < 21 && k >= 0 ; k++) {
            BigInteger intervalSizeK = intervalSize(k);
            info.k = k;
            BigInteger nextBeginning;
            BigInteger nextEnd;

            if (k == 20) {
                // there is no next interval to use - we just fill up using the current interval as close to right as possible and move downwards then
                BigInteger n = numberOfKIntervalsToRight(modifiedLeft, right, k);
                info.addToSequence(k,n);
                info.levels[k] = info.levels[k].add(n);
                modifiedLeft = modifiedLeft.add(n.multiply(intervalSizeK));
                if (modifiedLeft.compareTo(right.add(BigInteger.ONE)) == 0) return info; // if we reach right exactly we are done
                break;
            }

            if (!isAtBeginning(modifiedLeft, k+1)) {
                nextBeginning = nextIntervalBeginning(modifiedLeft, k+1);
                // (1) either we move to the beginning of the next k+1 interval (if it is not too big)
                // (2) or we move as close to right as possible using k intervals, lower intervals afterwards
                //if (nextBeginning >= right) {
                if (nextBeginning.compareTo(right) > 0) {
                    // move as many k intervals as possible, then nothing needs to be done with k intervals and we should step down instead
                    BigInteger n = numberOfKIntervalsToRight(modifiedLeft, right, k);
                    info.addToSequence(k,n);
                    info.levels[k] = info.levels[k].add(n);
                    modifiedLeft = modifiedLeft.add(n.multiply(intervalSizeK));
                    // this means we move to smaller intervals now !!! (or we might be done)
                    if (modifiedLeft.compareTo(right.add(BigInteger.ONE)) == 0) return info;
                    break;
                } else {
                    // move to the beginning using k intervals
                    BigInteger n = numberOfKIntervalsToRight(modifiedLeft, nextBeginning.subtract(BigInteger.ONE), k);
                    info.addToSequence(k,n);
                    info.levels[k] = info.levels[k].add(n);
                    modifiedLeft = modifiedLeft.add(n.multiply(intervalSizeK));
                }
            }
            // now we are  at the beginning of the k+1 interval beginning
            nextEnd = nextIntervalEnd(modifiedLeft, k+1);
            if (nextEnd.compareTo(right) > 0) {
                // we can't use k+1 intervals as they are too big
                BigInteger n = numberOfKIntervalsToRight(modifiedLeft, right, k);
                info.addToSequence(k,n);
                info.levels[k] = info.levels[k].add(n);
                modifiedLeft = modifiedLeft.add(n.multiply(intervalSizeK));
                // this means we move to smaller intervals now !!! (or we might be done)
                if (modifiedLeft.compareTo(right.add(BigInteger.ONE)) == 0) return info;
                break;
            } else {
                // we need to go to k+1 intervals
            }

        }

        for (int k = info.k - 1; k >= 0 ; k--) {
            BigInteger intervalSizeK = intervalSize(k);
            BigInteger n = numberOfKIntervalsToRight(modifiedLeft, right, k);
            info.addToSequence(k,n);
            info.levels[k] = info.levels[k].add(n);
            modifiedLeft = modifiedLeft.add(n.multiply(intervalSizeK));
            if (modifiedLeft.compareTo(right.add(BigInteger.ONE)) == 0) return info;
        }

        return info;
    }

    public BigInteger nextIntervalEnd(BigInteger position, int k) {
        if (k == 0) return position.add(BigInteger.ONE);

        BigInteger intervalSize = intervalSize(k);
        BigInteger endPos;
        if (isAtBeginning(position, k))
            endPos = position.subtract(position.mod(intervalSize)).add(intervalSize);
        else if (position.mod(intervalSize).compareTo(BigInteger.ZERO) == 0) {
            endPos = position.subtract(position.mod(intervalSize)).add(intervalSize);
        } else {
            endPos = position.subtract(position.mod(intervalSize)).add(intervalSize.multiply(two));
        }

        return endPos;
    }

    public BigInteger nextIntervalBeginning(BigInteger position, int k) {
        if (k == 0) return position;
        if (isAtBeginning(position,k)) return position;
        return nextIntervalEnd(position, k).subtract(intervalSize(k)).add(BigInteger.ONE);
    }

    // this returns the number of whole k level intervals between left and right
    public BigInteger numberOfKIntervalsToRight(BigInteger left, BigInteger right, int k) {
        if (areInSameInterval(left, right, k)) {
            if (isAtBeginning(left, k) && (isAtEnd(right, k))) return BigInteger.ONE;
            else return BigInteger.ZERO;
        }

        BigInteger intervalSize = intervalSize(k);
        BigInteger modifiedLeft, modifiedRight;

        if (isAtBeginning(left,k)) {
            return right.subtract(right.mod(intervalSize)).subtract(left).add(BigInteger.ONE).divide(intervalSize);
        }
        else {
            return right.subtract(right.mod(intervalSize)).subtract(left.add(intervalSize.subtract(left.mod(intervalSize)).add(BigInteger.ONE))).add(BigInteger.ONE).divide(intervalSize);
        }

// This is the cleaner code but needs more object creations

/*
        if (isAtBeginning(left,k)) modifiedLeft = left;
        else modifiedLeft = left.add(intervalSize.subtract(left.mod(intervalSize)).add(BigInteger.ONE));

        modifiedRight = right.subtract(right.mod(intervalSize));

        // now modifiedLeft and modifiedRight are at the beginning and end of the next and previous interval respectively
        return modifiedRight.subtract(modifiedLeft).add(BigInteger.ONE).divide(intervalSize);
*/
    }

    public BigInteger intervalSize(int k) {
        return intervalSizes[k];
        //if (k == 0) return BigInteger.ONE;
        //return new BigInteger("10").pow((int) Math.pow(2, k-1));
    }

    public boolean areInSameInterval(BigInteger left, BigInteger right, int k) {
        BigInteger intervalSize = intervalSize(k);
        BigInteger intervalEnd;


        if (isAtEnd(left,k)) {
            if (right.compareTo(left) > 0) return false;
            else return true;
        } else {
            if (right.compareTo(left.subtract(left.mod(intervalSize)).add(intervalSize)) > 0) return false;
            else return true;
        }


/*
        if (isAtEnd(left,k)) intervalEnd = left;
        else intervalEnd = left.subtract(left.mod(intervalSize)).add(intervalSize);

        if (right.compareTo(intervalEnd) > 0) return false;
        else return true;
*/
    }

    public boolean isAtBeginning(BigInteger left, int k) {
        if (k == 0) return true;
        return left.mod(intervalSize(k)).compareTo(BigInteger.ONE) == 0;
    }

    public boolean isAtEnd(BigInteger right, int k) {
        if (k == 0) return true;
        return right.mod(intervalSize(k)).compareTo(BigInteger.ZERO) == 0;
    }

}
