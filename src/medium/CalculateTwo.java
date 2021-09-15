package medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 227. 基本计算器 II
 *
 * @author wangweiwei
 */
public class CalculateTwo {

    public static void main(String[] args) {
        CalculateTwo calculateTwo = new CalculateTwo();
        int calculate = calculateTwo.calculate("1-2+3-4");
        System.out.println(calculate);
    }

    public int calculate(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        s = s.replace(" ", "");
        numStack.push(nextNum(0, s));
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                int num1 = numStack.pop();
                int num2 = nextNum(i + 1, s);
                numStack.push(num1 * num2);
            }
            if (s.charAt(i) == '/') {
                int num1 = numStack.pop();
                int num2 = nextNum(i + 1, s);
                numStack.push(num1 / num2);
            }
            if (s.charAt(i) == '+') {
                numStack.push(nextNum(i + 1, s));
            }
            // 精髓，减号存成负数
            if (s.charAt(i) == '-') {
                numStack.push(-nextNum(i + 1, s));
            }
        }
        // 只剩下加法，从右往左处理
        while (numStack.size() > 1) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int result = num1 + num2;
            numStack.push(result);
        }
        return numStack.pop();
    }

    // 获取下一个数
    private int nextNum(int startIndex, String s) {
        int endIndex = -1;
        for (int i = startIndex + 1; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                continue;
            }
            endIndex = i;
            break;
        }
        endIndex = endIndex == -1 ? s.length() : endIndex;
        return Integer.parseInt(s.substring(startIndex, endIndex));
    }
}