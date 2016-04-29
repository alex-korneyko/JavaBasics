package ua.in.codegym;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 28.04.2016.
 */
public class AddBinary {

    public String add(String a, String b) {

        List<Integer> argumentA = new ArrayList<>();
        List<Integer> argumentB = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(0);

        for (int i = a.length() - 1; i >= 0; i--) {
            argumentA.add(a.charAt(i) - '0');
        }

        for (int i = b.length() - 1; i >= 0; i--) {
            argumentB.add(b.charAt(i) - '0');
        }

        //Добавление нулей в старшие разряды более короткого аргумента,
        //чтобы оба аргумента стали одинаковой длинны. И сложение.
        for (int i = 0; i < Math.max(argumentA.size(), argumentB.size()); i++) {
            //Если первый аогумент короче второго
            if (argumentA.size() < argumentB.size()) {
                argumentA.add(0);
            }

            //Если второй короче первого
            if (argumentB.size() < argumentA.size()) {
                argumentA.add(0);
            }

            //Если хотя бы два бита в текущих позициях аргументов и результата еденицы,
            //то запись еденицы в результат в следующую позицию
            result.add((argumentA.get(i) + argumentB.get(i) + result.get(i)) / 2);

            //Сложение по XOR битов в одинаковых позициях в обеих аргументах и результате (см. далее)
            result.set(i, (argumentA.get(i) ^ argumentB.get(i) ^ result.get(i)));

        }

        //Если в самой старшей позиции получился ноль, то удалить его
        if (result.get(result.size() - 1) == 0) {
            result.remove(result.size() - 1);
        }

        //Получение строкового результата
        StringBuilder stringResult = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i--) {
            stringResult.append(result.get(i));
        }

        return stringResult.toString();
    }
}
