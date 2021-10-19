package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 8. 字符串转换整数 (atoi)
 */
public class MyAtoi {

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        int i = myAtoi.myAtoi("  -1000000+666");
        System.out.println(i);
    }

    // 状态机
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        for (int i = 0; i < s.length(); i++) {
            automaton.search(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.answer);
    }

    private static class Automaton {
        public int sign = 1;
        public long answer = 0;
        private String state = "start";
        private static final Map<String, String[]> MAP = new HashMap<>();

        static {
            MAP.put("start", new String[]{"start", "signed", "inNumber", "end"});
            MAP.put("signed", new String[]{"end", "end", "inNumber", "end"});
            MAP.put("inNumber", new String[]{"end", "end", "inNumber", "end"});
            MAP.put("end", new String[]{"end", "end", "end", "end"});
        }

        public void search(char c) {
            state = MAP.get(state)[getIndex(c)];
            if ("inNumber".equals(state)) {
                answer = answer * 10 + c - '0';
                if (sign == 1) {
                    answer = Math.min(answer, Integer.MAX_VALUE);
                } else {
                    answer = Math.min(answer, -(long) Integer.MIN_VALUE);
                }
            }
            if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int getIndex(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }

    public int myAtoi1(String s) {
        int result = 0;
        // 是否是开头
        boolean start = false;
        // 是否是正数
        boolean positive = true;
        // 是否有符号
        boolean hasSignal = false;
        for (int i = 0; i < s.length(); i++) {
            // 头部遇到空格忽略
            if (!start && !hasSignal && s.charAt(i) == ' ') {
                continue;
            }
            if (!start && !hasSignal && s.charAt(i) == '+') {
                hasSignal = true;
                continue;
            }
            if (!start && !hasSignal && s.charAt(i) == '-') {
                positive = false;
                hasSignal = true;
                continue;
            }
            // 遇到小写字母中断
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                break;
            }
            // 遇到大写字母中断
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                break;
            }
            // 遇到.中断
            if (s.charAt(i) == '.') {
                break;
            }
            // 中间遇到空格中断
            if ((start || hasSignal) && s.charAt(i) == ' ') {
                break;
            }
            // 后面的+-号中断
            if ((start || hasSignal) && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                break;
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (hasSignal && !positive) {
                    // 负数越界问题
                    if ((long) result * -10 - (s.charAt(i) - 48) < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    // 正数越界问题
                    if ((long) result * 10 + (s.charAt(i) - 48) > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
                result = result * 10 + (s.charAt(i) - 48);
                start = true;
            }
        }
        return positive ? result : -result;
    }
}
