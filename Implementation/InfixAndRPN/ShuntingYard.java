package Implementation.InfixAndRPN;

import java.util.*;

/// Infix to Revered Polish Notation
/// Инфиксни към Постфиксни (Обратен Полски Запис)
public class ShuntingYard {
    public static String convertToRPN(String infixExpression) {
        // Initialize operators precedence
        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);

        Stack<Character> operatorStack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < infixExpression.length(); i++) {
            char token = infixExpression.charAt(i);

            // If the token is a digit, add it to the output
            if (Character.isLetterOrDigit(token)) {
                output.append(token).append(' ');
            }
            // If the token is '(', push it to the stack
            else if (token == '(') {
                operatorStack.push(token);
            }
            // If the token is ')', pop until '(' is found
            else if (token == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    output.append(operatorStack.pop()).append(' ');
                }
                operatorStack.pop(); // Pop the '('
            }
            // If the token is an operator
            else if (precedence.containsKey(token)) {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(' &&
                        precedence.get(operatorStack.peek()) >= precedence.get(token)) {
                    output.append(operatorStack.pop()).append(' ');
                }
                operatorStack.push(token);
            }
        }

        // Pop remaining operators
        while (!operatorStack.isEmpty()) {
            output.append(operatorStack.pop()).append(' ');
        }

        return output.toString().trim();
    }
}
