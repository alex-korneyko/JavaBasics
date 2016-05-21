package ua.in.codegym;


/**
 * Дано ланки трьох кольорів: білого і 1 м завдовжки, жовтого - 2 м і червоного - 3 м.
 * Скількома способами можна зібрати, з них, ланцюжок довжиною  N.
 * Кількість наявних ланок кожного кольору вважати бескінечною.
 * <p>
 * Created by Alex Korneyko on 11.05.2016.
 */
public class ColorChain {
    public int count(int N) {

        if (N <= 2) return N;
        if (N == 3) return 4;
        return count(N - 1) + count(N - 2) + count(N - 3);
    }
}
