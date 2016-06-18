package ua.in.codegym;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Alex Korneyko on 18.06.2016.
 */
public class BinaryHeap2Test {

    @Test(timeout = 1000)
    public void testInsert() throws Exception {

        List<Integer> args = Arrays.asList(18, 17, 19, 20, 15, 16, 21);
        BinaryHeap2 binaryHeap2 = new BinaryHeap2(args.size());

        for (int i = 0; i < args.size(); i++) {
            binaryHeap2.insert(args.get(i));
        }

        Assert.assertEquals(Arrays.asList(21, 19, 20, 17, 15, 16, 18), binaryHeap2.getValues());
    }

    @Test (timeout = 1000)
    public void testPoll() throws Exception {
        List<Integer> args = Arrays.asList(18, 17, 19, 20, 15, 16, 21);
        BinaryHeap2 binaryHeap2 = new BinaryHeap2(args.size());

        for (int i = 0; i < args.size(); i++) {
            binaryHeap2.insert(args.get(i));
        }

        Assert.assertEquals(21, binaryHeap2.poll());
        Assert.assertEquals(20, binaryHeap2.poll());
        Assert.assertEquals(19, binaryHeap2.poll());
        Assert.assertEquals(18, binaryHeap2.poll());
        Assert.assertEquals(17, binaryHeap2.poll());
        Assert.assertEquals(16, binaryHeap2.poll());
        Assert.assertEquals(15, binaryHeap2.poll());
    }
}