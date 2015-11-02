package com.marsicano.mvpcalculator.ui.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.marsicano.mvpcalculator.R;
import com.marsicano.mvpcalculator.ui.IComputationListener;
import com.marsicano.mvpcalculator.ui.mvp.view.ICalcView;


public class CalculatorOneFragmentActivity extends BaseActivity implements ICalcView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void updateDisplay(double value) {

    }

    @Override
    public double getOperand1() {
        return 0;
    }

    @Override
    public double getOperand2() {
        return 0;
    }

    @Override
    public void subscribe(IComputationListener listener) {

    }
}
