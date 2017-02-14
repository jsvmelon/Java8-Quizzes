package java8.chapter5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

/**
 * Created by jmelon on 24/11/2016.
 */
public class Chapter5 {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Query 1
        System.out.println(transactions.stream().
                filter(t -> t.getYear() == 2011).
                sorted(comparingInt(Transaction::getValue)).
                collect(toList()));

        // Query 2
        System.out.println(Stream.of(raoul,mario,alan,brian).map(t -> t.getCity()).distinct().collect(toList()));
        System.out.println(transactions.stream().map(t -> t.getTrader().getCity()).distinct().collect(toList()));

        // Query 3
        System.out.println(
                Stream.of(raoul,mario,alan,brian).
                        filter(t -> t.getCity().equals("Cambridge")).
                        map(t -> t.getName()).sorted(String::compareTo).
                        collect(toList())
        );

        // Query 4
        System.out.println(
                Stream.of(raoul,mario,alan,brian).
                        map(t -> t.getName()).sorted(String::compareTo).
                        collect(toList())
        );

        // Query 5
        System.out.println(
                Stream.of(raoul,mario,alan,brian).anyMatch(t -> t.getCity().equals("Milan"))
        );

        // Query 6
        System.out.println(
                transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).
                        map(Transaction::getValue).collect(toList())
        );

        // Query 7
        System.out.println(
                transactions.stream().map(t -> t.getValue()).collect(maxBy(Integer::compare))
        );

        // Query 8
        System.out.println(
                transactions.stream().collect(reducing((t1,t2) -> t1.getValue() < t2.getValue() ? t1 : t2))
        );

        // own stuff
        System.out.println(
                transactions.stream().collect(groupingBy(Transaction::getYear,groupingBy(Transaction::getValue)))
        );

        System.out.println(
                transactions.stream().collect(collectingAndThen(toList(), (List<Transaction> l) -> Optional.of(l)))
        );

        System.out.println(
                transactions.stream().collect(
                        collectingAndThen(
                                groupingBy(Transaction::getValue), (Map<Integer, List<Transaction>> l) -> Optional.of(l)))
        );
    }
}
