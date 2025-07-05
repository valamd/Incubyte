
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
}
