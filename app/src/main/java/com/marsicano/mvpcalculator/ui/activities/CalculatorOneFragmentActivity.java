package com.marsicano.mvpcalculator.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.marsicano.mvpcalculator.R;
import com.marsicano.mvpcalculator.ui.mvp.PresenterManager;
import com.marsicano.mvpcalculator.ui.mvp.view.ICalcView;


public class CalculatorOneFragmentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_static);

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

        //bind to the corresponding presenter
        PresenterManager.getInstance().initCalcPresenter((ICalcView)fragment);
    }
}
