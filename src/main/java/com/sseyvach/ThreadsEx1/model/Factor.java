package com.sseyvach.ThreadsEx1.model;
import java.math.BigInteger;

public class Factor {

    static BigInteger factorial(int num) {
        BigInteger result = BigInteger.ONE;
        while (num > 0) {
            result = result.multiply(BigInteger.valueOf(num--));
        }
        return result;
    }

    static BigInteger factorOdd (int num){
        BigInteger result = BigInteger.ONE;
        while (num > 1) {
            result = result.multiply(BigInteger.valueOf(num));
            num -= 2;
        }
        return result;

    }

    static BigInteger factorEven (int num){
        BigInteger result = BigInteger.ONE;
        while (num > 0) {
            result = result.multiply(BigInteger.valueOf(num));
            num -= 2;
        }
        return result;

    }

}
