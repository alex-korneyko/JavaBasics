package ua.in.codegym;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Alex Korneyko on 03.05.2016.
 */
@RunWith(value = Parameterized.class)
public class ParametrizedReversePolishNotationTest {

    ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
    String expression;
    int result;

    public ParametrizedReversePolishNotationTest(String expression, int result) {
        this.expression = expression;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {"2 5 +", 7},
                {"5 2 -", 3},
                {"44 11 /", 4},
                {"5 6 7 + -", -8},
                {"50 4 6 + /", 5},
                {"2 25 55 - *", (-60)},
                {"5 10 + 8 - 5 *", 35}
        });
    }

    @Test(timeout = 1000)
    public void testEvaluate() throws Exception {

        Assert.assertEquals(result, reversePolishNotation.evaluate(expression));
    }
}