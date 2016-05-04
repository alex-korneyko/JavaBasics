package ua.in.codegym;

import java.util.Stack;

/**
 * Created by Alex Korneyko on 03.05.2016.
 */
public class ReversePolishNotation {

    public int evaluate(String expression) {

        String[] expressionArray = expression.split(" ");
        Stack<Integer> stack = new Stack<>();

        for (String expressionElement : expressionArray) {
            int operandA;
            int operandB;

            switch (expressionElement) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    if (expressionElement.length() == 1) {
                        operandB = stack.pop();
                        operandA = stack.pop();
                        stack.push(operandA - operandB);
                    } else {
                        stack.push(parse(expressionElement));
                    }
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    operandB = stack.pop();
                    operandA = stack.pop();
                    stack.push(operandA / operandB);
                    break;
                default:
                    stack.push(parse(expressionElement));
                    break;
            }
        }
        return stack.pop();
    }

    private static int parse(String expressionElement) {
        int negative = 1;
        int intTemp = 0;
        for (int i = 0; i < expressionElement.length(); i++) {
            if (expressionElement.toCharArray()[i] != '-') {
                intTemp = intTemp * 10 + (expressionElement.toCharArray()[i] - '0');
            } else {
                negative = -1;
            }
        }
        return intTemp * negative;
    }
}
