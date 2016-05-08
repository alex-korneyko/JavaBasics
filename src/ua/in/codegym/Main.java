package ua.in.codegym;

/**
 * Created by admin on 27.04.2016.
 */
public class Main {

    public static void main(String[] args) {

        int[] array = new int[]{7, 9, 1, 8, 2, 0, 3, 6, 4, 5, 10, 20, 11, 19, 14, 14, 16, 13, 7, 18, 17};

        BinaryHeap binaryHeap = new BinaryHeap(array.length);

        for (int i = 0; i < array.length; i++) {
            binaryHeap.insert(array[i]);
        }

        System.out.println(binaryHeap.heap);

        for (int i = 0; i < array.length; i++) {
            System.out.print(binaryHeap.poll() + " ");
        }
    }
}
