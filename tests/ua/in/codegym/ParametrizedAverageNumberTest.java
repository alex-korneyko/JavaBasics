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
public class ParametrizedAverageNumberTest {

    AverageNumber averageNumber = new AverageNumber();

    int argumentA;
    int argumentB;
    int result;

    public ParametrizedAverageNumberTest(int argumentA, int argumentB, int result) {
        this.argumentA = argumentA;
        this.argumentB = argumentB;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters(){
        return Arrays.asList(new Object[][]{
                {4,6,5},
                {-4,-7,-5},
                {-4,7,1},
                {Integer.MAX_VALUE, 0, 1073741823},
                {Integer.MIN_VALUE, 0, -1073741824},
                {2000000000, 1000000000, 1500000000}
        });
    }

    @Test
    public void testAverage() throws Exception {

        Assert.assertEquals(result, averageNumber.average(argumentA, argumentB));
    }
}