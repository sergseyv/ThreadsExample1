/*
* Основной модуль просчета факториалов двумя способами (1 и 2 потока)
*
* */

package com.sseyvach.ThreadsEx1.factor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactorMap {

    public static List <Map<Integer, Integer>> getMaps(int valStart, int valFinish, int valStep) {

        // значения факториалов, в данной программе не нужны, но чтоб не пропадали - выведем в консоль.
        BigInteger factorResult1 = BigInteger.ONE;
        BigInteger factorResult2 = BigInteger.ONE;

        // нечетная половина факториала
        final BigInteger[] factorOdd = new BigInteger[1];

        // четная половина факториала
        final BigInteger[] factorEven = new BigInteger[1];

        // исходное число
        final int[] number = new int[1];

        //хешмапы для хранения исходного числа и времени просчета его факториала
        Map<Integer, Integer> times1 = new HashMap<>();
        Map<Integer, Integer> times2 = new HashMap<>();


        // основной цикл, по всему диапазону исходных чисел
        for ( number[0] = valStart; number[0] < valFinish; number[0] += valStep ) {

            //однопоточное вычисление, засекаем время, считаем
            long startTime1 = System.nanoTime();
            factorResult1 = Factor.factorial(number[0]);
            long estimatedTime1 = System.nanoTime() - startTime1;



            // ************** двухпоточное вычисление ********************

            // Первый поток, по нечетным числам
            Thread tr1 = new Thread(() -> {
                if (number[0] % 2 == 0) {
                    factorOdd[0] = Factor.factorOdd(number[0] - 1);
                } else {
                    factorOdd[0] = Factor.factorOdd(number[0]);
                }
            });

            // Второй поток, по четным числам
            Thread tr2 = new Thread(() -> {
                if (number[0] % 2 == 1) {
                    factorEven[0] = Factor.factorEven(number[0] - 1);
                } else {
                    factorEven[0] = Factor.factorEven(number[0]);
                }
            });

            //запускаем потоки, засекаем время
            long startTime2 = System.nanoTime();

            tr1.start();
            tr2.start();

            // джойнимся, ждем когда оба потока отработают
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

            // перемножаем четные и нечетные произведения, получаем факториал
            factorResult2 = factorOdd[0].multiply(factorEven[0]);

            // запоминаем время работы двух потоков
            long estimatedTime2 = System.nanoTime() - startTime2;

            // сохраняем в хешмапы исходное число и время просчета его факториала
            times1.put(number[0], (int) estimatedTime1 / 1_000_000);
            times2.put(number[0], (int) estimatedTime2 / 1_000_000);
        }

        // вывод значений факториала в консоль, потому что могу)).
        System.out.println("=====================================================");
        System.out.println("One thread result: " + factorResult1);
        System.out.println("Two thread result: " + factorResult2);
        System.out.println("=====================================================");

        // пакуем хешмапы в список и возвращаем
        List<Map<Integer, Integer>> list = new ArrayList<>();
        list.add(times1);
        list.add(times2);
        return (list);
    }
}
