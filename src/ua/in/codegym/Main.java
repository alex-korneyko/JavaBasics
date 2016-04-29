package ua.in.codegym;

/**
 * Created by admin on 27.04.2016.
 */
public class Main {

    public static void main(String[] args) {

        ReverseBits reverseBits = new ReverseBits();
        CountBits countBits = new CountBits();
        AddBinary addBinary = new AddBinary();

        //System.out.println(reverseBits.reverse(2));
        //System.out.println(countBits.count(-1));
        System.out.println(addBinary.add("101", "100"));
    }
}
