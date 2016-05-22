package ua.in.codegym;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Alex Korneyko on 22.05.2016.
 */
@RunWith(value = Parameterized.class)
public class ParametrizedKmpSubMoveTest {

    KmpSubMove kmpSubMove = new KmpSubMove();
    String innerArgument;
    String outerArgument;
    int result;

    public ParametrizedKmpSubMoveTest(String innerArgument, String outerArgument, int result) {
        this.innerArgument = innerArgument;
        this.outerArgument = outerArgument;
        this.result = result;
    }

    @Test (timeout = 1000)
    public void testSubMoveQuantity() throws Exception {

        assertEquals(result, kmpSubMove.subMoveQuantity(innerArgument, outerArgument));
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters(){
        return Arrays.asList(new Object[][]{
                {"a", "a", 0},
                {"abcd", "cdab", 2}
        });
    }
}