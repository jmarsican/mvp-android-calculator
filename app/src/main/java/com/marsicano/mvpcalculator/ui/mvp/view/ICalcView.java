package com.marsicano.mvpcalculator.ui.mvp.view;

/**
 * Created by javier on 20/10/15.
 */
public interface ICalcView {

    void updateDisplay(double value);

    void calculate(CalculationEvent event);

    class CalculationEvent{
        double op1;
        double op2;

        public CalculationEvent(double op1, double op2) {
            this.op1 = op1;
            this.op2 = op2;
        }

        public double getOp1() {
            return op1;
        }

        public double getOp2() {
            return op2;
        }
    }

    public class AddEvent extends CalculationEvent{
        public AddEvent(double op1, double op2) {
            super(op1, op2);
        }
    }

    public class MultEvent extends CalculationEvent{
        public MultEvent(double op1, double op2) {
            super(op1, op2);
        }
    }

    public class SubEvent extends CalculationEvent{
        public SubEvent(double op1, double op2) {
            super(op1, op2);
        }
    }

    public class DivEvent extends CalculationEvent{
        public DivEvent(double op1, double op2) {
            super(op1, op2);
        }
    }

}
