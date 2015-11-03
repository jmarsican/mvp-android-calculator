package com.marsicano.mvpcalculator.ui;

/**
 * Created by jmarsiscano on 03/11/15.
 */
public enum Operator {
    ADD("add","+"),
    MUL("multiplicate","*"),
    SUB("subtract","-"),
    DIV("divide","/");

    private String name, symbol;

    Operator(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return name;
    }
}
