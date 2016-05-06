package ua.in.codegym;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 05.05.2016.
 */
public class BinaryHeap {

    List<Integer> heap = new ArrayList<>();
    int size;

    public BinaryHeap(int size) {
        this.size = size;
    }

    public void insert(int val) {
        if (heap.size() < size) {
            heap.add(val);
        }
    }

    public int poll() {

        int max = heap.get(0);
        for (int i = 1; i < heap.size(); i++) {
            if (max < heap.get(i)) {
                max = heap.get(i);
                heap.remove(i);
            }
        }
        return max;
    }
}
