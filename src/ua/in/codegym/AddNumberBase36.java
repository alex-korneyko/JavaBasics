package ua.in.codegym;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 28.04.2016.
 */
public class AddNumberBase36 {

    public String add(String a, String b) {

        //Карта соответствия символов цифрам
        final Map<Character, Integer> system36 = new HashMap<>();

        //Цифры
        for (int i = 0; i <= 9; i++) {
            system36.put((char) (i + 48), i);
        }
        //Буквы, маленькие и большие
        for (int i = 10; i <= 35; i++) {
            system36.put((char) (i + 55), i);
            system36.put((char) (i + 87), i);
        }

        //Массив результата (размер - больший аргумент + 1). Заполнение его нулями
        char[] result = new char[Math.max(a.length(), b.length()) + 1];
        Arrays.fill(result, '0');

        //Массив - операнд 'a', набор в обратном порядке
        char[] operandA = copyFromEnd(a.toCharArray(), result.length - 1);
        //Массив - операнд 'b', набор в обратном порядке
        char[] operandB = copyFromEnd(b.toCharArray(), result.length - 1);

        //Расчёт
        for (int i = result.length - 1; i > 0; i--) {

            //Сложение посимвольно аргументы и результат(длинна массива result на разряд больше)
            int simpleSum = system36.get(result[i]) + system36.get(operandA[i - 1])
                    + system36.get(operandB[i - 1]);

            //Если посимвольный результат больше чем 36, то в следующий резряд результата
            //записать 1, а в текущий остаток
            if (simpleSum <= system36.get('z')) {
                result[i] = Character.toLowerCase(getKey(system36, simpleSum));
            } else {
                result[i - 1] = getKey(system36, 1);
                result[i] = getKey(system36, simpleSum - system36.get('z') - system36.get('1'));
                result[i] = Character.toLowerCase(result[i]);
            }
        }

        StringBuilder stringResult = new StringBuilder();
        stringResult.append(result);

        if (stringResult.charAt(0) == '0') {
            stringResult.deleteCharAt(0);
        }
        return stringResult.toString();
    }

    /**
     * Копирование массива в обратном порядке с заданием нового размера
     * @param source Исходный массив
     * @param newSize Новый размер массива. Если больше чем исходный массив,
     *                то разультирующий будет дополнен нулями
     * @return Новый массив
     */
    private static char[] copyFromEnd(char[] source, int newSize) {
        if (source.length > newSize) {
            return null;
        }

        char[] result = new char[newSize];
        Arrays.fill(result, '0');

        System.arraycopy(source, 0, result, result.length - source.length, source.length);

        return result;
    }

    /**
     * Поиск в map-колеекции ключа по значению
     * @param map коллекция
     * @param value значение, ключ которого нужно найти
     * @return ключ
     */
    private static char getKey(Map map, int value) {

        for (Object o : map.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            if ((int) pair.getValue() == value) {
                return (char) pair.getKey();
            }
        }
        return 'E';
    }
}
