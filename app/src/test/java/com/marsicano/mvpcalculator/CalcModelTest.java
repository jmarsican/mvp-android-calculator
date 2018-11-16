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
        assertTrue("add operation returns wrong result", result == 5);
    }

    @Test
    public void testSub(){
        double result = calculator.sub(2,2);
        assertTrue("subtraction operation returns wrong result",result == 0);
    }

    @Test
    public void testMul(){
        double result = calculator.mult(2, 2);
        assertTrue("multiplication operation returns wrong result",result == 4);
    }

    @Test
    public void testDiv(){
        double result = calculator.div(2, 2);
        assertTrue("division operation returns wrong result",result == 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZeroException() {
        calculator.div(2,0);
    }
}
