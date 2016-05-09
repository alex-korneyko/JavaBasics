package ua.in.codegym;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;


/**
 * Created by Alex Korneyko on 09.05.2016.
 */
@RunWith(value = Parameterized.class)
public class BitsPalindromeTest {

    BitsPalindrome bitsPalindrome = new BitsPalindrome();
    int argument;
    boolean result;

    public BitsPalindromeTest(int argument, boolean result) {
        this.argument = argument;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {4, false},
                {1073741825, false},
                {-1, true},
                {-2147483647,true},
                {-2080374783, false}
        });
    }

    @Test
    public void testIsPalindrome() throws Exception {

        Assert.assertEquals(result, bitsPalindrome.isPalindrome(argument));
    }
}