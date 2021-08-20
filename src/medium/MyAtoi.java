package medium;

/**
 * 8. 字符串转换整数 (atoi)
 */
public class MyAtoi {

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        int i = myAtoi.myAtoi("  +  413");
        System.out.println(i);
    }

    public int myAtoi(String s) {
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
