package com.marsicano.mvpcalculator.ui.mvp.presenter;

import com.marsicano.mvpcalculator.ui.mvp.model.ICalcModel;
import com.marsicano.mvpcalculator.ui.mvp.view.ICalcView;
import com.marsicano.mvpcalculator.ui.IComputationListener;

/**
 * Created by javier on 20/10/15.
 */
public class CalcPresenter {
    private ICalcModel model;

    private ICalcView gui;

    public CalcPresenter(ICalcModel model, ICalcView gui) {
        this.model = model;
        this.gui = gui;

        setListeners();
    }

    private void setListeners(){
        gui.subscribe(new IComputationListener() {
            @Override
            public void onAdd() {
                double result = model.add(gui.getOperand1(), gui.getOperand2());
                gui.updateDisplay(result);
            }

            @Override
            public void onMult() {
                double result = model.mult(gui.getOperand1(), gui.getOperand2());
                gui.updateDisplay(result);
            }

            @Override
            public void onDiv() {
                double result = model.div(gui.getOperand1(), gui.getOperand2());
                gui.updateDisplay(result);
            }

            @Override
            public void onSub() {
                double result = model.sub(gui.getOperand1(), gui.getOperand2());
                gui.updateDisplay(result);
            }
        });
    }
}
