package com.marsicano.mvpcalculator;

import com.marsicano.mvpcalculator.ui.mvp.model.ICalcModel;
import com.marsicano.mvpcalculator.ui.mvp.presenter.CalcPresenter;
import com.marsicano.mvpcalculator.ui.mvp.view.ICalcView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

/**
 * Created by javier on 29/10/15.
 */
public class CalcPresenterTest {

    @Mock
    private ICalcView gui;

    @Mock
    private ICalcModel calculator;

    private CalcPresenter presenter;

    private double op1,op2;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        presenter = new CalcPresenter(calculator,gui);

        op1 = 2.0d;
        op2 = 2.0d;
    }

    // User Story [USMVP-3]
    @Test
    public void testDisplayAddResult() {
        presenter.onEvent(new ICalcView.AddEvent(op1,op2));

        double result = verify(calculator).add(op1, op2);

        verify(gui).updateDisplay(result);
    }

    //User Story [USMVP-2]
    @Test
    public void testDisplaySubResult() {
        presenter.onEvent(new ICalcView.SubEvent(op1,op2));

        double result = verify(calculator).sub(op1, op2);

        verify(gui).updateDisplay(result);
    }

    // User Story [USMVP-1]
    @Test
    public void testDisplayMulResult() {
        presenter.onEvent(new ICalcView.MultEvent(op1,op2));

        double result = verify(calculator).mult(op1, op2);

        verify(gui).updateDisplay(result);
    }

    //User Story [USMVP-4]
    @Test
    public void testDisplayDivResult() {
        presenter.onEvent(new ICalcView.DivEvent(op1,op2));

        double result = verify(calculator).div(op1, op2);

        verify(gui).updateDisplay(result);
    }
}
