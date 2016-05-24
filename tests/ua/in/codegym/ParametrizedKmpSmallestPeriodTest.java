package ua.in.codegym;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Alex Korneyko on 24.05.2016.
 */
@RunWith(value = Parameterized.class)
public class ParametrizedKmpSmallestPeriodTest {

    KmpSmallestPeriod kmpSmallestPeriod = new KmpSmallestPeriod();
    String argument;
    String result;

    public ParametrizedKmpSmallestPeriodTest(String argument, String result) {
        this.argument = argument;
        this.result = result;
    }

    @Test
    public void testFindSmalletstPeriod() throws Exception {
        assertEquals(result, kmpSmallestPeriod.findSmalletstPeriod(argument));
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters(){
        return Arrays.asList(new Object[][]{
                {"aaaaaa", "a"},
                {"abcabcabcabc","abc"},
                {"abdabcabdabc", "abdabc"}
        });
    }
}