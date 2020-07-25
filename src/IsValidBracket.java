import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class IsValidBracket {

    public static void main(String[] args) {
        IsValidBracket solution = new IsValidBracket();
        System.out.println(solution.isValid(")]"));
    }


    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == '}' && (stack.empty() || stack.pop() != '{')) {
                return false;
            }
            if (s.charAt(i) == ']' && (stack.empty() || stack.pop() != '[')) {
                return false;
            }
            if (s.charAt(i) == ')' && (stack.empty() || stack.pop() != '(')) {
                return false;
            }
        }
        return stack.empty();
    }
}
