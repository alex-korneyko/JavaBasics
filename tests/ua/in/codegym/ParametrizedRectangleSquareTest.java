package ua.in.codegym;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Alex Korneyko on 03.05.2016.
 */
@RunWith(value = Parameterized.class)
public class ParametrizedRectangleSquareTest {

    RectangleSquare rectangleSquare = new RectangleSquare();
    int[] x;
    int[] h;
    int[] w;
    int result;

    public ParametrizedRectangleSquareTest(int[] x, int[] h, int[] w, int result) {
        this.x = x;
        this.h = h;
        this.w = w;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object> getParameters() {
        return Arrays.asList(new Object[][]{
                {new int[]{5}, new int[]{10}, new int[]{20}, 200},
                {new int[]{0, 0}, new int[]{10, 20}, new int[]{20, 10}, 300},
                {new int[]{0, 0, 30}, new int[]{10, 20, 25}, new int[]{20, 10, 10}, 550}
        });
    }

    @Test(timeout = 1000)
    public void testMeasure() throws Exception {
        Assert.assertEquals(result, rectangleSquare.measure(x, h, w));
    }
}