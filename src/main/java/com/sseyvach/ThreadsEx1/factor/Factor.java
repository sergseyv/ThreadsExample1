package com.sseyvach.ThreadsEx1.factor;
import java.math.BigInteger;

    /*
    * Обычный факториал, нерекурсивный.
    * Рекурсивный падает по StackOverflowError при больших значениях.
    *
    * */
public class Factor {
    static BigInteger factorial(int num) {
        BigInteger result = BigInteger.ONE;
        while (num > 0) {
            result = result.multiply(BigInteger.valueOf(num--));
        }
        return result;
    }

    /*
    * Половина факториала, для одного из двух потоков.
    * Перемножает только нечетные числа.
    *
    * */
    static BigInteger factorOdd (int num){
        BigInteger result = BigInteger.ONE;
        while (num > 1) {
            result = result.multiply(BigInteger.valueOf(num));
            num -= 2;
        }
        return result;

    }

    /*
   * Половина факториала, для одного из двух потоков.
   * Перемножает только четные числа.
   *
   * */
    static BigInteger factorEven (int num){
        BigInteger result = BigInteger.ONE;
        while (num > 0) {
            result = result.multiply(BigInteger.valueOf(num));
            num -= 2;
        }
        return result;
    }

}
