package com.marsicano.mvpcalculator.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marsicano.mvpcalculator.R;
import com.marsicano.mvpcalculator.ui.mvp.view.ICalcView;


public class CalculatorUserFriendly extends Fragment implements ICalcView {
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;


    public CalculatorUserFriendly() {
        // Required empty public constructor
    }

    public static CalculatorUserFriendly newInstance(String param1, String param2) {
        CalculatorUserFriendly fragment = new CalculatorUserFriendly();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculator_user_friendly, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void updateDisplay(double value) {

    }

    @Override
    public void calculate(CalculationEvent event) {

    }
}
