package ua.in.codegym;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class ParametrizedColorChainTest {

    ColorChain colorChain = new ColorChain();
    int argument;
    int count;

    public ParametrizedColorChainTest(int argument, int count) {
        this.argument = argument;
        this.count = count;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 2},
                {3, 4},
                {4, 7},
                {5, 13},
                {6, 24},
                {7, 44},
                {8, 81}
        });
    }

    @Test(timeout = 1000)
    public void testCount() throws Exception {

        assertEquals(count, colorChain.count(argument));
    }
}