package com.marsicano.mvpcalculator.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marsicano.mvpcalculator.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class CalculatorStaticActivityFragment extends Fragment {

    public CalculatorStaticActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculator_static, container, false);
    }
}
