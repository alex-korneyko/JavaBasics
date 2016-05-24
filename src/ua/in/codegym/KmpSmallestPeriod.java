package ua.in.codegym;

import java.util.*;
import java.util.Map.Entry;
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

        Map<String, Integer> periods = new HashMap<>();
        char[] charInput = input.toCharArray();

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

        List<String> wrongKeys = new ArrayList<>();

        wrongKeys.addAll(periods.keySet().stream().filter(key -> input.charAt(0) != key.charAt(0)).collect(Collectors.toList()));
        wrongKeys.forEach(periods::remove);

        int maxPeriod = 0;
        int maxRepetitions = 0;

        for (String key: periods.keySet()){
            if(periods.get(key) > maxRepetitions){
                maxRepetitions = periods.get(key);
            }
        }

        final int finalMaxRepetitions = maxRepetitions;
        wrongKeys.addAll(periods.keySet().stream().filter(key -> periods.get(key) != finalMaxRepetitions).collect(Collectors.toList()));
        wrongKeys.forEach(periods::remove);

        for(String key: periods.keySet()){
            if(key.length() > maxPeriod)
                maxPeriod=key.length();
        }

        final int finalMaxPeriod = maxPeriod;
        wrongKeys.addAll(periods.keySet().stream().filter(key -> key.length() != finalMaxPeriod).collect(Collectors.toList()));
        wrongKeys.forEach(periods::remove);


        return (String) periods.keySet().toArray()[0];
    }
}
