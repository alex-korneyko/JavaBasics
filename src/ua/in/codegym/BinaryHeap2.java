package ua.in.codegym;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Korneyko on 17.06.2016.
 */
public class BinaryHeap2 {

    private List<Integer> heap;
    private int heapSize = 0;

    public BinaryHeap2(int size) {
        heap = new ArrayList<>(size);
    }

    public void insert(int val) {
        heap.add(val);
        heapSize++;

        int lastAddedValueIndex = heapSize - 1;           //Индекс последнего элемента в куче
        int parentIndex = (lastAddedValueIndex - 1) / 2;  //Индекс родитедя

        while (lastAddedValueIndex > 0 && heap.get(parentIndex) < heap.get(lastAddedValueIndex)) {
            int temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(lastAddedValueIndex));
            heap.set(lastAddedValueIndex, temp);
            lastAddedValueIndex = parentIndex;
            parentIndex = (lastAddedValueIndex - 1) / 2;
        }
        if (heap.size() > heapSize) {
            heap.remove(heap.size() - 1);
            heapSize--;
        }
    }

    public int poll() {

        int result = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapSize--;

        heapify(0);

        return result;
    }

    private void heapify(int fromIndex) {


        while (true) {
            int leftChildIndex = fromIndex * 2 + 1;
            int rightChildIndex = leftChildIndex + 1;
            int largestIndex = fromIndex;

            if (leftChildIndex<heap.size() && heap.get(largestIndex) < heap.get(leftChildIndex))
                largestIndex = leftChildIndex;

            if(rightChildIndex<heap.size() && heap.get(largestIndex) < heap.get(rightChildIndex))
                largestIndex = rightChildIndex;

            if(largestIndex == fromIndex) break;

            int temp = heap.get(fromIndex);
            heap.set(fromIndex, heap.get(largestIndex));
            heap.set(largestIndex, temp);
            fromIndex = largestIndex;
        }
    }

    public List<Integer> getValues() {
        return heap;
    }
}
