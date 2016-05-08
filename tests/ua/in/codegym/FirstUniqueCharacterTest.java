package ua.in.codegym;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alex Korneyko on 08.05.2016.
 */
public class FirstUniqueCharacterTest {

    FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();

    @Test
    public void testFind() throws Exception {

        String arg = "saabbccddeeffgghh";

        Assert.assertEquals((Character) 's', firstUniqueCharacter.find(arg));

    }

    @Test
    public void testFind2() throws Exception {

        String arg = "ssaabbccddeeffgghh";

        Assert.assertEquals(null, firstUniqueCharacter.find(arg));

    }
}