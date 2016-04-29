package ua.in.codegym;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by admin on 28.04.2016.
 */
@RunWith(value = Parameterized.class)
public class ParametrizedAddBinaryTest {

    AddBinary addBinary = new AddBinary();
    String argumentA;
    String argumentB;
    String result;

    public ParametrizedAddBinaryTest(String argumentA, String argumentB, String result) {
        this.argumentA = argumentA;
        this.argumentB = argumentB;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {"101", "100", "1001"},
                {"111", "110", "1101"},
                {"0", "0", "0"},
                {"1","11","100"},
                {"1111111111111111111111111111111", "1111111111111111111111111111111", "11111111111111111111111111111110"},
                {"10000000000000000000000000000000", "10000000000000000000000000000000", "100000000000000000000000000000000"}
        });
    }

    @Test
    public void testAdd() throws Exception {

        Assert.assertEquals(result, addBinary.add(argumentA, argumentB));
    }
}