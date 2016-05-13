package ua.in.codegym;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Alex Korneyko on 13.05.2016.
 */
@RunWith(value = Parameterized.class)
public class WordNumberTest {

    WordNumber wordNumber = new WordNumber();
    String argument;
    int result;

    public WordNumberTest(String argument, int result) {
        this.argument = argument;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters(){
        return Arrays.asList(new Object[][]{
                {"", 0},
                {"... ... !", 0},
                {"aS sg.rf!rs_sefse", 5}
        });
    }

    @Test
    public void testCount() throws Exception {

        assertEquals(result,wordNumber.count(argument));
    }
}