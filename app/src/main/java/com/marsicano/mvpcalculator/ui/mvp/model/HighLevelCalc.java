package com.marsicano.mvpcalculator.ui.mvp.model;

/**
 * Created by javier on 28/10/15.
 */
public class HighLevelCalc implements ICalcModel {

    @Override
    public double add(double op1, double op2) {
        return op1 + op2;
    }

    @Override
    public double mult(double op1, double op2) {
        return op1 * op2;
    }

    @Override
    public double div(double op1, double op2) {
        if(op2 != 0)
            return op1 / op2;
        else
            throw new IllegalArgumentException("cannot divide by zero");
    }

    @Override
    public double sub(double op1, double op2) {
        return op1 - op2;
    }
}
