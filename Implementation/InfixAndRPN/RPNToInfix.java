package Implementation.InfixAndRPN;

import java.util.*;

public class RPNToInfix {

    public static String convertToInfix(String rpnExpression) {
        Stack<String> stack = new Stack<>();
        String[] tokens = rpnExpression.split(" ");

        for (String token : tokens) {
            // If the token is an operator, pop two elements from the stack and create an infix expression
            if (isOperator(token)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String infixExpression = "(" + operand1 + " " + token + " " + operand2 + ")";
                stack.push(infixExpression);
            }
            // If the token is an operand, push it to the stack
            else {
                stack.push(token);
            }
        }
        return stack.pop(); // The final infix expression
    }

    private static boolean isOperator(String token) {
        return "+-*/^".contains(token);
    }
}
