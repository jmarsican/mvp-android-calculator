package com.marsicano.mvpcalculator.ui;

/**
 * Created by javier on 20/10/15.
 */
public interface ICalcView {

    void updateDisplay(double value);

    double getOperand1();

    double getOperand2();

    void suscribe(IComputationListener listener);
}
