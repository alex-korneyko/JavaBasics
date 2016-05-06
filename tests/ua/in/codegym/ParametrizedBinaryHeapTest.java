package ua.in.codegym;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 * Created by admin on 05.05.2016.
 */
@RunWith(value = Parameterized.class)
public class ParametrizedBinaryHeapTest {

    BinaryHeap binaryHeap;


    public ParametrizedBinaryHeapTest(int size) {
        this.binaryHeap = new BinaryHeap(size);
    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testPoll() throws Exception {

    }
}