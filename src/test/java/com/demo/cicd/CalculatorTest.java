package com.demo.cicd;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.cicd.exception.InvalidEquationException;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
    int n1 = 50;
    int n2 = 10;
    int result;
    String equation;

    @Test
    @DisplayName("Test Addition Equation")
    public void doAddition() {
        equation = "1";
        result = CicdApplication.doEquation(equation, n1, n2);

        assertEquals(result, n1 + n2);
    }

    @Test
    @DisplayName("Test Subtraction Equation")
    public void doSubtraction() {
        equation = "2";
        result = CicdApplication.doEquation(equation, n1, n2);

        assertEquals(result, n1 - n2);
    }

    @Test
    @DisplayName("Test Multiplication Equation")
    public void doMultiplication() {
        equation = "3";
        result = CicdApplication.doEquation(equation, n1, n2);

        assertEquals(result, n1 * n2);
    }

    @Test
    @DisplayName("Test Division Equation")
    public void doDivision() {
        equation = "4";
        result = CicdApplication.doEquation(equation, n1, n2);

        assertEquals(result, n1 / n2);
    }

    @Test
    @DisplayName("Test InvalidEquationException")
    public void thrownInvalidEquation() {
        InvalidEquationException thrown = assertThrows(InvalidEquationException.class, () -> {
            equation = "5";
            result = CicdApplication.doEquation(equation, n1, n2);
        });

        assertEquals("Please inform a valid equation", thrown.getMessage());
    }
}
