import java.util.Stack;
 
public class InfixToPostfix {
 
    private static int precedence(char operator) {
        switch (operator) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }
 
   
    public static String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
 
        for (int i = 0; i < expression.length(); i++) {
            char token = expression.charAt(i);
 
            if (Character.isLetterOrDigit(token)) {
                postfix.append(token);
            }
           
            else if (token == '(') {
                stack.push(token);
            }
           
            else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            }
           
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    postfix.append(stack.pop());
                }
                stack.push(token);
            }
        }
 
       
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
 
        return postfix.toString();
    }
 
        public static void main(String[] args) {
        String infixExpression = "-A*B*C";
        String postfixExpression = infixToPostfix(infixExpression);
 
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}