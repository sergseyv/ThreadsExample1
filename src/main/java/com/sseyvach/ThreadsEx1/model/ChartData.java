/*
* Класс хранит и передает в модель значения для построения графиков
* (исходное число, от которого вычисляется факториал,
* и два значения времени в миллисекундах -
* сколько заняло вычисление одним и двумя потоками)
*
* */

package com.sseyvach.ThreadsEx1.model;

public class ChartData {
    int key;
    int value1;
    int value2;

    public ChartData(int key, int value1, int value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }
}