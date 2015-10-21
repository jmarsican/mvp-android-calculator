package com.marsicano.mvpcalculator;

import com.marsicano.mvpcalculator.model.ICalcModel;
import com.marsicano.mvpcalculator.ui.ICalcView;

/**
 * Created by javier on 20/10/15.
 */
public class CalcPresenter {
    private ICalcModel model;

    private ICalcView gui;

    public CalcPresenter(ICalcModel model, ICalcView gui) {
        this.model = model;
        this.gui = gui;
    }


}
