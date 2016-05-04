package ua.in.codegym;

/**
 * Created by Alex Korneyko on 04.05.2016.
 */
public class LongestStabilityPeriod {

    public int count(int[] gdp) {

        int result = 0;

        if (gdp.length <= 1) return gdp.length;
        int startPeriodIndex = 0;


        for (int i = 1; i < gdp.length; i++) {
            if (arrayDeviation(gdp, startPeriodIndex, i) > 1) {
                result = Math.max(result, i - startPeriodIndex);
                i = ++startPeriodIndex;
            }
        }

        return Math.max(result, gdp.length - 1 - startPeriodIndex);
    }

    /**
     * Определение разницы между минимальным и максимальным значениями в массиве
     * Ширина диапазона значений массива
     *
     * @param array      массив
     * @param startIndex начальный индекс
     * @param endIndex   конечный индекс
     * @return ширина диапазона значений массива
     */
    private static int arrayDeviation(int[] array, int startIndex, int endIndex) {

        if (array.length == 1 || startIndex == endIndex
                || startIndex > endIndex || startIndex > array.length - 1
                || endIndex > array.length - 1) {
            return 0;
        }

        int minValue = array[startIndex];
        int maxValue = array[startIndex];

        for (int i = startIndex; i <= endIndex; i++) {
            if (minValue > array[i])
                minValue = array[i];

            if (maxValue < array[i])
                maxValue = array[i];
        }

        return maxValue - minValue;
    }
}
