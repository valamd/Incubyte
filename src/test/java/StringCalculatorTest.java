
package org.manish;

import org.Manish.StringCalculator;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @Before
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void add_should_returnZero_whenInputIsEmpty() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void add_should_returnNumber_whenSingleNumberGiven() {
        assertEquals(5, calculator.add("5"));
    }

    @Test
    public void add_should_returnSum_whenTwoNumbersCommaDelimited() {
        assertEquals(3 + 5, calculator.add("3,5"));
    }

    @Test
    public void add_should_returnSum_whenInputHasCommasAndNewlines() {
        assertEquals(1 + 2 + 3, calculator.add("1\n2,3"));
    }

    @Test
    public void add_should_returnSum_whenCustomSingleCharDelimiterUsed() {
        assertEquals(2 + 3, calculator.add("//;\n2;3"));
    }

    @Test
    public void add_should_returnSum_whenCustomDelimiterHasAnyLength() {
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void add_should_returnSum_whenMultipleCustomDelimitersGiven() {
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void add_should_returnSum_whenDelimitersHaveDifferentLengths() {
        assertEquals(6, calculator.add("//[**][%%]\n1**2%%3"));
    }

    @Test
    public void add_shouldThrowException_whenNegativeNumbersExist() {
        try {
            calculator.add("1,-2,3,-4");
            fail("Exception expected for negative numbers");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers not allowed: -2, -4", e.getMessage());
        }
    }
}
