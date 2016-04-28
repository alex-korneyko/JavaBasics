package ua.in.codegym;

/**
 * Created by admin on 28.04.2016.
 */
public class CountBits {

    public int count(int num) {

        int result = 0;

        //Если число отрицательное, довление бита к результату
        if (num < 0) {
            result = 1;
        }

        //Удаление бита отрицательности
        num = num & Integer.MAX_VALUE;

        //Подсчёт битов
        for (int i = 0; i <31; i++) {
            result = result + (num % 2);
            num /= 2;
        }

        return result;
    }
}
