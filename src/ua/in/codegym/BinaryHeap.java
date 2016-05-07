package ua.in.codegym;

import java.util.ArrayList;
import java.util.List;

/**
 * Реалізуйте структуру даних  - Бінарна Купа (Binary Heap).
 * Конструктор проймає один параметр size.
 * Методи insert(int) що працює за O(logN) і poll(),
 * який видаляє і повертає максимальне число з купи і також працює за O(logN).
 * Created by Alex Korneyko on 05.05.2016.
 */
public class BinaryHeap {

    List<Integer> heap = new ArrayList<>();
    int size;

    public BinaryHeap(int size) {
        this.size = size;
    }

    public void insert(int val) {

        if(heap.size() == 0) {
            heap.add(val);
            return;
        }

        int upperPosition = heap.size() - 1;
        int lowerPosition = heap.size() - 1;

        while (true) {

        }
    }

    public int poll() {

        return 0;
    }
}
