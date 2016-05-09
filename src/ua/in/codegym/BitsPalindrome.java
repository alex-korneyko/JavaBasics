package ua.in.codegym;

/**
 * Перевірити чи являється бінарне представлення числа поліндромом.
 * <p>
 * Created by Alex Korneyko on 09.05.2016.
 */
public class BitsPalindrome {

    public boolean isPalindrome(int input) {
        StringBuilder binInput = new StringBuilder();
        boolean negative = false;

        //Если входное отрицательное
        if (input < 0) {
            negative = true;
            input &= Integer.MAX_VALUE; //Обнуление бита отрицательности
        }

        //Конвертирование в двоичную строку
        while (binInput.length() < 31) {
            binInput.append(input % 2);
            input /= 2;
        }
        //Добавление бита отрицательности
        binInput.append(negative ? '1' : '0');


        String reversed = (new StringBuilder(binInput)).reverse().toString();
        return binInput.toString().equals(reversed);
    }
}
