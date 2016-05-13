package ua.in.codegym;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.geom.Ellipse2D;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Alex Korneyko on 13.05.2016.
 */
@RunWith(value = Parameterized.class)
public class ParametrizedDoublesTest {

    Doubles doubles = new Doubles();
    String argument;
    Double result;

    public ParametrizedDoublesTest(String argument, Double result) {
        this.argument = argument;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters(){
        return Arrays.asList(new Object[][]{
                {"+.3", 0.3d},
                {"-2.e10", -20000000000d},
                {".e2", null},
                {"-.", null}
        });
    }

    @Test
    public void testParse() throws Exception {

        assertEquals(result, doubles.parse(argument));
    }
}