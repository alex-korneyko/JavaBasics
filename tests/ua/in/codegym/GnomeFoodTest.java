package ua.in.codegym;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by Alex Korneyko on 02.05.2016.
 */
@RunWith(value = Parameterized.class)
public class GnomeFoodTest {

    GnomeFood gnomeFood = new GnomeFood();
    int[] gnomes;
    int[] portions;
    int[] result;

    public GnomeFoodTest(int[] gnomes, int[] portions, int[] result) {
        this.gnomes = gnomes;
        this.portions = portions;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {new int[]{5, 7, 6, 9, 4}, new int[]{8, 5, 6, 2, 3}, new int[]{4, 2, 1, 0, 3}},
        });
    }

    @Test
    public void testFind() throws Exception {

        Assert.assertArrayEquals(result, gnomeFood.find(gnomes, portions));
    }
}