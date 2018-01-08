package com.sseyvach.ThreadsEx1.model;

public class Inits {
    int valStart;
    int valFinish;
    int valStep;

    public Inits() {}

    public Inits(int valStart, int valFinish, int valStep) {
        this.valStart = valStart;
        this.valFinish = valFinish;
        this.valStep = valStep;
    }

    public int getValStart() {
        return valStart;
    }

    public void setValStart(int valStart) {
        this.valStart = valStart;
    }

    public int getValFinish() {
        return valFinish;
    }

    public void setValFinish(int valFinish) {
        this.valFinish = valFinish;
    }

    public int getValStep() {
        return valStep;
    }

    public void setValStep(int valStep) {
        this.valStep = valStep;
    }
}
