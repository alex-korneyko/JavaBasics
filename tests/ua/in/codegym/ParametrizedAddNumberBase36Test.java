package ua.in.codegym;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by Alex Korneyko on 01.05.2016.
 */
@RunWith(value = Parameterized.class)
public class ParametrizedAddNumberBase36Test {

    AddNumberBase36 addNumberBase36 = new AddNumberBase36();
    String argumentA;
    String argumentB;
    String result;

    public ParametrizedAddNumberBase36Test(String argumentA, String argumentB, String result) {
        this.argumentA = argumentA;
        this.argumentB = argumentB;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {"0", "5", "5"},
                {"2", "3", "5"},
                {"5", "5", "a"},
                {"999", "1", "99a"},
                {"C", "1", "d"},
                {"zzz", "1", "1000"}
        });
    }

    @Test
    public void testAdd() throws Exception {

        Assert.assertEquals(result, addNumberBase36.add(argumentA, argumentB));
    }
}