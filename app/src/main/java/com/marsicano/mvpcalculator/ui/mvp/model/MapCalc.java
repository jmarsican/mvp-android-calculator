package com.marsicano.mvpcalculator.ui.mvp.model;

import com.marsicano.mvpcalculator.ui.Operator;

import java.util.Hashtable;

/**
 * Created by jmarsiscano on 04/11/15.
 */
public class MapCalc implements ICalcModel {
    //Mock implementation that emulates a repository of results
    Hashtable<String,Double> calculator;

    public MapCalc(){
        calculator = new Hashtable<>();
        calculator.put("2.0"+ Operator.ADD.getSymbol() + "2.0",new Double(4));
        calculator.put("2.0"+ Operator.SUB.getSymbol() + "2.0",new Double(0));
        calculator.put("2.0"+ Operator.MUL.getSymbol() + "2.0",new Double(4));
        calculator.put("2.0"+ Operator.DIV.getSymbol() + "2.0",new Double(1));
    }

    @Override
    public double add(double op1, double op2) {
        Double out = calculator.get(op1+Operator.ADD.getSymbol()+op2);
        if(out != null)
            return out;
        return 0;
    }

    @Override
    public double mult(double op1, double op2) {
        Double out = calculator.get(op1+Operator.MUL.getSymbol()+op2);
        if(out != null)
            return out;
        return 0;
    }

    @Override
    public double div(double op1, double op2) {
        Double out = calculator.get(op1+Operator.DIV.getSymbol()+op2);
        if(out != null)
            return out;
        return 0;
    }

    @Override
    public double sub(double op1, double op2) {
        Double out = calculator.get(op1+Operator.SUB.getSymbol()+op2);
        if(out != null)
            return out;
        return 0;
    }
}
