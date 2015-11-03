package com.marsicano.mvpcalculator.ui.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.marsicano.mvpcalculator.R;
import com.marsicano.mvpcalculator.ui.Operator;
import com.marsicano.mvpcalculator.ui.mvp.PresenterManager;
import com.marsicano.mvpcalculator.ui.mvp.view.ICalcView;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class CalculatorSingleFragment extends Fragment implements ICalcView, AdapterView.OnItemSelectedListener {

    private TextView result;
    private EditText operand1;
    private EditText operand2;
    private Spinner operator;

    private ArrayList<IComputationListener> subscribedListeners = new ArrayList<>();

    public CalculatorSingleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_calculator_static, container, false);
        operand1 = (EditText) view.findViewById(R.id.first_operand);
        operand2 = (EditText) view.findViewById(R.id.second_operand);
        operator = (Spinner) view.findViewById(R.id.operation_selector);
        result = (TextView) view.findViewById(R.id.result_text);

        init();

        //bind to the corresponding presenter
        PresenterManager.getInstance().initCalcPresenter(this);

        return view;
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
    public void updateDisplay(double value) {
        result.setText("RESULT: "+ Double.toString(value));
    }

    @Override
    public double getOperand1() {
        String text = operand1.getText().toString();
        return Double.parseDouble(text);
    }

    @Override
    public double getOperand2() {
        String text = operand2.getText().toString();
        return Double.parseDouble(text);
    }

    @Override
    public void subscribe(IComputationListener listener) {
        subscribedListeners.add(listener);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(!TextUtils.isEmpty(operand1.getText()) && !TextUtils.isEmpty(operand2.getText())) {
            //notifiy each subscribed listener to perform the calculation
            switch ((Operator) operator.getAdapter().getItem(position)) {
                case ADD:
                    for (IComputationListener listener : subscribedListeners) {
                        listener.onAdd();
                    }
                    break;
                case MUL:
                    for (IComputationListener listener : subscribedListeners) {
                        listener.onMult();
                    }
                    break;
                case DIV:
                    for (IComputationListener listener : subscribedListeners) {
                        listener.onDiv();
                    }
                    break;
                case SUB:
                    for (IComputationListener listener : subscribedListeners) {
                        listener.onSub();
                    }
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
