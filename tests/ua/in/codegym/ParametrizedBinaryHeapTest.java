package ua.in.codegym;

import org.junit.Assert;
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

        binaryHeap = new BinaryHeap(10);
        for (int i = 0; i < binaryHeap.size; i++) {
            binaryHeap.insert(9 - i);
        }

        System.out.println(binaryHeap.heap);
    }

    @Test
    public void testPoll() throws Exception {

    }
}