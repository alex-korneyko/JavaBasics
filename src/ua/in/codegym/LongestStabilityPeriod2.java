package ua.in.codegym;

import java.util.ArrayList;
import java.util.List;

/**
 * Дано масив чисел в якому знаходяться значення ВВП за кожен місяць в мільярдах доларів США.
 * Необхідно знайти найдовший період стабільності.
 * Період стабільності - період часу де всі значення ВВП попарно відрізняються один від одного максимум на 1.
 * Повернути кількість місяців.
 * http://codegym.in.ua/problem/569a84c7159d54bb38ae548d
 * Created by Alex Korneyko on 05.05.2016.
 */
public class LongestStabilityPeriod2 {

    public int count(int[] gdp) {

        //Максимальный разброс ВВП для определения периода стабильности
        final int DEVIATION = 1;

        //Коллекция периодов. Предполагается, что может отслеживаться срезу несколько периодов одновременно
        List<Period> periods = new ArrayList<>();

        //Перебор всех месяцев в массиве
        for (int month : gdp) {
            //Проход по коллекции периодов в обратном направлении
            // с проверкой: удовлетворяет ли текущий месяц условиям конкретного периода.
            // Добавление периодов в конце главного цикла.
            for (int j = periods.size() - 1; j >= 0; j--) {
                if (!periods.get(j).valueMatch(month)) {        //Если удовлетворяет, то подходящий период увеличивается, и сл. итерация
                    for (int k = j; k > 0; k--) {               //Если нет, то проход по оставшимся периодам в коллекции тоже в обр. порядке
                        periods.get(k - 1).periodFinished = true;   //Пометка всех оставшихся периодов как "завершённые"
                        //Поиск среди оставшихся "завершённых" периодов самого большого и удаление меньших
                        if (periods.get(k).compareTo(periods.get(k - 1)) == 1) {
                            periods.remove(k - 1);
                        } else {
                            periods.remove(k);
                        }
                        k--;                                    //При каждом удалении периода, уменьшение счётчика
                    }
                    break;
                }
            }

            //Добавление нового периода. Предположение, что каждый новый месяц может быть началом нового периода
            periods.add(new Period(DEVIATION, month));
        }

        int maxCount = periods.get(0).periodCount;
        for (int i = 1; i < periods.size() - 1; i++) {
            if (maxCount < periods.get(i).periodCount) {
                maxCount = periods.get(i).periodCount;
            }
        }

        return maxCount;
    }

    /**
     * Класс, определяющий период, значения в котором находятся
     * в диапазоне, не превышающем deviationю
     */
    class Period implements Comparable {

        int deviation;                                  //Максимальный разброс значений для периода
        int upperLimit;                                 //Верхнее предельное значение для периода
        int lowerLimit;                                 //Нижнее предельное значение для пертиода
        int periodCount = 1;                            //Продолжительность периода(минимальный - 1 мес.)
        boolean periodFinished;                         //Флаг, период закончен

        public Period(int deviation, int upperLimit) {
            this.deviation = deviation;
            this.upperLimit = upperLimit;               //Создание объекта сразу с указанием однго предела
            periodFinished = false;
            lowerLimit = -1;
        }

        /**
         * Проверка, соответствует ли входное значение условиям периода.
         * Если да, то увиличить продолжительность текущего периода, и вернуть true
         * Если нет, то период пометить как завершённый, и вернуть false
         *
         * @param value значение ВВП
         * @return true - удалось продлить период, false - период не продлён или период завершён.
         */
        boolean valueMatch(int value) {

            if (this.periodFinished) return false;      //Период уже завершён

            if (lowerLimit == -1) {                     //Если пока нет второго предела
                if (value == upperLimit) {              //Если значение равно первому пределу
                    periodCount++;                      //Увеличить продолжительность перода
                    return true;                        //Вернуть true
                } else if (Math.abs(upperLimit - value) == deviation) {     //Если значение в пределах deviation
                    this.addAnotherLimit(value);        //Добавить второй предел
                    periodCount++;                      //Увеличить продолжительность перода
                    return true;                        //Вернуть true
                } else {                                //Если значение выходит за deviation
                    periodFinished = true;              //Пометить предел как завершённый
                    return false;                       //Вернуть false
                }
            }

            //Если есть второй предел, и значение входит в пределы
            if (value >= lowerLimit && value <= upperLimit) {
                periodCount++;                          //Увеличить продолжительность перода
                return true;                            //Вернуть true
            }

            periodFinished = true;                      //Значение за пределами, период пометить завершённым
            return false;                               //Вернуть false
        }

        /**
         * Добавление второго предела для получения "рабочего" диапазона значений
         * для периода (зависит от deviation)
         *
         * @param value второй параметр диапазона
         */
        void addAnotherLimit(int value) {
            if (Math.abs(upperLimit - value) == deviation) {
                if (upperLimit > value) {
                    lowerLimit = value;
                } else {
                    lowerLimit = upperLimit;
                    upperLimit = value;
                }
            }
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Period)) {
                return -1;
            }

            if (this.periodCount > ((Period) o).periodCount) {
                return 1;
            } else if (this.periodCount < ((Period) o).periodCount) {
                return -1;
            }
            return 0;
        }
    }
}
