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

        if (heap.size() == 0) {
            heap.add(val);
            return;
        } else if (val > heap.get(heap.size() - 1)) {
            heap.add(val);
            return;
        } else if (val <= heap.get(0)) {
            heap.add(0, val);
            return;
        } else if (heap.size() == 2 && val > heap.get(0) && val < heap.get(1)) {
            heap.add(1, val);
            return;
        }

        int upperPosition = (heap.size() - 1) / 2;
        int lowerPosition = 0;

        while (true) {
            if (upperPosition - lowerPosition <= 1 && val <= heap.get(upperPosition) && val > heap.get(lowerPosition)) {
                heap.add(upperPosition, val);
                break;
            }

            if (upperPosition == lowerPosition && upperPosition < heap.size() - 1) {
                heap.add(upperPosition + 1, val);
                break;
            }

            if (val > heap.get(upperPosition)) {
                lowerPosition = upperPosition;
                upperPosition = upperPosition + (heap.size() - 1 - upperPosition) / 2;
                continue;
            } else if (val > heap.get(lowerPosition)) {
                upperPosition = upperPosition - (upperPosition - lowerPosition) / 2;
                continue;
            }

            if (val < heap.get(upperPosition)) {
                lowerPosition = lowerPosition + (upperPosition - lowerPosition) / 2;
            }
        }
    }

    public int poll() {

        return heap.remove(heap.size()-1);
    }
}
