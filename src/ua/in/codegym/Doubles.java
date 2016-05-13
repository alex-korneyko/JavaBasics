package ua.in.codegym;

/**
 * Created by Alex Korneyko on 13.05.2016.
 */
public class Doubles {

    public Double parse(String s) {

        char[] symbolSet = s.toCharArray();
        String mainNumber = "";
        String exponent = "";

        boolean mainNumberComplete = false;

        double mainNumberDouble;
        int exponentInteger;

        for (char symbol : symbolSet) {
            if (symbol == '-') {
                if (mainNumberComplete) {
                    exponent += '-';
                } else {
                    mainNumber += '-';
                }
            }

            if (symbol == '+') continue;

            if (symbol == 'e' || symbol == 'E') mainNumberComplete = true;

            if ((symbol >= '0' && symbol <= '9') || symbol == '.') {
                if (mainNumberComplete) {
                    exponent += symbol;
                } else {
                    mainNumber += symbol;
                }
            }
        }

        if (mainNumber.substring(0, 1).equals(".") && !exponent.equals("")) return null;

        mainNumberDouble = Double.parseDouble(mainNumber.equals("") ? "0" : mainNumber);
        exponentInteger = Integer.parseInt(exponent.equals("") ? "0" : exponent);

        return mainNumberDouble * Math.pow(10, exponentInteger);
    }
}
