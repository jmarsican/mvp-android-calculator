package com.marsicano.mvpcalculator.model;

/**
 * Created by javier on 20/10/15.
 */
public interface ICalcModel {

    double add(double op1,double op2);

    double mult(double op1, double op2);

    double div(double op1, double op2);

    double sub(double op1, double op2);
}
