package ua.in.codegym;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by admin on 05.05.2016.
 */
public class ParametrizedBinaryHeapTest {

    BinaryHeap binaryHeap;

    @Test
    public void testInsert1() throws Exception {

        binaryHeap = new BinaryHeap(10);
        for (int i = 0; i < binaryHeap.size; i++) {
            binaryHeap.insert(9 - i);
        }

        List<Integer> result = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        Assert.assertEquals(result, binaryHeap.heap);
    }

    @Test
    public void testInsert2() throws Exception {

        int[] args = new int[]{7, 9, 1, 8, 2, 0, 3, 6, 4, 5, 10, 20, 11, 19, 14, 14, 16, 13, 7, 18, 17};

        binaryHeap = new BinaryHeap(args.length);
        for (int i = 0; i < binaryHeap.size; i++) {
            binaryHeap.insert(args[i]);
        }

        List<Integer> result = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 7, 8, 9, 10, 11, 13, 14, 14, 16, 17, 18, 19, 20);

        Assert.assertEquals(result, binaryHeap.heap);
    }

    @Test
    public void testPoll() throws Exception {

        List<Integer> args = Arrays.asList(12, 17, 18, 19, 20);
        BinaryHeap bHeap = new BinaryHeap(args.size());
        bHeap.heap.addAll(args);

        Assert.assertEquals(20, bHeap.poll());
        Assert.assertEquals(19, bHeap.poll());
        Assert.assertEquals(18, bHeap.poll());
        Assert.assertEquals(17, bHeap.poll());
        Assert.assertEquals(12, bHeap.poll());

    }
}