package ua.in.codegym;

import java.util.HashMap;
import java.util.Map;

/**
 * Знайти і повернути перший унікальний символ в рядку.
 * Якщо всі символи повторюються, повернути null
 * <p>
 * Created by Alex Korneyko on 08.05.2016.
 */
public class FirstUniqueCharacter {

    public Character find(String s) {

        Character result;

        Map<Character, Integer> charMap = new HashMap<>();

        for (char symbol : s.toCharArray()) {
            if (charMap.containsKey(symbol)) {
                charMap.put(symbol, charMap.get(symbol) + 1);
            } else {
                charMap.put(symbol, 1);
            }
        }

        for (Map.Entry<Character, Integer> pair : charMap.entrySet()) {
            if(pair.getValue() == 1){
                return pair.getKey();
            }
        }
        return null;
    }
}
