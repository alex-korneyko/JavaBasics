package ua.in.codegym;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Alex Korneyko on 04.05.2016.
 */
@RunWith(value = Parameterized.class)
public class ParametrizedLongestStabilityPeriodTest {

    LongestStabilityPeriod longestStabilityPeriod = new LongestStabilityPeriod();
    int[] argument;
    int result;

    public ParametrizedLongestStabilityPeriodTest(int[] argument, int result) {
        this.argument = argument;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {new int[]{900, 901, 902}, 2},
                {new int[]{900, 900, 900, 901, 902, 902, 903, 903}, 4},
                {new int[]{901, 901, 901, 902, 902, 903, 903, 902, 902, 901}, 6}
        });
    }

    @Test
    public void testCount() throws Exception {

        Assert.assertEquals(result, longestStabilityPeriod.count(argument));
    }
}