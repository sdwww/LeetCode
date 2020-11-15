package medium;

/**
 * 1405. 最长快乐字符串
 */
public class LongestDiverseString {

    public static void main(String[] args) {
        LongestDiverseString solution = new LongestDiverseString();
        long startTime = System.currentTimeMillis();
        System.out.println(solution.longestDiverseString(7, 1, 0));
        System.out.println("执行时间：" + (System.currentTimeMillis() - startTime));
    }

    public String longestDiverseString(int a, int b, int c) {
        return search(a, b, c, "");
    }

    public String search(int a, int b, int c, String str) {
        if (a > 0 && a >= b && a >= c && !str.endsWith("aa")) {
            return search(a - 1, b, c, str + "a");
        }
        if (b > 0 && b >= a && b >= c && !str.endsWith("bb")) {
            return search(a, b - 1, c, str + "b");
        }
        if (c > 0 && c >= a && c >= b && !str.endsWith("cc")) {
            return search(a, b, c - 1, str + "c");
        }
        if (a > 0 && !str.endsWith("aa")) {
            return search(a - 1, b, c, str + "a");
        }
        if (b > 0 && !str.endsWith("bb")) {
            return search(a, b - 1, c, str + "b");
        }
        if (c > 0 && !str.endsWith("cc")) {
            return search(a, b, c - 1, str + "c");
        }
        return str;
    }
}
