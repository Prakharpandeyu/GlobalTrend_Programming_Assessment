import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // Push opening brackets onto the stack
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false; // Closing bracket with no matching opening bracket
                }
                char top = stack.pop(); // Pop the top of the stack
                
                // Check if the popped opening bracket matches the current closing bracket
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // After iterating through the string, stack should be empty for valid parentheses
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        ValidParentheses validator = new ValidParentheses();
        
        // Example usage:
        String input1 = "(){}[]";
        System.out.println(input1 + " is valid: " + validator.isValid(input1));
        
        String input2 = "([{}])";
        System.out.println(input2 + " is valid: " + validator.isValid(input2));
        
        String input3 = "([)]";
        System.out.println(input3 + " is valid: " + validator.isValid(input3));
    }
}
