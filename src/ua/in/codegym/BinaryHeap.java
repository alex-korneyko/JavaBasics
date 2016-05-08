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

    //Куча
    List<Integer> heap = new ArrayList<>();
    //Размер
    int size;

    public BinaryHeap(int size) {
        this.size = size;
    }

    /**
     * Вставка элемента в кучу в определённое место для получения сразу
     * отсортированной коллекции.
     * Определение места вставки происходит по алгоритму деления пополам
     * диапазона, и определения в какую половину попадает элемент.
     * Так происходит пока не будет точно определено место вставки.
     * Сложность алгоритма O(log N)
     *
     * @param val значение для вставки
     */
    public void insert(int val) {

        if (heap.size() == 0) {
            //Если в куче ничего нет
            heap.add(val);
            return;
        } else if (val >= heap.get(heap.size() - 1)) {
            //Если значение больше или равно последнему элементу
            heap.add(val);
            return;
        } else if (val <= heap.get(0)) {
            //Если значение меньше или равно первому элементу
            heap.add(0, val);
            return;
        }

        //Сразу установка на середину всей кучи. Вся куча сначала является начальным диапазоном
        int upperPosition = (heap.size() - 1) / 2;
        //Нижний край начального диапазона
        int lowerPosition = 0;

        while (true) {
            //Если диапазон сузился до нуля, и входное значение попадает между крайними значениями диапазона,
            //то вставка между этими значениями
            if (upperPosition - lowerPosition == 1 && val <= heap.get(upperPosition) && val > heap.get(lowerPosition)) {
                heap.add(upperPosition, val);
                break;
            }

            //Если диапазон "схлопнулся", то вставка значения после диапазона
            if (upperPosition == lowerPosition) {
                heap.add(upperPosition + 1, val);
                break;
            }

            //Если входное значение больше чем значение в середине текущего диапазона,
            //то новый диапазон будет со средины текущего диапазона и до середины
            //между началом нового диапазона и концом кучи
            if (val > heap.get(upperPosition)) {
                lowerPosition = upperPosition;
                upperPosition = upperPosition + (heap.size() - 1 - upperPosition) / 2;
                continue;
            }

            //Если входное значение больше нижнего края диапазона и диапазон всё ещё больше нуля,
            // то поддтянуть верхнюю границу диапазона до его середины
            if (val > heap.get(lowerPosition)) {
                upperPosition = upperPosition - (upperPosition - lowerPosition) / 2;
                continue;
            }

            //Если входное значение меньше верхнего края диапазона и диапазон всё ещё больше нуля,
            //то подтянуть нижнюю границу диапазона до его середины
            if (val < heap.get(upperPosition)) {
                lowerPosition = lowerPosition + (upperPosition - lowerPosition) / 2;
            }
        }
    }

    /**
     * Куча уже отсортирована, возврат и удаление самого последнего значения кучи.
     * Сложность алгоритма O(1)
     *
     * @return максимальное значение из кучи
     */
    public int poll() {

        return heap.remove(heap.size() - 1);
    }
}
