package ua.in.codegym;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 27.04.2016.
 */
public class ReverseBits {

    public int reverse(int input) {

        List<Integer> binary = new ArrayList<>();
        int result = 0;
        boolean negative = false;

        if (input < 0) {
            negative = true;
            input = input & Integer.MAX_VALUE;
        }

        while (binary.size() < 31) {
            binary.add(input % 2);
            input /= 2;
        }

        binary.add(negative ? 1 : 0);

        for (Integer bit : binary) {
            result = result * 2 + bit;
        }

        return result;

    }

}
