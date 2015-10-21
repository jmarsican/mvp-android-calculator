package com.marsicano.mvpcalculator.ui;

/**
 * Created by javier on 20/10/15.
 */
public interface ICalcView {

    void updateDisplay();

    void suscribe(IComputationListener listener);
}
