package home.calculator;

import home.calculator.exception.DivideByNullException;
import home.calculator.exception.IncorrectOperationTypeException;
import org.junit.Test;

import static home.calculator.Calculator.*;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void shouldAddDigitsWhenOperationNameIsAdd() throws Exception {
        double resultAdd = Calculator.startOperation("ADD 4 6");
        assertEquals(10, resultAdd, 0.01);
    }

    @Test
    public void shouldSubtractDigitsWhenOperationNameIsSub() throws Exception {
        double resultSub = Calculator.startOperation("SUB 6 5");
        assertEquals(1, resultSub, 0.01);
    }

    @Test
    public void shouldMultiplyDigitsWhenOperationNameIsMul() throws Exception {
        double resultMul = Calculator.startOperation("MUL 2 4");
        assertEquals(8, resultMul, 0.01);
    }

    @Test
    public void shouldDivideDigitsWhenOperationNameIsDiv() throws Exception {
        double resultDiv = Calculator.startOperation("DIV 8 2");
        assertEquals(4, resultDiv, 0.01);
    }

    @Test
    public void shouldAddDigitsWhenAddIsEvaluated() {
        String operation = "ADD 4 6";
        String[] strings = splitString(operation);
        int result = add(strings);
        assertEquals(10, result);
    }

    @Test
    public void shouldSubtractDigitsWhenSubIsEvaluated() {
        String operation = "SUB 10 3";
        String[] strings = splitString(operation);
        int result = sub(strings);
        assertEquals(7, result);
    }

    @Test
    public void shouldMultiplyDigitsWhenMulIsEvaluated() {
        String operation = "MUL 2 2";
        String[] strings = splitString(operation);
        int result = mul(strings);
        assertEquals(4, result);
    }

    @Test
    public void shouldDivideDigitsWhenDivIsEvaluated() throws DivideByNullException {
        String operation = "DIV 18 6";
        String[] strings = splitString(operation);
        double result = dev(strings);
        assertEquals(3, result, 0.01);
    }

    @Test(expected = IncorrectOperationTypeException.class)
    public void shouldThrowExceptionWhenOperationIsIncorrect() throws Exception {
        Calculator.startOperation("CLL 4 6");
    }

    @Test(expected = DivideByNullException.class)
    public void shouldThrowExceptionWhenDivideByZero() throws DivideByNullException {
        String operation = "DIV 23 0";
        String[] strings = splitString(operation);
        dev(strings);
    }
}