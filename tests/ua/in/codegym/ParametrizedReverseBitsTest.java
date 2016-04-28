package ua.in.codegym;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by admin on 27.04.2016.
 */
@RunWith(value = Parameterized.class)
public class ParametrizedReverseBitsTest {

    ReverseBits reverseBits = new ReverseBits();
    int argument;
    int result;

    public ParametrizedReverseBitsTest(int argument, int result) {
        this.argument = argument;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {2, 1073741824},
                {-2147483647, -2147483647}
        });
    }

    @Test
    public void testReverse() throws Exception {

        Assert.assertEquals(result,reverseBits.reverse(argument));
    }
}