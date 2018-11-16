package com.marsicano.mvpcalculator.ui.mvp.presenter;

import com.marsicano.mvpcalculator.ui.mvp.model.ICalcModel;
import com.marsicano.mvpcalculator.ui.mvp.view.ICalcView;
import com.marsicano.mvpcalculator.ui.mvp.view.ICalcView.*;

import de.greenrobot.event.EventBus;

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
        EventBus.getDefault().register(this);
    }


    public void onEvent(AddEvent event) {
        double result = model.add(event.getOp1(),event.getOp2());
        gui.updateDisplay(result);
    }


    public void onEvent(MultEvent event) {
        double result = model.mult(event.getOp1(),event.getOp2());
        gui.updateDisplay(result);
    }


    public void onEvent(DivEvent event) {
        double result = model.div(event.getOp1(),event.getOp2());
        gui.updateDisplay(result);
    }


    public void onEvent(SubEvent event) {
        double result = model.sub(event.getOp1(),event.getOp2());
        gui.updateDisplay(result);
    }
}
