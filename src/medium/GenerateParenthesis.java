package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis solution = new GenerateParenthesis();
        solution.generateParenthesis(10).forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, n, result, "");
        return result;
    }

    private void generate(int left, int right, int n, List<String> result, String string) {
        if (left == n && right == n) {
            result.add(string);
            return;
        }
        if (left < right) {
            return;
        }
        if (left > n) {
            return;
        }
        generate(left + 1, right, n, result, string + "(");
        generate(left, right + 1, n, result, string + ")");
    }
}
