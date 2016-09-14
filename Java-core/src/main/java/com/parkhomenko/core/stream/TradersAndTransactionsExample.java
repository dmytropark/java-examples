package com.parkhomenko.core.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Dmytro Parkhomenko
 *         Created on 14.09.16.
 */

public class TradersAndTransactionsExample {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //code 1
        List<Transaction> r1 = transactions
                .stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println("r1 = " + r1);
        //code 2
        List<String> r2 = transactions
                .stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("r2 = " + r2);
        //code 3
        List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

        List<Trader> r3 = traders
                .stream()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        System.out.println("r3 = " + r3);
        //code 4
        String r4 = traders
                .stream()
                .map(Trader::getName)
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
//                .collect(Collectors.joining());

        System.out.println("r4 = " + r4);

//        traders
//                .stream()
//                .map(Trader::getName)
//                .reduce("", )

        //code 5
        boolean r5 = traders
                .stream()
                .anyMatch(trader -> trader.getCity().equals("Milan"));

        System.out.println("r5 = " +  r5);
        //code 6
        transactions
                .stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //code 7
        Optional<Integer> r7 = transactions
                .stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        System.out.println("r7 = " + (r7.isPresent() ? r7.get() : "none"));
        //code 8
//        Optional<Transaction> r8 = transactions
//                .stream()
//                .reduce((t1, t2) -> t1.getValue() > t2.getValue() ? t2 : t1);

        Optional<Transaction> r8 = transactions
                .stream()
                .min(Comparator.comparing(Transaction::getValue));

        System.out.println("r8 = " + (r8.isPresent() ? r8.get() : "none"));
    }

    public static class Trader{
        private final String name;
        private final String city;
        public Trader(String n, String c){
            this.name = n;
            this.city = c;
        }
        public String getName(){
            return this.name;
        }
        public String getCity(){
            return this.city;
        }
        public String toString(){
            return "Trader:"+this.name + " in " + this.city;
        }
    }

    public static class Transaction{
        private final Trader trader;
        private final int year;
        private final int value;
        public Transaction(Trader trader, int year, int value){
            this.trader = trader;
            this.year = year;
            this.value = value;
        }
        public Trader getTrader(){
            return this.trader;
        }
        public int getYear(){
            return this.year;
        }
        public int getValue(){
            return this.value;
        }
        public String toString(){
            return "{" + this.trader + ", " +
                    "year: "+this.year+", " +
                    "value:" + this.value +"}";
        }
    }
}
