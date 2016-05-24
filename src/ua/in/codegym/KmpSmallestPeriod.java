package ua.in.codegym;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A character string is said to have period k if it can be formed by concatenating one or more repetitions of another string of length k.
 * For example, the string "abcabcabcabc" has period 3, since it is formed by 4 repetitions of the string "abc".
 * It also has periods 6 (two repetitions of "abcabc") and 12 (one repetition of "abcabcabcabc").
 * Write a program to read a character string and determine its smallest period
 * Return (String) substring;
 * http://codegym.in.ua/problem/56709ce5159d54bb38ae521e
 * <p>
 * Created by Alex Korneyko on 24.05.2016.
 */
public class KmpSmallestPeriod {

    public String findSmalletstPeriod(String input) {

        //Мапа, где ключи - все возможные сочетания символов, значения - сколько раз повторяются эти сочетания
        Map<String, Integer> periods = new HashMap<>();
        //Массив символов из входной строки
        char[] charInput = input.toCharArray();
        //Набор символов, присутствующих в входной строке
        Set<Character> characterSet = new HashSet<>();
        //Коллекция ключей мапы для сочетаний, которые будут отфильтровываться по условиям
        List<String> wrongKeys = new ArrayList<>();

        int maxPeriod = 0;
        int maxRepetitions = 0;

        //Получение набора символов
        for (char symbol : charInput) {
            characterSet.add(symbol);
        }

        //Заполнение мапы всеми возможными сочетаниями и их количеством, если сочетания повторяются
        for (int i = 0; i < charInput.length; i++) {
            for (int j = i + 1; j <= charInput.length; j++) {
                String subString = input.substring(i, j);
                if (periods.containsKey(subString)) {
                    periods.put(subString, periods.get(subString) + 1);
                } else {
                    periods.put(subString, 1);
                }
            }
        }

        //Поиск и удаление сочетаний, в которых отсутствуют все возможные символы из входной строки
        //или у сочетания первая буква не совпадает с первой буквой входной строки
        periods.keySet().stream().filter(key -> !containsAllFromCharSet(key, characterSet)
                || key.charAt(0) != input.charAt(0)).filter(key -> !wrongKeys.contains(key)).forEach(wrongKeys::add);
        wrongKeys.forEach(periods::remove);

        //Поск самых частоповторяемых сочетаний, и удаление всех остальных
        //Самое частоповторяемое сочетание по логике должно быть самым коротким.
        //Сначала поск максимума повторений среди оставшихся сочетаний
        for (String key : periods.keySet()) {
            if (periods.get(key) > maxRepetitions)
                maxRepetitions = periods.get(key);
        }

        //Поиск и удаление всех сочетаний не максимального числа повторений
        final int finalMaxRepetitions = maxRepetitions;
        wrongKeys.addAll(periods.keySet().stream().filter(key -> periods.get(key)!= finalMaxRepetitions).collect(Collectors.toList()));
        wrongKeys.forEach(periods::remove);

        return (String) periods.keySet().toArray()[0];
    }

    boolean containsAllFromCharSet(String testingString, Set<Character> charSet) {

        for (Character symbol : charSet) {
            if (!testingString.contains(symbol.toString()))
                return false;
        }

        return true;
    }
}
