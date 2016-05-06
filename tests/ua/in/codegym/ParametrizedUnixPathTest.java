package ua.in.codegym;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Alex Korneyko on 04.05.2016.
 */
@RunWith(value = Parameterized.class)
public class ParametrizedUnixPathTest {

    UnixPath unixPath = new UnixPath();
    String fullPath;
    String simplePath;

    public ParametrizedUnixPathTest(String fullPath, String simplePath) {
        this.fullPath = fullPath;
        this.simplePath = simplePath;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {"/home/../var/./lib//file.txt", "/var/lib/file.txt"},
                {"//","/"}
        });
    }

    @Test
    public void testSimplify() throws Exception {
        Assert.assertEquals(simplePath, unixPath.simplify(fullPath));
    }
}