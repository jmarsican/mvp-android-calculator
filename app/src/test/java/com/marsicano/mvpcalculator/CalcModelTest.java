package com.marsicano.mvpcalculator;

import com.marsicano.mvpcalculator.ui.mvp.model.HighLevelCalc;
import com.marsicano.mvpcalculator.ui.mvp.model.ICalcModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import static org.junit.Assert.*;

/**
 * Created by javier on 22/10/15.
 */

public class CalcModelTest {

    private ICalcModel calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new HighLevelCalc();
    }

    @Test
    public void testAdd(){
        double result = calculator.add(2,2);
        assertTrue(result == 4);
    }
}
