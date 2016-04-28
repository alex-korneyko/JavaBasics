package ua.in.codegym;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by admin on 28.04.2016.
 */
@RunWith(value = Parameterized.class)
public class ParametrizedCountBitsTest {

    CountBits countBits = new CountBits();
    int argument;
    int result;

    public ParametrizedCountBitsTest(int argument, int result) {
        this.argument = argument;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {13, 3},
                {0, 0},
                {-1, 32},
                {Integer.MAX_VALUE, 31},
                {Integer.MIN_VALUE, 1}
        });
    }

    @Test
    public void testCount() throws Exception {

        Assert.assertEquals(result, countBits.count(argument));
    }
}