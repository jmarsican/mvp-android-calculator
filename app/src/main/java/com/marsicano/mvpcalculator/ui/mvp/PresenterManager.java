package com.marsicano.mvpcalculator.ui.mvp;

import com.marsicano.mvpcalculator.ui.mvp.model.HighLevelCalc;
import com.marsicano.mvpcalculator.ui.mvp.model.ICalcModel;
import com.marsicano.mvpcalculator.ui.mvp.presenter.CalcPresenter;
import com.marsicano.mvpcalculator.ui.mvp.view.ICalcView;

/**
 * Created by jmarsicano on 03/11/15.
 */
public class PresenterManager {
    //singleton to provide the correct presenter to each client
    private static PresenterManager instance;

    private static CalcPresenter presenter;
    private static ICalcModel calculator;

    private PresenterManager(){
    }

    public static PresenterManager getInstance(){
        if(instance == null){
            instance = new PresenterManager();
        }
        return instance;
    }

    public void initCalcPresenter(ICalcView view){
        calculator = new HighLevelCalc();
        presenter = new CalcPresenter(calculator,view);
    }

}
