package ua.in.codegym;

import java.util.Comparator;

/**
 * Дано ланки трьох кольорів: білого і 1 м завдовжки, жовтого - 2 м і червоного - 3 м.
 * Скількома способами можна зібрати, з них, ланцюжок довжиною  N.
 * Кількість наявних ланок кожного кольору вважати бескінечною.
 * <p>
 * Created by Alex Korneyko on 11.05.2016.
 */
public class ColorChain {
    public int count(int N) {

        int length = N;
        int wayCount = 0;

        for (int i = 1; i <= 3; i++) {
            if (length <= i) {
                wayCount++;
                length -= i;

            }
        }

        return wayCount;
    }
}
