package com.marsicano.mvpcalculator.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.marsicano.mvpcalculator.R;
import com.marsicano.mvpcalculator.ui.Operator;
import com.marsicano.mvpcalculator.ui.mvp.view.ICalcView;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;


/**
 * A placeholder fragment containing a simple view.
 */
public class CalculatorFirstLevelFragment extends Fragment implements ICalcView, AdapterView.OnItemSelectedListener {

    private OnFragmentInteractionListener mListener;

    private EditText operand1;
    private EditText operand2;
    private Spinner operator;

    public CalculatorFirstLevelFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_calculator_first_level, container, false);
        operand1 = (EditText) view.findViewById(R.id.first_operand);
        operand2 = (EditText) view.findViewById(R.id.second_operand);
        operator = (Spinner) view.findViewById(R.id.operation_selector);

        init();

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void init(){
        //initialize spinner
        ArrayList<Operator> operators = new ArrayList<>();
        operators.add(Operator.ADD);
        operators.add(Operator.MUL);
        operators.add(Operator.SUB);
        operators.add(Operator.DIV);

        ArrayAdapter<Operator> dataAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, operators);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operator.setAdapter(dataAdapter);
        operator.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String op1 = operand1.getText().toString();
        String op2 = operand2.getText().toString();

        if(!TextUtils.isEmpty(operand1.getText()) && !TextUtils.isEmpty(operand2.getText())) {
            //is required initialize event, add as default operation
            CalculationEvent event = new AddEvent(Double.parseDouble(op1),Double.parseDouble(op2));
            //notifiy each subscribed listener to perform the calculation
            switch ((Operator) operator.getAdapter().getItem(position)) {
                case ADD:
                    event = new AddEvent(Double.parseDouble(op1),Double.parseDouble(op2));
                    break;
                case MUL:
                    event = new MultEvent(Double.parseDouble(op1),Double.parseDouble(op2));
                    break;
                case DIV:
                    event= new DivEvent(Double.parseDouble(op1),Double.parseDouble(op2));
                    break;
                case SUB:
                    event = new SubEvent(Double.parseDouble(op1),Double.parseDouble(op2));
                    break;
            }

            calculate(event);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public interface OnFragmentInteractionListener {
        void showResult(double result);
    }


    /************************MVP events*************************************************/
    @Override
    public void updateDisplay(double value) {
         mListener.showResult(value);
        operand1.setText("");
        operand2.setText("");
    }

    @Override
    public void calculate(CalculationEvent event) {
        EventBus.getDefault().post(event);
    }

}
