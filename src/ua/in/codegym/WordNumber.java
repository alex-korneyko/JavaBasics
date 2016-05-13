package ua.in.codegym;

/**
 * Дано рядок. Порахувати кількість слів.
 * Словом вважається послідовність символів англійського алфавіту [a-zA-Z].
 * <p>
 * Алгоритм повинен працювати за O(N) часу, тому RegExp використовувати не можна.
 * Created by Alex Korneyko on 13.05.2016.
 */
public class WordNumber {
    public int count(String input) {

        char[] symbolSet = input.toCharArray();
        int result = 0;

        for(int i=1; i<symbolSet.length; i++){
            if((symbolSet[i-1] >= 'A' && symbolSet[i-1] <= 'Z') || (symbolSet[i-1] >= 'a' && symbolSet[i-1] <= 'z')){
                if((symbolSet[i]<'A' || symbolSet[i]>'Z') && (symbolSet[i]<'a' || symbolSet[i]>'z')) {
                    result++;
                }
            }
            if (((symbolSet[i] >= 'A' && symbolSet[i] <= 'Z') || (symbolSet[i] >= 'a' && symbolSet[i] <= 'z'))
                    && i== (symbolSet.length-1)){
                result++;
            }
        }
        return result;
    }
}
