package com.sseyvach.ThreadsEx1.model;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactorMap {

    public static List <Map<Integer, Integer>> getMaps(int valStart, int valFinish) {
        BigInteger factorResult1, factorResult2;
        final BigInteger[] factorOdd = new BigInteger[1];
        final BigInteger[] factorEven = new BigInteger[1];
        final int[] number = new int[1];
        Map<Integer, Integer> times1 = new HashMap<>();
        Map<Integer, Integer> times2 = new HashMap<>();


        for (number[0] = valStart; number[0] < valFinish; number[0]++) {

            Thread tr1 = new Thread(() -> {
                if (number[0] % 2 == 0) {
                    factorOdd[0] = Factor.factorOdd(number[0] - 1);
                } else {
                    factorOdd[0] = Factor.factorOdd(number[0]);
                }
            });

            Thread tr2 = new Thread(() -> {
                if (number[0] % 2 == 1) {
                    factorEven[0] = Factor.factorEven(number[0] - 1);
                } else {
                    factorEven[0] = Factor.factorEven(number[0]);
                }
            });

            long startTime2 = System.nanoTime();

            tr1.start();
            tr2.start();

            try {
                tr1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                tr2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            factorResult2 = factorOdd[0].multiply(factorEven[0]);

            long estimatedTime2 = System.nanoTime() - startTime2;

            long startTime1 = System.nanoTime();
            factorResult1 = Factor.factorial(number[0]);
            long estimatedTime1 = System.nanoTime() - startTime1;

            times1.put(number[0], (int) estimatedTime1 / 1_000_000);
            times2.put(number[0], (int) estimatedTime2 / 1_000_000);

        }

        List<Map<Integer, Integer>> list = new ArrayList<>();
        list.add(times1);
        list.add(times2);
        return (list);

    }
}
