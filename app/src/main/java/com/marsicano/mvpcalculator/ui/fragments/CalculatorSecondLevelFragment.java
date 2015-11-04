package com.marsicano.mvpcalculator.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marsicano.mvpcalculator.R;

public class CalculatorSecondLevelFragment extends Fragment {

    private static final String RESULT = "result";

    private String result;

    public CalculatorSecondLevelFragment() {
        // Required empty public constructor
    }

    public static CalculatorSecondLevelFragment newInstance(String param) {
        CalculatorSecondLevelFragment fragment = new CalculatorSecondLevelFragment();
        Bundle args = new Bundle();
        args.putString(RESULT, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            result = getArguments().getString(RESULT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_calculator_second_level, container, false);

        ((TextView)view.findViewById(R.id.result_display)).setText(result);

        return view;
    }


}
