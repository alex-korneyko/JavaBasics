package ua.in.codegym;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 28.04.2016.
 */
public class AddNumberBase36 {

    public static String add(String a, String b) {

        final Map<Character, Integer> system36 = new HashMap<>();

        for (int i = 0; i <= 9; i++) {
            system36.put((char) (i + 48), i);
        }
        for (int i = 10; i <= 35; i++) {
            system36.put((char) (i + 55), i);
            system36.put((char) (i + 87), i);
        }

        char[] result = new char[Math.max(a.length(), b.length()) + 1];
        Arrays.fill(result, '0');

        char[] operandA = copyFromEnd(a.toCharArray(), result.length - 1);

        char[] operandB = copyFromEnd(b.toCharArray(), result.length - 1);


        for (int i = result.length - 1; i > 0; i--) {

            int simpleSum = system36.get(result[i]) + system36.get(operandA[i - 1])
                    + system36.get(operandB[i - 1]);

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

    private static char[] copyFromEnd(char[] source, int newSize) {
        if (source.length > newSize) {
            return null;
        }

        char[] result = new char[newSize];
        Arrays.fill(result, '0');

        System.arraycopy(source, 0, result, result.length - source.length, source.length);

        return result;
    }

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
