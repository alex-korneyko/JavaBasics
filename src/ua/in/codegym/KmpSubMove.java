package ua.in.codegym;


/**
 * Created by Alex Korneyko on 22.05.2016.
 */
public class KmpSubMove {

    public int subMoveQuantity(String inputStr, String resultStr) {

        for (int i = 0; i <= inputStr.length() - 1; i++) {
            if (inputStr.equals(resultStr)) return i;

            inputStr = moveOneStep(inputStr);
        }

        return -1;
    }

    String moveOneStep(String line) {
        StringBuilder innerString = new StringBuilder(line);

        innerString.insert(0, innerString.substring(innerString.length()-1));
        innerString.deleteCharAt(innerString.length()-1);

        return innerString.toString();
    }
}
